package com.redbeeconf.mongoliquibase.config;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class LiquibaseMongodbConfig implements InitializingBean {
    @Value("${spring.liquibase.url}")
    private String uri;

    @Value("${spring.liquibase.change-log}")
    private Resource resource;

    @Value("${spring.liquibase.username}")
    private String username;

    @Value("${spring.liquibase.password}")
    private String password;

    @Value("${spring.liquibase.context}")
    private String context;


    @Override
    public void afterPropertiesSet() throws Exception {
        MongoLiquibaseDatabase openDatabase = (MongoLiquibaseDatabase) DatabaseFactory.getInstance().openDatabase(uri, username, password, null, null);
        openDatabase.setSupportsValidator(false);
        String changelogMaster = ((ClassPathResource) resource).getPath();
        new Liquibase(
                changelogMaster,
                new ClassLoaderResourceAccessor(),
                openDatabase
        ).update(context);
    }
}
