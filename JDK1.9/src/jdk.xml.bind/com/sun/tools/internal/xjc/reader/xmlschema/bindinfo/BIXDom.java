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

package com.sun.tools.internal.xjc.reader.xmlschema.bindinfo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.tools.internal.xjc.reader.Const;

/**
 * Compatibility with 1.0.
 *
 * Read {@code <xjc:dom> as <jaxb:dom>}.
 *
 * @author Kohsuke Kawaguchi
 */
@XmlRootElement(name="dom",namespace=Const.XJC_EXTENSION_URI)
public class BIXDom extends BIDom {

    // unsupported yet
    @XmlAttribute
    String type = "w3c";
}
