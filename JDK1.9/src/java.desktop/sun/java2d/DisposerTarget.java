/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

/**
 * This is an interface which should be implemented by
 * the classes which use Disposer.
 */
public interface DisposerTarget {
    /**
     * Returns an object which will be
     * used as the referent in the ReferenceQueue
     */
    public Object getDisposerReferent();
}
