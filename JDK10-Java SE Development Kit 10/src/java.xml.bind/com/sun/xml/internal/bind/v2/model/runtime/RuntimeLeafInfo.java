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

package com.sun.xml.internal.bind.v2.model.runtime;

import java.lang.reflect.Type;

import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.model.core.LeafInfo;
import com.sun.xml.internal.bind.v2.runtime.Transducer;

/**
 * @author Kohsuke Kawaguchi
 */
public interface RuntimeLeafInfo extends LeafInfo<Type,Class>, RuntimeNonElement {
    /**
     * {@inheritDoc}
     *
     * @return
     *      always non-null.
     */
    <V> Transducer<V> getTransducer();

    /**
     * The same as {@link #getType()} but returns the type as a {@link Class}.
     * <p>
     * Note that the returned {@link Class} object does not necessarily represents
     * a class declaration. It can be primitive types.
     */
    Class getClazz();

    /**
     * Returns all the type names recognized by this type for unmarshalling.
     *
     * <p>
     * While conceptually this method belongs to {@link RuntimeNonElement},
     * if we do that we have to put a lot of dummy implementations everywhere,
     * so it's placed here, where it's actually needed.
     *
     * @return
     *      Always non-null. Do not modify the returned array.
     */
    QName[] getTypeNames();
}
