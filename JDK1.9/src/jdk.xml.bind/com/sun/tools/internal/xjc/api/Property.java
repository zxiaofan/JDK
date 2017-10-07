/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

import javax.xml.namespace.QName;

import com.sun.codemodel.internal.JType;

/**
 * Represents a property of a wrapper-style element.
 *
 * <p>
 * Carrys information about one property of a wrapper-style
 * element. This interface is solely intended for the use by
 * the JAX-RPC and otherwise the use is discouraged.
 *
 * <p>
 * REVISIT: use CodeModel.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 * @see Mapping
 */
public interface Property {
    /**
     * The name of the property.
     *
     * <p>
     * This method returns a valid identifier suitable for
     * the use as a variable name.
     *
     * @return
     *      always non-null. Camel-style name like "foo" or "barAndZot".
     *      Note that it may contain non-ASCII characters (CJK, etc.)
     *      The caller is responsible for proper escaping if it
     *      wants to print this as a variable name.
     */
    String name();

    /**
     * The Java type of the property.
     *
     * @return
     *      always non-null.
     *      {@link JType} is a representation of a Java type in a codeModel.
     *      If you just need the fully-qualified class name, call {@link JType#fullName()}.
     */
    JType type();

    /**
     * Name of the XML element that corresponds to the property.
     *
     * <p>
     * Each child of a wrapper style element corresponds with an
     * element, and this method returns that name.
     *
     * @return
     *      always non-null valid {@link QName}.
     */
    QName elementName();

    QName rawName();

}
