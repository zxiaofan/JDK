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

package com.sun.xml.internal.bind.v2.model.core;

import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlInlineBinaryData;

/**
 * An Enum that indicates if the property is
 * Element, ElementRef, Value, or Attribute.
 *
 * <p>
 * Corresponds to the four different kind of {@link PropertyInfo}.
 * @author Bhakti Mehta (bhakti.mehta@sun.com)
 */
public enum PropertyKind {
    VALUE(true,false,Integer.MAX_VALUE),
    ATTRIBUTE(false,false,Integer.MAX_VALUE),
    ELEMENT(true,true,0),
    REFERENCE(false,true,1),
    MAP(false,true,2),
    ;

    /**
     * This kind of property can have {@link XmlMimeType} and {@link XmlInlineBinaryData}
     * annotation with it.
     */
    public final boolean canHaveXmlMimeType;

    /**
     * This kind of properties need to show up in {@link XmlType#propOrder()}.
     */
    public final boolean isOrdered;

    /**
     * {@code com.sun.xml.internal.bind.v2.runtime.property.PropertyFactory} benefits from having index numbers assigned to
     * {@link #ELEMENT}, {@link #REFERENCE}, and {@link #MAP} in this order.
     */
    public final int propertyIndex;

    PropertyKind(boolean canHaveExpectedContentType, boolean isOrdered, int propertyIndex) {
        this.canHaveXmlMimeType = canHaveExpectedContentType;
        this.isOrdered = isOrdered;
        this.propertyIndex = propertyIndex;
    }
}
