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
package jdk.tools.jlink.plugin;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * The module view of a ResourcePool.
 */
public interface ResourcePoolModuleView {
    /**
     * Find the module, if any, of the given name.
     *
     * @param name name of the module
     * @return Optional containing the module of the given name.
     */
    public Optional<ResourcePoolModule> findModule(String name);

    /**
     * Find the module, if any, of the given ResourcePoolEntry
     *
     * @param entry The ResourcePoolEntry whose module is looked up.
     * @return Optional containing the module of the given ResourcePoolEntry
     */
    public default Optional<ResourcePoolModule> findModule(ResourcePoolEntry entry) {
        String name = Objects.requireNonNull(entry).moduleName();
        return name != null? findModule(name) : Optional.empty();
    }

    /**
     * The stream of modules contained in this ResourcePool.
     *
     * @return The stream of modules.
     */
    public Stream<ResourcePoolModule> modules();

    /**
     * Return the number of ResourcePoolModule count in this ResourcePool.
     *
     * @return the module count.
     */
    public int moduleCount();
}
