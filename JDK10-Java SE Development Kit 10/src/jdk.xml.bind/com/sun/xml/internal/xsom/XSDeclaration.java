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

package com.sun.xml.internal.xsom;

/**
 * Base interface of all "declarations".
 *
 * @author
 *  Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface XSDeclaration extends XSComponent
{
    /**
     * Target namespace to which this component belongs.
     * <code>""</code> is used to represent the default no namespace.
     */
    String getTargetNamespace();

    /**
     * Gets the (local) name of the declaration.
     *
     * @return null if this component is anonymous.
     */
    String getName();

    /**
     * @deprecated use the isGlobal method, which always returns
     * the opposite of this function. Or the isLocal method.
     */
    boolean isAnonymous();

    /**
     * Returns true if this declaration is a global declaration.
     *
     * Global declarations are those declaration that can be enumerated
     * through the schema object.
     */
    boolean isGlobal();

    /**
     * Returns true if this declaration is a local declaration.
     * Equivalent of <code>!isGlobal()</code>
     */
    boolean isLocal();
}
