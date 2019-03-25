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


package org.graalvm.compiler.debug;

public class DebugDumpScope {

    public final String name;

    /**
     * Specifies if this scope decorates an inner scope. A hierarchical or tree representation of
     * nested scopes may choose to represent a decorator scope at the same level as the scope it
     * decorates.
     */
    public final boolean decorator;

    public DebugDumpScope(String name) {
        this(name, false);
    }

    public DebugDumpScope(String name, boolean decorator) {
        this.name = name;
        this.decorator = decorator;
    }

    @Override
    public String toString() {
        return "DebugDumpScope[" + name + "]";
    }
}
