/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.api.tree;

import java.util.List;

/**
 * Represents the abstract syntax tree for compilation units (source
 * files)
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 *
 * @since 9
 */
@Deprecated(since="11", forRemoval=true)
public interface CompilationUnitTree extends Tree {
    /**
     * Return the list of source elements in this compilation unit.
     *
     * @return the list of source elements in this compilation unit
     */
    List<? extends Tree> getSourceElements();

    /**
     * Return the source name of this script compilation unit.
     *
     * @return the source name of this script compilation unit
     */
    String getSourceName();

    /**
     * Returns if this is a ECMAScript "strict" compilation unit or not.
     *
     * @return true if this compilation unit is declared "strict"
     */
    boolean isStrict();

    /**
     * Returns the line map for this compilation unit, if available.
     * Returns null if the line map is not available.
     *
     * @return the line map for this compilation unit
     */
    LineMap getLineMap();

    /**
     * Return the {@link ModuleTree} associated with this compilation unit. This is null,
     * if there is no module information from this compilation unit.
     *
     * @return the Module info or null
     */
    ModuleTree getModule();
}
