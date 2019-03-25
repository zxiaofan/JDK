/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * object registry, and the <em>{@index rmid rmid tool}</em> tool to start
 * the activation system daemon.
 *
 * <dl style="font-family:'DejaVu Sans', Arial, Helvetica, sans serif">
 * <dt class="simpleTagLabel">Tool Guides:</dt>
 * <dd> {@extLink rmiregistry_tool_reference rmiregistry},
 *      {@extLink rmid_tool_reference rmid}
 * </dd>
 * </dl>
 *
 * @uses java.rmi.server.RMIClassLoaderSpi
 *
 * @moduleGraph
 * @since 9
 */
module java.rmi {
    requires java.logging;

    exports java.rmi;
    exports java.rmi.activation;
    exports java.rmi.dgc;
    exports java.rmi.registry;
    exports java.rmi.server;
    exports javax.rmi.ssl;

    // com.sun.rmi.rmid contains permissions classes that must be
    // accessible to the security manager at initialization time
    exports com.sun.rmi.rmid to java.base;
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
