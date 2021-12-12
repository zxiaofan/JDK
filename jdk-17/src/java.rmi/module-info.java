/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the Remote Method Invocation (RMI) API.
 *
 * <p> The JDK implementation of this module includes
 * the <em>{@index rmiregistry rmiregistry tool}</em> tool to start a remote
 * object registry.
 *
 * @toolGuide rmiregistry
 *
 * @uses java.rmi.server.RMIClassLoaderSpi
 *
 * @moduleGraph
 * @since 9
 */
module java.rmi {
    requires java.logging;

    exports java.rmi;
    exports java.rmi.dgc;
    exports java.rmi.registry;
    exports java.rmi.server;
    exports javax.rmi.ssl;

    exports sun.rmi.registry to
        jdk.management.agent;
    exports sun.rmi.server to
        java.management.rmi,
        jdk.management.agent,
        jdk.jconsole;
    exports sun.rmi.transport to
        java.management.rmi,
        jdk.management.agent,
        jdk.jconsole;

    uses java.rmi.server.RMIClassLoaderSpi;
}
