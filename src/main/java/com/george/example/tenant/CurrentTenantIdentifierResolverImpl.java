package com.george.example.tenant;

import com.george.example.filter.TenantFilter;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

/**
 * Created by george on 9/11/17.
 */
@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {
    @Override
    public String resolveCurrentTenantIdentifier() {
        if("other".equals(TenantFilter.threadLocal.get())) {
            return "tenant_2";
        }
        return "tenant_1";
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
