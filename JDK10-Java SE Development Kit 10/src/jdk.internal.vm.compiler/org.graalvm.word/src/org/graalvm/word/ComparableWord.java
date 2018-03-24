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
 *
 *
 */
package org.graalvm.word;

public interface ComparableWord extends WordBase {

    /**
     * Compares this word with the specified value.
     *
     * @param val value to which this word is to be compared.
     * @return {@code this == val}
     */
    boolean equal(ComparableWord val);

    /**
     * Compares this word with the specified value.
     *
     * @param val value to which this word is to be compared.
     * @return {@code this != val}
     */
    boolean notEqual(ComparableWord val);
}
