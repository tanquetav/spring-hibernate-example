package com.george.example.tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by george on 9/11/17.
 */
@Configuration
public class DataSourceConfig {


    @Autowired
    private MultitenancyProperties multitenancyProperties;

    @Bean(name = {  "dataSource",  "dataSource1" })
    @ConfigurationProperties(prefix = "spring.multitenancy.datasource1")
    public DataSource dataSource1() {
        System.out.println(this.multitenancyProperties.getDatasource1().getUrl());
        DataSourceBuilder factory = DataSourceBuilder
                .create(this.multitenancyProperties.getDatasource1().getClassLoader())
                .driverClassName(this.multitenancyProperties.getDatasource1().getDriverClassName())
                .username(this.multitenancyProperties.getDatasource1().getUsername())
                .password(this.multitenancyProperties.getDatasource1().getPassword())
                .url(this.multitenancyProperties.getDatasource1().getUrl());
        return factory.build();
    }

    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.multitenancy.datasource2")
    public DataSource dataSource2() {
        System.out.println(this.multitenancyProperties.getDatasource2().getUrl());
        DataSourceBuilder factory = DataSourceBuilder
                .create(this.multitenancyProperties.getDatasource2().getClassLoader())
                .driverClassName(this.multitenancyProperties.getDatasource2().getDriverClassName())
                .username(this.multitenancyProperties.getDatasource2().getUsername())
                .password(this.multitenancyProperties.getDatasource2().getPassword())
                .url(this.multitenancyProperties.getDatasource2().getUrl());
        return factory.build();
    }

}
