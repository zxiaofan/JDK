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
 * Defines the Java Architecture for XML Binding (JAXB) API.
 *
 * <p> This module is upgradeable.
 *
 * @uses javax.xml.bind.JAXBContextFactory
 *
 * @moduleGraph
 * @since 9
 */
@Deprecated(since="9", forRemoval=true)
module java.xml.bind {
    requires java.compiler;
    requires java.desktop;
    requires java.logging;
    requires jdk.unsupported;

    requires transitive java.activation;
    requires transitive java.xml;

    exports javax.xml.bind;
    exports javax.xml.bind.annotation;
    exports javax.xml.bind.annotation.adapters;
    exports javax.xml.bind.attachment;
    exports javax.xml.bind.helpers;
    exports javax.xml.bind.util;

    exports com.sun.istack.internal to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.istack.internal.localization to
        java.xml.ws,
        jdk.xml.ws;
    exports com.sun.istack.internal.logging to
        java.xml.ws,
        jdk.xml.ws;
    exports com.sun.xml.internal.bind to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.bind.annotation to
        jdk.xml.bind;
    exports com.sun.xml.internal.bind.api to
        java.xml.ws,
        jdk.xml.bind;
    exports com.sun.xml.internal.bind.api.impl to
        java.xml.ws,
        jdk.xml.bind;
    exports com.sun.xml.internal.bind.marshaller to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.bind.unmarshaller to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.bind.util to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.bind.v2 to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.bind.v2.model.annotation to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.bind.v2.model.core to
        jdk.xml.bind;
    exports com.sun.xml.internal.bind.v2.model.impl to
        jdk.xml.bind;
    exports com.sun.xml.internal.bind.v2.model.nav to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    opens com.sun.xml.internal.bind.v2.model.nav to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.bind.v2.model.runtime to
        java.xml.ws;
    exports com.sun.xml.internal.bind.v2.model.util to
        jdk.xml.bind;
    exports com.sun.xml.internal.bind.v2.runtime to
        java.xml.ws,
        jdk.xml.bind;
    exports com.sun.xml.internal.bind.v2.runtime.unmarshaller to
        java.xml.ws;
    exports com.sun.xml.internal.bind.v2.schemagen to
        java.xml.ws,
        jdk.xml.bind;
    exports com.sun.xml.internal.bind.v2.schemagen.episode to
        jdk.xml.bind;
    exports com.sun.xml.internal.bind.v2.schemagen.xmlschema to
        java.xml.ws;
    exports com.sun.xml.internal.bind.v2.util to
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.fastinfoset to
        java.xml.ws;
    exports com.sun.xml.internal.fastinfoset.stax to
        java.xml.ws;
    exports com.sun.xml.internal.fastinfoset.vocab to
        java.xml.ws;
    exports com.sun.xml.internal.org.jvnet.fastinfoset to
        java.xml.ws;
    exports com.sun.xml.internal.org.jvnet.mimepull to
        java.xml.ws;
    exports com.sun.xml.internal.org.jvnet.staxex to
        java.xml.ws;
    exports com.sun.xml.internal.org.jvnet.staxex.util to
        java.xml.ws;
    exports com.sun.xml.internal.txw2 to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.txw2.annotation to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;
    exports com.sun.xml.internal.txw2.output to
        java.xml.ws,
        jdk.xml.bind,
        jdk.xml.ws;

    uses javax.xml.bind.JAXBContextFactory;

}
