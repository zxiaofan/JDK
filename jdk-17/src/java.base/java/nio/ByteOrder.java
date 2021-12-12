/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.nio;

import jdk.internal.misc.Unsafe;

/**
 * A typesafe enumeration for byte orders.
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 */

public final class ByteOrder {

    private String name;

    private ByteOrder(String name) {
        this.name = name;
    }

    /**
     * Constant denoting big-endian byte order.  In this order, the bytes of a
     * multibyte value are ordered from most significant to least significant.
     */
    public static final ByteOrder BIG_ENDIAN
        = new ByteOrder("BIG_ENDIAN");

    /**
     * Constant denoting little-endian byte order.  In this order, the bytes of
     * a multibyte value are ordered from least significant to most
     * significant.
     */
    public static final ByteOrder LITTLE_ENDIAN
        = new ByteOrder("LITTLE_ENDIAN");

    // Retrieve the native byte order. It's used early during bootstrap, and
    // must be initialized after BIG_ENDIAN and LITTLE_ENDIAN.
    private static final ByteOrder NATIVE_ORDER
        = Unsafe.getUnsafe().isBigEndian()
            ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;

    /**
     * Retrieves the native byte order of the underlying platform.
     *
     * <p> This method is defined so that performance-sensitive Java code can
     * allocate direct buffers with the same byte order as the hardware.
     * Native code libraries are often more efficient when such buffers are
     * used.  </p>
     *
     * @return  The native byte order of the hardware upon which this Java
     *          virtual machine is running
     */
    public static ByteOrder nativeOrder() {
        return NATIVE_ORDER;
    }

    /**
     * Constructs a string describing this object.
     *
     * <p> This method returns the string
     * {@code "BIG_ENDIAN"} for {@link #BIG_ENDIAN} and
     * {@code "LITTLE_ENDIAN"} for {@link #LITTLE_ENDIAN}.
     *
     * @return  The specified string
     */
    public String toString() {
        return name;
    }

}
