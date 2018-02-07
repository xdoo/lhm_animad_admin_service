package de.muenchen.service.db;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for HikariCP DB pool
 * implementation. 
 * 
 * see https://github.com/brettwooldridge/HikariCP
 * 
 * @author claus
 */
@Configuration
@ComponentScan
public class HikariCPConfiguration {

    /**
     * This property sets the default authentication username used 
     * when obtaining Connections from the underlying driver.
     */
    @Value("${spring.datasource.username:sa}")
    private String username;

    /**
     * This property sets the default authentication password used 
     * when obtaining Connections from the underlying driver.
     */
    @Value("${spring.datasource.password:}")
    private String password;

    /**
     * This property directs HikariCP to use "DriverManager-based" 
     * configuration. 
     */
    @Value("${spring.datasource.url:jdbc:h2:mem:}")
    private String jdbcUrl;

    /**
     * This property represents a user-defined name for the connection
     * pool and appears mainly in logging and JMX management consoles 
     * to identify pools and pool configurations. Default: auto-generated
     */
    @Value("${spring.datasource.poolName:SpringBootHikariCP}")
    private String poolName;
    
    /**
     * This property controls the maximum size that the pool is allowed
     * to reach, including both idle and in-use connections. Basically 
     * this value will determine the maximum number of actual connections to 
     * the database backend. A reasonable value for this is best determined by 
     * your execution environment. When the pool reaches this size, and no idle
     * connections are available, calls to getConnection() will block for up to
     * connectionTimeout milliseconds before timing out. Default: 10
     */
    @Value("${spring.datasource.maximumPoolSize:10}")
    private int maximumPoolSize;
    
    /**
     * This property controls the maximum lifetime of a connection in 
     * the pool. When a connection reaches this timeout it will be retired 
     * from the pool, subject to a maximum variation of +30 seconds. An in-use
     * connection will never be retired, only when it is closed will it then be
     * removed. We strongly recommend setting this value, and it should be at
     * least 30 seconds less than any database-level connection timeout. A 
     * value of 0 indicates no maximum lifetime (infinite lifetime), subject
     * of course to the idleTimeout setting. Default: 1800000 (30 minutes)
     */
    @Value("${spring.datasource.maxLifetime:1800000}")
    private int maxLifetime;
    
    /**
     * This property controls the maximum number of milliseconds that 
     * a client (that's you) will wait for a connection from the pool.
     * If this time is exceeded without a connection becoming available, a 
     * SQLException will be thrown. 1000ms is the minimum value. 
     * Default: 30000 (30 seconds)
     */
    @Value("${spring.datasource.connectionTimeout:30000}")
    private int connectionTimeout;
    
    /**
     * This property controls the maximum amount of time that a 
     * connection is allowed to sit idle in the pool. Whether a 
     * connection is retired as idle or not is subject to a maximum variation
     * of +30 seconds, and average variation of +15 seconds. A connection will
     * never be retired as idle before this timeout. A value of 0 means that 
     * idle connections are never removed from the pool. 
     * Default: 600000 (10 minutes)
     */
    @Value("${spring.datasource.idleTimeout:600000}")
    private int idleTimeout;

    /**
     * Neither of the below parameters have any effect if the cache is
     * in fact disabled, as it is by default. 
     * You must set this parameter to true.
     */
    @Value("${spring.datasource.cachePrepStmts:false}")
    private boolean cachePrepStmts;
    
    /**
     * This sets the number of prepared statements that the MySQL 
     * driver will cache per connection. The default is a conservative 
     * 25. We recommend setting this to between 250-500.
     */
    @Value("${spring.datasource.prepStmtCacheSize:250}")
    private int prepStmtCacheSize;
    
    /**
     * This is the maximum length of a prepared SQL statement that 
     * the driver will cache. The MySQL default is 256. In our experience, 
     * especially with ORM frameworks like Hibernate, this default is well 
     * below the threshold of generated statement lengths. 
     * Our recommended setting is 2048.
     */
    @Value("${spring.datasource.prepStmtCacheSqlLimit:2048}")
    private int prepStmtCacheSqlLimit;
    
    /**
     * This property controls whether the pool will "fail fast" if the
     * pool cannot be seeded with initial connections successfully. 
     * If you want your application to start even when the database is 
     * down/unavailable, set this property to false. Default: true
     */
    @Value("${spring.datasource.initializationFailFast:true}")
    private boolean initializationFailFast;
    
    /**
     * Create data source based on HikariCP.
     * 
     * @return 
     */
    @Bean
    public DataSource defaultDataSource() {
        HikariDataSource ds = new HikariDataSource();
        
        ds.setJdbcUrl(jdbcUrl);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setPoolName(poolName);
        ds.setMaximumPoolSize(maximumPoolSize);
        ds.setMaxLifetime(maxLifetime);
        ds.setConnectionTimeout(connectionTimeout);
        ds.setIdleTimeout(idleTimeout);
        ds.setInitializationFailFast(initializationFailFast);
        ds.addDataSourceProperty("cachePrepStmts", cachePrepStmts);
        ds.addDataSourceProperty("prepStmtCacheSize", prepStmtCacheSize);
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", prepStmtCacheSqlLimit);
        
        return ds;
    }

}

