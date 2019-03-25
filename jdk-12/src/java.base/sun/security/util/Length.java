/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.util;

/**
 * The Length interface defines the length of an object
 */
public interface Length {

    /**
     * Gets the length of this object
     * <p>
     * Note that if a class of java.security.Key implements this interfaces,
     * the length should be measured in bits.
     *
     * @return the length of this object
     * @throws UnsupportedOperationException if the operation is not supported
     */
    public int length();
}
