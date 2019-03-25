/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodeinfo;

public enum Verbosity {
    /**
     * Only the id of the node.
     */
    Id,
    /**
     * Only the name of the node, which may contain some more information for certain node types
     * (constants, ...).
     */
    Name,
    /**
     * {@link #Id} + {@link #Name}.
     */
    Short,
    /**
     * Defaults to {@link #Short} and may be enhanced by subclasses.
     */
    Long,
    /**
     * For use by a custom formatting facility in an IDE.
     */
    Debugger,
    /**
     * All the other information plus all debug properties of the node.
     */
    All
}
