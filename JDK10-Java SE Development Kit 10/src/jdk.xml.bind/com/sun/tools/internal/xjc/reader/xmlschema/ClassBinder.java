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

package com.sun.tools.internal.xjc.reader.xmlschema;

import com.sun.tools.internal.xjc.model.CClassInfo;
import com.sun.tools.internal.xjc.model.CElement;
import com.sun.tools.internal.xjc.model.CElementInfo;
import com.sun.xml.internal.xsom.visitor.XSFunction;

/**
 * Marker interface for an object that determines how to map
 * a component to a class. If a component is mapped to a class,
 * this object returns a {@link CClassInfo} pr {@link CElementInfo} object.
 *
 * Otherwise, return null.
 */
interface ClassBinder extends XSFunction<CElement> {
}
