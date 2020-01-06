package com.mick.mmg.db;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Property;

/**
 * Configuration for db connection
 */
@ConfigurationProperties("db")
public class DatabaseConfig {

    @Property(name = "url")
    private String url;

    @Property(name = "database-name")
    private String databaseName;

    public DatabaseConfig() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}
