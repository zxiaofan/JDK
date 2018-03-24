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

public interface WordBase {

    long rawValue();

    /**
     * This is deprecated because of the easy to mistype name collision between {@link #equals} and
     * the other word based equality routines. In general you should never be statically calling
     * this method anyway.
     */
    @Override
    @Deprecated
    boolean equals(Object o);
}
