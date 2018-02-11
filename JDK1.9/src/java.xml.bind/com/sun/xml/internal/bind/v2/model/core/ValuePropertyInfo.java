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

package com.sun.xml.internal.bind.v2.model.core;

/**
 * Value {@link PropertyInfo}.
 *
 * @author Kohsuke Kawaguchi
 */
public interface ValuePropertyInfo<T,C> extends PropertyInfo<T,C>, NonElementRef<T,C> {
    Adapter<T,C> getAdapter();
}
