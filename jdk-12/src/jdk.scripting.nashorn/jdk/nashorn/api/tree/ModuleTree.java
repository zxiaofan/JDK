/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
 * A Tree node for <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-modules">Module information</a>.
 *
 * @deprecated Nashorn JavaScript script engine and APIs, and the jjs tool
 * are deprecated with the intent to remove them in a future release.
 */
@Deprecated(since="11", forRemoval=true)
public interface ModuleTree extends Tree {
    /**
     * Returns the list of import entries.
     *
     * @return the import entries
     */
    public List<? extends ImportEntryTree> getImportEntries();

    /**
     * Returns the list of local export entries.
     *
     * @return the local export entries
     */
    public List<? extends ExportEntryTree> getLocalExportEntries();

    /**
     * Returns the list of indirect export entries.
     *
     * @return the indirect export entries
     */
    public List<? extends ExportEntryTree> getIndirectExportEntries();

    /**
     * Returns the list of star export entries.
     *
     * @return the star export entries
     */
    public List<? extends ExportEntryTree> getStarExportEntries();
}
