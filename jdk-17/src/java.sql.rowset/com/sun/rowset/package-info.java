/*
 *  Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
 *  ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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

/**
 * Provides five standard implementations of the standard JDBC {@code RowSet} implementation
 * interface definitions. These reference implementations are included with the J2SE version
 * 1.5 platform and represent the benchmark standard {@code RowSet} implementations as verified
 * by the Test Compatibility Kit (TCK) as mandated by the Java Community Process.
 * <br>
 *
 * <h2>1.0 Available JDBC RowSet Reference Implementations </h2>
 * The following implementations are provided:<br>
 *
 * <blockquote><b>{@code JdbcRowSetImpl}</b> - The {@code javax.sql.rowset.JdbcRowSet}
 * interface reference implementation. <br>
 * <br>
 * <b>{@code CachedRowSetImpl}</b> - The {@code javax.sql.rowset.CachedRowSet} interface
 * reference implementation.<br>
 * <br>
 * <b>{@code WebRowSetImpl}</b> - The {@code javax.sql.rowset.WebRowSet} interface
 * reference implementation.<br>
 * <br>
 * <b>{@code FilteredRowSetImpl}</b> - The {@code javax.sql.rowset.FilteredRowSet}
 * interface reference implementation.<br>
 * <br>
 * <b>{@code JoinRowSetImpl}</b> - The {@code javax.sql.rowset.JoinRowSet} interface
 * reference implementation.<br>
 * </blockquote>
 *
 * All details on their expected behavior, including their interactions with the {@code SyncProvider}
 * SPI and helper classes are provided in the interface definitions in the {@code javax.sql.rowset}
 * package specification.<br>
 *
 * <h2>2.0 Usage</h2>
 * The reference implementations represent robust implementations of the standard
 * {@code RowSet} interfaces defined in the {@code javax.sql.rowset} package.
 * All disconnected {@code RowSet} implementations, such as the {@code CachedRowSetImpl}
 * and {@code WebRowSetImpl}, are flexible enough to use the {@code SyncFactory} SPIs to
 * leverage non-reference implementation {@code SyncProvider} implementations to obtain
 * differing synchronization semantics. Furthermore, developers and vendors alike are free
 * to use these implementations and integrate them into their products just as they
 * can with to other components of the Java platform.<br>
 *
 * <h2>3.0 Extending the JDBC RowSet Implementations</h2>
 *
 * The JDBC {@code RowSet} reference implementations are provided as non-final
 * classes so that any developer can extend them to provide additional features
 * while maintaining the core required standard functionality and compatibility. It
 * is anticipated that many vendors and developers will extend the standard feature
 * set to their their particular needs. The website for JDBC Technology will
 * provider a portal where implementations can be listed, similar to the way it
 * provides a site for JDBC drivers.
 */
 package com.sun.rowset;
