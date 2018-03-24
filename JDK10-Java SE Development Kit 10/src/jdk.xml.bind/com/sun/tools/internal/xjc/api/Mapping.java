/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.api;

import java.util.List;

import javax.xml.namespace.QName;

/**
 * JAXB-induced mapping between a Java class
 * and an XML element declaration. A part of the compiler artifacts.
 *
 * <p>
 * To be precise, this is a mapping between two Java classes and an
 * XML element declaration. There's one Java class/interface that
 * represents the element, and there's another Java class/interface that
 * represents the type of the element.
 *
 * The former is called "element representation" and the latter is called
 * "type representation".
 *
 * <p>
 * The {@link Mapping} interface provides operation that lets the caller
 * convert an instance of the element representation to that of the
 * type representation or vice versa.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface Mapping {
    /**
     * Name of the XML element.
     *
     * @return
     *      never be null.
     */
    QName getElement();

    /**
     * Returns the fully-qualified name of the java class for the type of this element.
     *
     * TODO: does this method returns the name of the wrapper bean when it's qualified
     * for the wrapper style? Seems no (consider {@code <xs:element name='foo' type='xs:long' />}),
     * but then how does JAX-RPC captures that bean?
     *
     * @return
     *      never be null.
     */
    TypeAndAnnotation getType();

    /**
     * If this element is a so-called "wrapper-style" element,
     * obtains its member information.
     *
     * <p>
     * The notion of the wrapper style should be defined by the JAXB spec,
     * and ideally it should differ from that of the JAX-RPC only at
     * the point where the JAX-RPC imposes additional restriction
     * on the element name.
     *
     * <p>
     * As of this writing the JAXB spec doesn't define "the wrapper style"
     * and as such the exact definition of what XJC thinks
     * "the wrapper style" isn't spec-ed.
     *
     * <p>
     * Ths returned list includes {@link Property} defined not just
     * in this class but in all its base classes.
     *
     * @return
     *      null if this isn't a wrapper-style element.
     *      Otherwise list of {@link Property}s. The order signifies
     *      the order they appeared inside a schema.
     */
    List<? extends Property> getWrapperStyleDrilldown();
}
