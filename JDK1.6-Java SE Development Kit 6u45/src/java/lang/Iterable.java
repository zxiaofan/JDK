/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

import java.util.Iterator;

/** Implementing this interface allows an object to be the target of
 *  the "foreach" statement.
 * @since 1.5
 */
public interface Iterable<T> {

    /**
     * Returns an iterator over a set of elements of type T.
     * 
     * @return an Iterator.
     */
    Iterator<T> iterator();
}
