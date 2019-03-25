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
 * Defines the Java Management Extensions (JMX) API.
 * <P>
 * The JMX API consists of interfaces for monitoring and management of the
 * JVM and other components in the Java runtime.
 *
 * @uses javax.management.remote.JMXConnectorProvider
 * @uses javax.management.remote.JMXConnectorServerProvider
 *
 * @moduleGraph
 * @since 9
 */
module java.management {

    exports java.lang.management;
    exports javax.management;
    exports javax.management.loading;
    exports javax.management.modelmbean;
    exports javax.management.monitor;
    exports javax.management.openmbean;
    exports javax.management.relation;
    exports javax.management.remote;
    exports javax.management.timer;

    exports com.sun.jmx.remote.internal to
        java.management.rmi,
        jdk.management.agent;
    exports com.sun.jmx.remote.security to
        java.management.rmi,
        jdk.management.agent;
    exports com.sun.jmx.remote.util to
        java.management.rmi;
    exports sun.management to
        jdk.jconsole,
        jdk.management,
        jdk.management.agent;
    exports sun.management.counter to
        jdk.management.agent;
    exports sun.management.counter.perf to
        jdk.management.agent;
    exports sun.management.spi to
        jdk.management,
        jdk.management.jfr;

    uses javax.management.remote.JMXConnectorProvider;
    uses javax.management.remote.JMXConnectorServerProvider;
    uses sun.management.spi.PlatformMBeanProvider;

    provides javax.security.auth.spi.LoginModule with
        com.sun.jmx.remote.security.FileLoginModule;
}
