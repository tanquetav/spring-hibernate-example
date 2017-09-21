package com.george.example.tenant;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by george on 9/11/17.
 */
@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    @Autowired
    MultiTenantConnectionBean localMultiTenantConnectionBean;

    private Map<String, DataSource> map;

    public synchronized  void load() {
        if (map==null) {
            map = new HashMap<>();
            map.put("tenant_1", localMultiTenantConnectionBean.getDataSource1());
            map.put("tenant_2", localMultiTenantConnectionBean.getDataSource2());
        }
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return map.get("tenant_1");
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        load();
        DataSource dataSource = map.get(tenantIdentifier);
        return dataSource;
    }
}
