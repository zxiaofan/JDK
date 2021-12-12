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

package jdk.internal.loader;

/**
 * NativeLibrary represents a loaded native library instance.
 */
public interface NativeLibrary {
    String name();

    /**
     * Finds the address of the entry of the given name.  Returns 0
     * if not found.
     *
     * @param name the name of the symbol to be found
     */
    long find(String name);

    /**
     * Finds the address of the entry of the given name.
     *
     * @param name the name of the symbol to be found
     * @throws NoSuchMethodException if the named entry is not found.
     */
    default long lookup(String name) throws NoSuchMethodException {
        long addr = find(name);
        if (0 == addr) {
            throw new NoSuchMethodException("Cannot find symbol " + name + " in library " + name());
        }
        return addr;
    }
}
