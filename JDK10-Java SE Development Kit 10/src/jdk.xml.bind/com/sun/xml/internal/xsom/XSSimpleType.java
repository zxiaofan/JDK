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

import com.sun.xml.internal.xsom.visitor.XSSimpleTypeFunction;
import com.sun.xml.internal.xsom.visitor.XSSimpleTypeVisitor;

import java.util.List;

/**
 * Simple type.
 *
 * @author
 *  Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface XSSimpleType extends XSType, XSContentType
{
    /**
     * Gets the base type as XSSimpleType.
     *
     * Equivalent to
     * <code>
     * (XSSimpleType)getBaseType()
     * </code>
     * Since this is a simple type, we know that the base type
     * is also a simple type.
     *
     * The only exception is xs:anySimpleType, which has xs:anyType
     * as the base type.
     *
     * @return
     *      null if this is xs:anySimpleType. Otherwise non-null.
     */
    XSSimpleType getSimpleBaseType();

    /**
     * Gets the variety of this simple type.
     */
    XSVariety getVariety();

    /**
     * Gets the ancestor primitive {@link XSSimpleType} if
     * this type is {@link XSVariety#ATOMIC atomic}.
     *
     * @return
     *      null otherwise.
     */
    XSSimpleType getPrimitiveType();

    /**
     * Returns true if this is a primitive built-in simple type
     * (that directly derives from xs:anySimpleType, by definition.)
     */
    boolean isPrimitive();

    /**
     * Gets the nearest ancestor {@link XSListSimpleType} (including itself)
     * if the variety of this type is {@link XSVariety#LIST list}.
     *
     * @return otherwise return null
     */
    XSListSimpleType getBaseListType();

    /**
     * Gets the nearest ancestor {@link XSUnionSimpleType} (including itself)
     * if the variety of this type is {@link XSVariety#UNION union}.
     *
     * @return otherwise return null
     */
    XSUnionSimpleType getBaseUnionType();

    /**
     * Returns true if this type definition is marked as 'final'
     * with respect to the given {@link XSVariety}.
     *
     * @return
     *      true if the type is marked final.
     */
    boolean isFinal(XSVariety v);

    /**
     * If this {@link XSSimpleType} is redefined by another simple type,
     * return that component.
     *
     * @return null
     *      if this component has not been redefined.
     */
    public XSSimpleType getRedefinedBy();

    /**
     * Gets the effective facet object of the given name.
     *
     * <p>
     * For example, if a simple type "foo" is derived from
     * xs:string by restriction with the "maxLength" facet and
     * another simple type "bar" is derived from "foo" by
     * restriction with another "maxLength" facet, this method
     * will return the latter one, because that is the most
     * restrictive, effective facet.
     *
     * <p>
     * For those facets that can have multiple values
     * (pattern facets and enumeration facets), this method
     * will return only the first one.
     * TODO: allow clients to access all of them by some means.
     *
     * @return
     *      If this datatype has a facet of the given name,
     *      return that object. If the facet is not specified
     *      anywhere in its derivation chain, null will be returned.
     */
    XSFacet getFacet( String name );

    /**
     * For multi-valued facets (enumeration and pattern), obtain all values.
     *
     * @see #getFacet(String)
     *
     * @return
     *      can be empty but never null.
     */
    List<XSFacet> getFacets( String name );



    void visit( XSSimpleTypeVisitor visitor );
    <T> T apply( XSSimpleTypeFunction<T> function );

    /** Returns true if <code>this instanceof XSRestrictionSimpleType</code>. */
    boolean isRestriction();
    /** Returns true if <code>this instanceof XSListSimpleType</code>. */
    boolean isList();
    /** Returns true if <code>this instanceof XSUnionSimpleType</code>. */
    boolean isUnion();

    XSRestrictionSimpleType asRestriction();
    XSListSimpleType asList();
    XSUnionSimpleType asUnion();
}
