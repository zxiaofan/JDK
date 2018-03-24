/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.generator.annotation.spec;

import javax.xml.bind.annotation.XmlType;
import com.sun.codemodel.internal.JAnnotationWriter;
import com.sun.codemodel.internal.JType;

/**
 * <p><b>
 *     Auto-generated, do not edit.
 * </b></p>
 */
public interface XmlTypeWriter
    extends JAnnotationWriter<XmlType>
{


    XmlTypeWriter name(String value);

    XmlTypeWriter namespace(String value);

    XmlTypeWriter propOrder(String value);

    XmlTypeWriter factoryClass(Class value);

    XmlTypeWriter factoryClass(JType value);

    XmlTypeWriter factoryMethod(String value);

}
