/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.management.counter;

/**
 * Interface for performance counter wrapping <code>long[]</code> objects.
 *
 */
public interface LongArrayCounter extends Counter {

    /**
     * Get a copy of the elements of the LongArrayCounter.
     */
    public long[] longArrayValue();

    /**
     * Get the value of an element of the LongArrayCounter object.
     */
    public long longAt(int index);
}
