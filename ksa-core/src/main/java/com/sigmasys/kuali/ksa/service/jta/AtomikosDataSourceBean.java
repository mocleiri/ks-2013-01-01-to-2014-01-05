package com.sigmasys.kuali.ksa.service.jta;

import com.atomikos.jdbc.nonxa.AtomikosNonXADataSourceBean;

import java.sql.SQLException;

/**
 * AtomikosDataSourceBean
 *
 * @author Michael Ivanov
 */
public class AtomikosDataSourceBean extends AtomikosNonXADataSourceBean {

    private static int counter;

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }


    @Override
    public synchronized void setUniqueResourceName(String resourceName) {
        super.setUniqueResourceName(resourceName + counter++);
    }
}
