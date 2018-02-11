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

/**
 * Object Model that represents customization declarations.
 * <a href="http://relaxngcc.sourceforge.net/">RelaxNGCC</a> is used to parse
 * XML syntax into this representation, and the other parts of XJC will use
 * this object model.
 */
@XmlSchema(elementFormDefault = QUALIFIED, namespace=Const.JAXB_NSURI)
package com.sun.tools.internal.xjc.reader.xmlschema.bindinfo;

import javax.xml.bind.annotation.XmlSchema;

import com.sun.tools.internal.xjc.reader.Const;

import static javax.xml.bind.annotation.XmlNsForm.QUALIFIED;
