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
 * Type referenced as a result of having the wildcard.
 *
 * TODO: think about how to gracefully handle the difference between LAX,SKIP, and STRICT.
 *
 * @author Kohsuke Kawaguchi
 */
public interface WildcardTypeInfo<T,C> extends TypeInfo<T,C> {
}
