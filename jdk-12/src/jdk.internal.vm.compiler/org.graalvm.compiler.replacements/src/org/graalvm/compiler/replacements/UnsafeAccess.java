/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.replacements;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * Package private access to the {@link Unsafe} capability.
 */
class UnsafeAccess {

    private static final Unsafe THE_UNSAFE = initUnsafe();

    static final UnsafeAccess UNSAFE = new UnsafeAccess();

    private static Unsafe initUnsafe() {
        try {
            // Fast path when we are trusted.
            return Unsafe.getUnsafe();
        } catch (SecurityException se) {
            // Slow path when we are not trusted.
            try {
                Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
                theUnsafe.setAccessible(true);
                return (Unsafe) theUnsafe.get(Unsafe.class);
            } catch (Exception e) {
                throw new RuntimeException("exception while trying to get Unsafe", e);
            }
        }
    }

    public char getChar(Object target, long l) {
        return THE_UNSAFE.getChar(target, l);
    }

    public byte getByte(Object target, long l) {
        return THE_UNSAFE.getByte(target, l);
    }
}
