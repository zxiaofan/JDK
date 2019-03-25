/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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


package jdk.internal.vm.compiler.word;

/**
 * A machine-word-sized value that can be compared for equality.
 *
 * @since 1.0
 */
public interface ComparableWord extends WordBase {

    /**
     * Compares this word with the specified value.
     *
     * @param val value to which this word is to be compared.
     * @return {@code this == val}
     *
     * @since 1.0
     */
    boolean equal(ComparableWord val);

    /**
     * Compares this word with the specified value.
     *
     * @param val value to which this word is to be compared.
     * @return {@code this != val}
     *
     * @since 1.0
     */
    boolean notEqual(ComparableWord val);
}
