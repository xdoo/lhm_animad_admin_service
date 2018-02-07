
package de.muenchen.service;

import de.muenchen.animad.admin.administration.service.gen.exceptions.TooManyResultsException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class QueryServiceChanged {
    @PersistenceContext
    EntityManager entityManager;
    
    @Value("${service.configuration.maxSearchResults}")
    Integer maxSearchResults;

    public QueryServiceChanged() {
    }

    public <E extends BaseEntity> List<E> query(String text, Class<E> entity, String[] properties) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(entity).get();
        Query query = queryBuilder.keyword().fuzzy().onFields(properties).matching(text).createQuery();
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, new Class[]{entity});
        return jpaQuery.getResultList();
    }

    /* NEW START must be added to existing QueryService*/

    /**
     * Creates Search Query that supports Apache Lucene Terms (single terms and phrases).
     * Not supported are wildcards, Boolean Operators, Fuzzy, Range and Proximity Searches.
     * (see: https://lucene.apache.org/core/2_9_4/queryparsersyntax.html)
     * @param text The given search query containing single terms and phrases.
     * @param entity The entity to search
     * @param properties The fieldnames of the entity that where generated as searchable fields (see Barrakuda documentation)
     * @param <E> The entity type to search for
     * @return A list of entities that where found for the given query
     */
    public <E extends BaseEntity> List<E> queryJunction(String text, Class<E> entity, String[] properties) throws TooManyResultsException {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.entityManager);
            QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(entity).get();

            List<String> props = new ArrayList<>();
//            List<String> queries = new ArrayList<>();
            String[] queries = this.getQueries(text);

            Query query = null;
            BooleanJunction boolJunction = queryBuilder.bool();

            // Loop over all queries and join them together
//            queries = text.split(" ");
            for (int i = 0; i < queries.length; i++) {
                query = createSingleQuery(queries[i], queryBuilder, properties);
                boolJunction = boolJunction.must(query);
            }

            query = boolJunction.createQuery();
            FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, new Class[]{entity});
            if (jpaQuery.getResultSize() > maxSearchResults) throw new TooManyResultsException(maxSearchResults);
            return jpaQuery.getResultList();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("queryJunction: "+ex.getMessage());
            List<E> results = new ArrayList<E>();
            return results;
        }
    }

    /**
     * Splits search text string into queries using regular expression: (\\S*:\".+\"|\"[^\"]+\"|\\S*)(?:\\s*).*
     * Will match the following queries: value, "value with/without blank", fieldName:value, fieldName:"value with/without blank"
     *
     * Example:
     * Search text string "van der Damme" name:"de Blanc" name:Maier Maier
     * will be splitted into: "van der Damme", name:"de Blanc", name:Maier, Maier
     *
     * @param s The search text string
     * @return The search text string splitted into queries
     */
    private String[] getQueries(String s){
        ArrayList<String> l = new ArrayList<String>();
        Pattern p = Pattern.compile("(\\S*:\".+\"|\"[^\"]+\"|\\S*)(?:\\s*).*");
        int start = 0;
        int end = s.length();
        int j = 0;

        Matcher mtch = p.matcher(s);
        while (start < end) {
            mtch.region(start, end);
            mtch.matches();
            j = mtch.groupCount();
            String group = mtch.group(j);
            l.add(group);
            start += (group.length()+1);
        }

        String[] queries = new String[l.size()];
        l.toArray(queries);

        return queries;

    }

    /**
     * Creates a {@link org.apache.lucene.search.Query} for the given term.
     *
     * @param term A lucene term (single term or phrase)
     * @param queryBuilder A builder to create a {@link org.apache.lucene.search.Query} for a single term
     * @param properties The fieldnames of the entity that where generated as searchable fields
     * @return A Query created for the given term
     */
    private Query createSingleQuery(String term, QueryBuilder queryBuilder, String[] properties) {
        Query query;
        String[] termValues = term.split(":");

        if (termValues.length > 1 && termValues[1] != "") {
            // if query equals to fieldName:value use Term to search
            query = new TermQuery(new Term(termValues[0], termValues[1]));
        }
        else {
            // Otherwise search in all fields
            query = queryBuilder.keyword().onFields(properties).matching(term).createQuery();
        }

        return query;
    }
    /* NEW END */

}
