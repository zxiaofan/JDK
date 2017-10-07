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

package com.sun.xml.internal.bind.v2.model.impl;

import com.sun.xml.internal.bind.v2.model.annotation.Locatable;
import com.sun.xml.internal.bind.v2.model.annotation.AnnotationSource;
import com.sun.xml.internal.bind.v2.model.core.PropertyInfo;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimePropertyInfo;

/**
 * Exposes the core information that forms a {@link PropertyInfo}.
 */
interface PropertySeed<T,C,F,M> extends Locatable, AnnotationSource {

    /**
     * The name of the property is a spec defined concept --- although it doesn't do
     * so explicitly in anywhere.
     *
     * @see PropertyInfo#getName()
     */
    String getName();


    /**
     * Gets the actual data type of the field.
     *
     * <p>
     * The data of the property is stored by using this type.
     *
     * <p>
     * The difference between the {@link RuntimePropertyInfo#getIndividualType()}
     * and this method is clear when the property is a multi-value property.
     * The {@link RuntimePropertyInfo#getIndividualType()} method returns the type of the item,
     * but this method returns the actual collection type.
     */
    T getRawType();
}
