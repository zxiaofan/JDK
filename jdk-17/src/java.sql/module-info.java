/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines the JDBC API.
 *
 * @uses java.sql.Driver
 *
 * @moduleGraph
 * @since 9
 */
module java.sql {
    requires transitive java.logging;
    requires transitive java.transaction.xa;
    requires transitive java.xml;

    exports java.sql;
    exports javax.sql;

    uses java.sql.Driver;
}
