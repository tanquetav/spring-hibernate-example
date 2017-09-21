package com.george.example.tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by george on 9/11/17.
 */
@Component
public class MultiTenantConnectionBean {

    @Autowired
    private DataSource dataSource1;

    @Autowired
    private DataSource dataSource2;

    public DataSource getDataSource1() {
        return dataSource1;
    }

    public DataSource getDataSource2() {
        return dataSource2;
    }
}
