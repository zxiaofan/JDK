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

package com.sun.xml.internal.bind.v2.runtime.property;

import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.util.QNameMap;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.ChildLoader;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.StructureLoader;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.ValuePropertyLoader;

/**
 * Component that contributes element unmarshallers into
 * {@link StructureLoader}.
 *
 * TODO: think of a better name.
 *
 * @author Bhakti Mehta
 */
public interface StructureLoaderBuilder {
    /**
     * Every Property class has an implementation of buildChildElementUnmarshallers
     * which will fill in the specified {@link QNameMap} by elements that are expected
     * by this property.
     */
    void buildChildElementUnmarshallers(UnmarshallerChain chain, QNameMap<ChildLoader> handlers);

    /**
     * Magic {@link QName} used to store a handler for the text.
     *
     * <p>
     * To support the mixed content model, {@link StructureLoader} can have
     * at most one {@link ValuePropertyLoader} for processing text
     * found amoung elements.
     *
     * This special text handler is put into the {@link QNameMap} parameter
     * of the {@link #buildChildElementUnmarshallers} method by using
     * this magic token as the key.
     */
    public static final QName TEXT_HANDLER = new QName("\u0000","text");

    /**
     * Magic {@link QName} used to store a handler for the rest of the elements.
     *
     * <p>
     * To support the wildcard, {@link StructureLoader} can have
     * at most one {@link Loader} for processing elements
     * that didn't match any of the named elements.
     *
     * This special text handler is put into the {@link QNameMap} parameter
     * of the {@link #buildChildElementUnmarshallers} method by using
     * this magic token as the key.
     */
    public static final QName CATCH_ALL = new QName("\u0000","catchAll");
}
