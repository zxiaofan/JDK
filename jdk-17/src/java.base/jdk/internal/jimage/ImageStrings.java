/*
 * Copyright (c) 2014, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.jimage;

/**
 * @implNote This interface needs to maintain JDK 8 source compatibility.
 *
 * It is used internally in the JDK to implement jimage/jrtfs access,
 * but also compiled and delivered as part of the jrtfs.jar to support access
 * to the jimage file provided by the shipped JDK by tools running on JDK 8.
 */
public interface ImageStrings {
    String get(int offset);

    int add(final String string);

    /**
     * If there's a string at {@code offset} matching in full a substring of
     * {@code string} starting at {@code stringOffset}, return the length
     * of that string. Otherwise returns -1. Optional operation.
     */
    default int match(int offset, String string, int stringOffset) {
        throw new UnsupportedOperationException();
    }

}
