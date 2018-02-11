/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

public interface JavaLangRefAccess {

    /**
     * Wait for progress in {@link java.lang.ref.Reference}
     * processing.  If there aren't any pending {@link
     * java.lang.ref.Reference}s, return immediately.
     *
     * @return {@code true} if there were any pending
     * {@link java.lang.ref.Reference}s, {@code false} otherwise.
     */
    boolean waitForReferenceProcessing() throws InterruptedException;
}
