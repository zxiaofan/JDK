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
 * Attribute use.
 *
 * @author
 *  Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface XSAttributeUse extends XSComponent
{
    boolean isRequired();
    XSAttributeDecl getDecl();

    /**
     * Gets the default value of this attribute use, if one is specified.
     *
     * Note that if a default value is specified in the attribute
     * declaration, this method returns that value.
     */
    XmlString getDefaultValue();

    /**
     * Gets the fixed value of this attribute use, if one is specified.
     *
     * Note that if a fixed value is specified in the attribute
     * declaration, this method returns that value.
     */
    XmlString getFixedValue();
}
