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
package jdk.tools.jlink.internal;

import jdk.tools.jlink.plugin.ResourcePool;

/**
 * Plugin wishing to pre-visit the resources must implement this interface.
 * Pre-visit can be useful when some activities are required prior to the actual
 * Resource visit.
 * The StringTable plays a special role during previsit. The passed Strings are NOT
 * added to the jimage file. The string usage is tracked in order to build an efficient
 * string storage.
 */
public interface ResourcePrevisitor {

    /**
     * Previsit the collection of resources.
     *
     * @param resources Read only resources.
     * @param strings StringTable instance. Add string to the StringTable to track string
     * usage.
     */
    public void previsit(ResourcePool resources, StringTable strings);
}
