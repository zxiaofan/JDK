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
 * Interface for performance counter wrapping <code>byte[]</code> objects.
 *
 * @author   Brian Doherty
 */
public interface ByteArrayCounter extends Counter {

    /**
     * Get a copy of the elements of the ByteArrayCounter.
     */
    public byte[] byteArrayValue();

    /**
     * Get the value of an element of the ByteArrayCounter object.
     */
    public byte byteAt(int index);
}
