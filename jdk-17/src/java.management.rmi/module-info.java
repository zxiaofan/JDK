/*
 * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the {@linkplain javax.management.remote.rmi RMI connector}
 * for the Java Management Extensions (JMX) Remote API.
 *
 * <dl class="notes">
 * <dt>Providers:</dt>
 * <dd>This module provides the
 * {@link javax.management.remote.JMXConnectorProvider} service,
 * which creates JMX connector clients using the RMI protocol.
 * Instances of {@code JMXConnector} can be obtained via the
 * {@link javax.management.remote.JMXConnectorFactory#newJMXConnector
 * JMXConnectorFactory.newJMXConnector} factory method.
 * It also provides the {@link javax.management.remote.JMXConnectorServerProvider} service,
 * which creates JMX connector servers using the RMI protocol.
 * Instances of {@code JMXConnectorServer} can be obtained via the
 * {@link javax.management.remote.JMXConnectorServerFactory#newJMXConnectorServer
 * JMXConnectorServerFactory.newJMXConnectorServer} factory method.
 * </dd>
 * </dl>
 *
 * @provides javax.management.remote.JMXConnectorProvider
 * @provides javax.management.remote.JMXConnectorServerProvider
 *
 * @moduleGraph
 * @since 9
 */
module java.management.rmi {

    requires java.naming;

    requires transitive java.management;
    requires transitive java.rmi;

    exports javax.management.remote.rmi;

    // The qualified export below is required to preserve backward
    // compatibility for the legacy case where an ordered list
    // of package prefixes can be specified to the factory.
    exports com.sun.jmx.remote.protocol.rmi to java.management;

    // jdk.management.agent needs to create an RMIExporter instance.
    exports com.sun.jmx.remote.internal.rmi to jdk.management.agent;

    // The java.management.rmi module provides implementations
    // of the JMXConnectorProvider and JMXConnectorServerProvider
    // services supporting the RMI protocol.
    provides javax.management.remote.JMXConnectorProvider with
        com.sun.jmx.remote.protocol.rmi.ClientProvider;
    provides javax.management.remote.JMXConnectorServerProvider with
        com.sun.jmx.remote.protocol.rmi.ServerProvider;

}
