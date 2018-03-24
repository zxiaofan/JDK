/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.reader.xmlschema.bindinfo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

import com.sun.tools.internal.xjc.reader.Const;

/**
 * Forces a non-collapsing behavior to allow extension schemas
 * to perform element substitutions.
 *
 * See https://github.com/javaee/jaxb-v2/issues/289
 *
 * @author Kohsuke Kawaguchi
 * @since 2.1.1
 */
@XmlRootElement(name="substitutable",namespace= Const.XJC_EXTENSION_URI)
public final class BIXSubstitutable extends AbstractDeclarationImpl {
    public final QName getName() { return NAME; }

    /** Name of the conversion declaration. */
    public static final QName NAME = new QName(Const.XJC_EXTENSION_URI,"substitutable");
}
