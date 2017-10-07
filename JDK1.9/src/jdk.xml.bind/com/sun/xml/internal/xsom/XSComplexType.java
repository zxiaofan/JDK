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

import java.util.List;


/**
 * Complex type.
 *
 * @author
 *  Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface XSComplexType extends XSType, XSAttContainer
{
    /**
     * Checks if this complex type is declared as an abstract type.
     */
    boolean isAbstract();

    boolean isFinal(int derivationMethod);
    /**
     * Roughly corresponds to the block attribute. But see the spec
     * for gory detail.
     */
    boolean isSubstitutionProhibited(int method);

    /**
     * Gets the scope of this complex type.
     * This is not a property defined in the schema spec.
     *
     * @return
     *      null if this complex type is global. Otherwise
     *      return the element declaration that contains this anonymous
     *      complex type.
     */
    XSElementDecl getScope();

    /**
     * The content of this complex type.
     *
     * @return
     *      always non-null.
     */
    XSContentType getContentType();

    /**
     * Gets the explicit content of a complex type with a complex content
     * that was derived by extension.
     *
     * <p>
     * Informally, the "explicit content" is the portion of the
     * content model added in this derivation. IOW, it's a delta between
     * the base complex type and this complex type.
     *
     * <p>
     * For example, when a complex type T2 derives fom T1, then:
     * <pre>
     * content type of T2 = SEQUENCE( content type of T1, explicit content of T2 )
     * </pre>
     *
     * @return
     *      If this complex type is derived by restriction or has a
     *      simple content, this method returns null.
     *      IOW, this method only works for a complex type with
     *      a complex content derived by extension from another complex type.
     */
    XSContentType getExplicitContent();

    // meaningful only if getContentType returns particles
    boolean isMixed();

    /**
     * If this {@link XSComplexType} is redefined by another complex type,
     * return that component.
     *
     * @return null
     *      if this component has not been redefined.
     */
    public XSComplexType getRedefinedBy();

    /**
     * Returns a list of direct subtypes of this complex type. If the type is not subtyped, returns empty list.
     * Doesn't return null.
     * Note that the complex type may be extended outside of the scope of the schemaset known to XSOM.
     * @return
     */
    public List<XSComplexType> getSubtypes();

    /**
     * Returns a list of element declarations of this type.
     * @return
     */
    public List<XSElementDecl> getElementDecls();

}
