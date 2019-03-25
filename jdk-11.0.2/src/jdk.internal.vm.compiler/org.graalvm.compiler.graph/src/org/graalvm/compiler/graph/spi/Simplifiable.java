/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph.spi;

/**
 * This interface allows nodes to perform more complicated simplifications, in contrast to
 * {@link Canonicalizable}, which supports only replacing the current node.
 *
 * Implementors of this interface need to be aware that they need to call
 * {@link SimplifierTool#addToWorkList(org.graalvm.compiler.graph.Node)} for each node that might be
 * influenced (in terms of simplification and canonicalization) by the actions performed in
 * simplify.
 */
public interface Simplifiable {

    void simplify(SimplifierTool tool);
}
