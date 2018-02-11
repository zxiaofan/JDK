/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the Java binding of the OMG CORBA APIs, and the RMI-IIOP API.
 *
 * <p> This module is upgradeable.
 *
 * @moduleGraph
 * @since 9
 */
@Deprecated(since="9", forRemoval=true)
module java.corba {
    requires java.logging;
    requires java.naming;
    requires java.transaction;
    requires jdk.unsupported;

    requires transitive java.desktop;
    requires transitive java.rmi;

    exports javax.activity;
    exports javax.rmi;
    exports javax.rmi.CORBA;
    exports org.omg.CORBA;
    exports org.omg.CORBA.DynAnyPackage;
    exports org.omg.CORBA.ORBPackage;
    exports org.omg.CORBA.TypeCodePackage;
    exports org.omg.CORBA.portable;
    exports org.omg.CORBA_2_3;
    exports org.omg.CORBA_2_3.portable;
    exports org.omg.CosNaming;
    exports org.omg.CosNaming.NamingContextExtPackage;
    exports org.omg.CosNaming.NamingContextPackage;
    exports org.omg.Dynamic;
    exports org.omg.DynamicAny;
    exports org.omg.DynamicAny.DynAnyFactoryPackage;
    exports org.omg.DynamicAny.DynAnyPackage;
    exports org.omg.IOP;
    exports org.omg.IOP.CodecFactoryPackage;
    exports org.omg.IOP.CodecPackage;
    exports org.omg.Messaging;
    exports org.omg.PortableInterceptor;
    exports org.omg.PortableInterceptor.ORBInitInfoPackage;
    exports org.omg.PortableServer;
    exports org.omg.PortableServer.CurrentPackage;
    exports org.omg.PortableServer.POAManagerPackage;
    exports org.omg.PortableServer.POAPackage;
    exports org.omg.PortableServer.ServantLocatorPackage;
    exports org.omg.PortableServer.portable;
    exports org.omg.SendingContext;
    exports org.omg.stub.java.rmi;

    // rmic --iiop
    exports com.sun.corba.se.impl.util to jdk.rmic;

    // JNDI CosNaming provider
    opens com.sun.jndi.cosnaming to java.naming;  // jndiprovider.properties
    exports com.sun.jndi.url.corbaname to java.naming;
    exports com.sun.jndi.url.iiop to java.naming;
    exports com.sun.jndi.url.iiopname to java.naming;
}
