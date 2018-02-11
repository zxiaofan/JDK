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

import java.util.Iterator;
import java.util.Collection;

/**
 * Common aspect of {@link XSComplexType} and {@link XSAttGroupDecl}
 * as the container of attribute uses/attribute groups.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface XSAttContainer extends XSDeclaration {
    XSWildcard getAttributeWildcard();

    /**
     * Looks for the attribute use with the specified name from
     * all the attribute uses that are directly/indirectly
     * referenced from this component.
     *
     * <p>
     * This is the exact implementation of the "attribute use"
     * schema component.
     */
    XSAttributeUse getAttributeUse( String nsURI, String localName );

    /**
     * Lists all the attribute uses that are directly/indirectly
     * referenced from this component.
     *
     * <p>
     * This is the exact implementation of the "attribute use"
     * schema component.
     */
    Iterator<? extends XSAttributeUse> iterateAttributeUses();

    /**
     * Gets all the attribute uses.
     */
    Collection<? extends XSAttributeUse> getAttributeUses();

    /**
     * Looks for the attribute use with the specified name from
     * the attribute uses which are declared in this complex type.
     *
     * This does not include att uses declared in att groups that
     * are referenced from this complex type, nor does include
     * att uses declared in base types.
     */
    XSAttributeUse getDeclaredAttributeUse( String nsURI, String localName );

    /**
     * Lists all the attribute uses that are declared in this complex type.
     */
    Iterator<? extends XSAttributeUse> iterateDeclaredAttributeUses();

    /**
     * Lists all the attribute uses that are declared in this complex type.
     */
    Collection<? extends XSAttributeUse> getDeclaredAttributeUses();


    /**
     * Iterates all AttGroups which are directly referenced from
     * this component.
     */
    Iterator<? extends XSAttGroupDecl> iterateAttGroups();

    /**
     * Iterates all AttGroups which are directly referenced from
     * this component.
     */
    Collection<? extends XSAttGroupDecl> getAttGroups();
}
