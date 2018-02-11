/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.rowset;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.WebRowSet;
import javax.sql.rowset.RowSetFactory;

/**
 * This is the implementation specific class for the
 * <code>javax.sql.rowset.spi.RowSetFactory</code>. This is the platform
 * default implementation for the Java SE platform.
 *
 * @author Lance Andersen
 *
 *
 * @version 1.7
 */
public  final class RowSetFactoryImpl implements RowSetFactory {

    public CachedRowSet createCachedRowSet() throws SQLException {
        return new com.sun.rowset.CachedRowSetImpl();
    }

    public FilteredRowSet createFilteredRowSet() throws SQLException {
        return new com.sun.rowset.FilteredRowSetImpl();
    }


    public JdbcRowSet createJdbcRowSet() throws SQLException {
        return new com.sun.rowset.JdbcRowSetImpl();
    }

    public JoinRowSet createJoinRowSet() throws SQLException {
        return new com.sun.rowset.JoinRowSetImpl();
    }

    public WebRowSet createWebRowSet() throws SQLException {
        return new com.sun.rowset.WebRowSetImpl();
    }

}
