/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the full API of the Java SE Platform.
 * <P>
 * This module requires the <a href="java.se-summary.html">{@code java.se}</a>
 * module and supplements it with modules that define the CORBA and Java EE
 * APIs. These modules are upgradeable.
 *
 * @moduleGraph
 * @since 9
 */
// suppress warning for java.corba and other modules
@SuppressWarnings({"deprecation", "removal"})
@Deprecated(since="9", forRemoval=true)
module java.se.ee {

    requires transitive java.se;

    // Upgradeable modules for Java EE technologies
    requires transitive java.activation;
    requires transitive java.corba;
    requires transitive java.transaction;
    requires transitive java.xml.bind;
    requires transitive java.xml.ws;
    requires transitive java.xml.ws.annotation;

}
