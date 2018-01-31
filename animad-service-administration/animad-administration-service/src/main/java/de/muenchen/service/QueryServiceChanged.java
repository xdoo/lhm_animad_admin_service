
package de.muenchen.service;

import java.util.*;
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
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class QueryServiceChanged {
    @PersistenceContext
    EntityManager entityManager;

    public QueryServiceChanged() {
    }

    public <E extends BaseEntity> List<E> query(String text, Class<E> entity, String[] properties) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(entity).get();
        Query query = queryBuilder.keyword().fuzzy().onFields(properties).matching(text).createQuery();
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, new Class[]{entity});
        return jpaQuery.getResultList();
    }

    public <E extends BaseEntity> List<E> queryGitLike(String text, Class<E> entity, String[] properties) {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(this.entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(entity).get();

        List<String> props = new ArrayList<>();
        String[] queries;

        Query query = null;
        BooleanJunction boolJunction = queryBuilder.bool();

        // Loop over all queries and join them together
        queries = text.split(" ");
        for (int i = 0; i < queries.length; i++) {
            query = createSingleQuery(queries[i], queryBuilder, properties);
            boolJunction = boolJunction.must(query);
        }

        query = boolJunction.createQuery();
        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, new Class[]{entity});
        return jpaQuery.getResultList();
    }

    private Query createSingleQuery(String text, QueryBuilder queryBuilder, String[] properties) {
        Query query;
        String[] termValues;

        if (text.contains(":")) {
            // if query equals to fieldName:value use Term to search
            termValues = text.split(":");
            query = new TermQuery(new Term(termValues[0], termValues[1]));
        }
        else {
            // Otherwise search in all fields
            query = queryBuilder.keyword().onFields(properties).matching(text).createQuery();
        }

        return query;
    }

}
