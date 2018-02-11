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
 * A Tree node for import entry of <a href="http://www.ecma-international.org/ecma-262/6.0/#sec-modules">Module information</a>.
 */
public interface ImportEntryTree extends Tree {
    /**
     * Returns the entry's module request.
     *
     * @return the module request
     */
    public IdentifierTree getModuleRequest();

    /**
     * Returns the entry's import name.
     *
     * @return the import name
     */
    public IdentifierTree getImportName();

    /**
     * Returns the entry's local name.
     *
     * @return the local name
     */
    public IdentifierTree getLocalName();
}
