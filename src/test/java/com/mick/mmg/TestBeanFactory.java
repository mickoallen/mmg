package com.mick.mmg;

import io.micronaut.context.annotation.Factory;

@Factory
public class TestBeanFactory {
//    @Context
//    @Bean
//    @Singleton
//    @Primary
//    public Configuration provideJooqConfiguration() throws URISyntaxException {
//        System.getProperties().setProperty("org.jooq.no-logo", "true");
//        PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer();
//        String initScriptPath = "file:" + System.getProperty("user.dir") + "/schema/create_db_postgres.sql";
//
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setJdbcUrl("jdbc:tc:postgresql:9.6.8:///postgres?TC_INITSCRIPT=" + initScriptPath);
//        hikariConfig.setUsername(postgreSQLContainer.getUsername());
//        hikariConfig.setPassword(postgreSQLContainer.getPassword());
//        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
//
//        return new DefaultConfiguration()
//                .set(SQLDialect.POSTGRES)
//                .set(hikariDataSource);
//    }
}
