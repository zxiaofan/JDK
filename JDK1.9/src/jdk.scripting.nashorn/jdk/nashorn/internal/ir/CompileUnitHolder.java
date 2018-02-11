/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

import jdk.nashorn.internal.codegen.CompileUnit;

/**
 * Marker interface for things in the IR that can hold compile units.
 * {@link CompileUnit}
 */
public interface CompileUnitHolder {
    /**
     * Return the compile unit held by this instance
     * @return compile unit
     */
    public CompileUnit getCompileUnit();
}
