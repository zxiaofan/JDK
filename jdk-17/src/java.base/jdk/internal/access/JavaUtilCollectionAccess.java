/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.util.List;

public interface JavaUtilCollectionAccess {
    <E> List<E> listFromTrustedArray(Object[] array);
    <E> List<E> listFromTrustedArrayNullsAllowed(Object[] array);
}
