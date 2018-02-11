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

package com.sun.xml.internal.bind.v2.model.runtime;

import java.lang.reflect.Type;
import java.util.Collection;

import com.sun.xml.internal.bind.v2.model.core.PropertyInfo;
import com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

/**
 * {@link PropertyInfo} that exposes more information.
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public interface RuntimePropertyInfo extends PropertyInfo<Type,Class> {

    /** {@inheritDoc} */
    Collection<? extends RuntimeTypeInfo> ref();


    /**
     * Gets the {@link Accessor} for this property.
     *
     * <p>
     * Even for a multi-value property, this method returns an accessor
     * to that property. IOW, the accessor works against the raw type.
     *
     * <p>
     * This methods returns unoptimized accessor (because optimization
     * accessors are often combined into bigger pieces, and optimization
     * generally works better if you can look at a bigger piece, as opposed
     * to individually optimize a smaller components)
     *
     * @return
     *      never null.
     *
     * @see Accessor#optimize(JAXBContextImpl)
     */
    Accessor getAccessor();

    /**
     * Returns true if this property has an element-only content. False otherwise.
     */
    public boolean elementOnlyContent();

    /**
     * Gets the "raw" type of the field.
     *
     * The raw type is the actual signature of the property.
     * For example, if the field is the primitive int, this will be the primitive int.
     * If the field is Object, this will be Object.
     * If the property is the collection and typed as {@code Collection<Integer>},
     * this method returns {@code Collection<Integer>}.
     *
     * @return always non-null.
     */
    Type getRawType();

    /**
     * Gets the type of the individual item.
     *
     * The individual type is the signature of the property used to store individual
     * values. For a non-collection field, this is the same as {@link #getRawType()}.
     * For acollection property, this is the type used to store individual value.
     * So if {@link #getRawType()} is {@code Collection<Integer>}, this method will
     * return {@link Integer}.
     *
     * @return always non-null.
     */
    Type getIndividualType();
}
