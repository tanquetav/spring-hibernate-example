package com.george.example.tenant;

import com.george.example.model.Part;
import com.george.example.model.Product;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by george on 9/11/17.
 */
@Configuration
@EnableConfigurationProperties(JpaProperties.class)
public class MultiTenancyJpaConfiguration {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private MultiTenantConnectionProvider multiTenantConnectionProvider;
    @Autowired
    private CurrentTenantIdentifierResolver currentTenantIdentifierResolver;
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, Object> hibernateProps = new LinkedHashMap<>();
        hibernateProps.putAll(jpaProperties.getHibernateProperties(dataSource));

        hibernateProps.put("hibernate.multiTenancy", "DATABASE");
        hibernateProps.put("hibernate.multi_tenant_connection_provider", multiTenantConnectionProvider);
        hibernateProps.put("hibernate.tenant_identifier_resolver", currentTenantIdentifierResolver);
        hibernateProps.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        hibernateProps.put("hibernate.hbm2ddl.auto", "none");
        return builder.dataSource(dataSource)
                .packages(Part.class.getPackage().getName(),Product.class.getPackage().getName())
                .properties(hibernateProps)
                .jta(false)
                .build();
    }

}
