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

package com.sun.xml.internal.bind.v2.model.impl;

import com.sun.xml.internal.bind.v2.model.core.PropertyInfo;

/**
 * {@link PropertyInfo} that allows to add additional elements to the collection.
 *
 * @author Martin Grebac
 */
public interface DummyPropertyInfo<T, C, F, M> {
    void addType(PropertyInfoImpl<T, C, F, M> info);
}
