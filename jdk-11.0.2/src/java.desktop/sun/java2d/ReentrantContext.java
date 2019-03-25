/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package sun.java2d;

import java.lang.ref.Reference;

/**
 * ReentrantContext is a base class to hold thread-local data supporting
 * reentrancy in either a ThreadLocal or a ConcurrentLinkedQueue
 *
 * @see ReentrantContextProvider
 */
public class ReentrantContext {
    // usage stored as a byte
    byte usage = ReentrantContextProvider.USAGE_TL_INACTIVE;
    /*
     * Reference to this instance (hard, soft or weak).
     * @see ReentrantContextProvider#refType
     */
    Reference<? extends ReentrantContext> reference = null;
}
