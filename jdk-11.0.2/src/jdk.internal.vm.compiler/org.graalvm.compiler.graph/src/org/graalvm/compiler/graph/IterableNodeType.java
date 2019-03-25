/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph;

/**
 * A marker for a node type supporting {@linkplain Graph#getNodes(NodeClass) fast iteration} of its
 * instances in a graph. The support for fast iteration comes with a memory cost (e.g., extra data
 * structures {@link Graph}) so only node types for which fast iteration provides a compilation
 * performance benefit should implement this interface.
 */
public interface IterableNodeType {
}
