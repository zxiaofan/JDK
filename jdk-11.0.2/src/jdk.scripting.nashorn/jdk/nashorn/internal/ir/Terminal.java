/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.ir;

/**
 * Interface for AST nodes that can have a flag determining if they can terminate function control flow.
 */
public interface Terminal {
    /**
     * Returns true if this AST node is (or contains) a statement that terminates function control flow.
     * @return true if this AST node is (or contains) a statement that terminates function control flow.
     */
    public boolean isTerminal();
}
