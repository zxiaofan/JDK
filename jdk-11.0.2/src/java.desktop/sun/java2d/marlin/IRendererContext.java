/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.marlin;

interface IRendererContext extends MarlinConst {

    public RendererStats stats();

    public OffHeapArray newOffHeapArray(final long initialSize);

    public IntArrayCache.Reference newCleanIntArrayRef(final int initialSize);

}
