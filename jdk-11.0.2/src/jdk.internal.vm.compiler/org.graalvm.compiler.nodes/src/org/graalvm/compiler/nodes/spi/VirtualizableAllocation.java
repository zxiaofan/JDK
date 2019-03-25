/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.spi;

/**
 * This interface allows a node to convey information about what its effect would be if some of its
 * inputs were virtualized.
 *
 * The difference to {@link Virtualizable} is that the {@link #virtualize(VirtualizerTool)} method
 * will be called regardless of whether this node had any interaction with virtualized nodes. This
 * interface can therefore be used for object allocations, for which virtualization introduces new
 * virtualized objects.
 */
public interface VirtualizableAllocation extends Virtualizable {

}
