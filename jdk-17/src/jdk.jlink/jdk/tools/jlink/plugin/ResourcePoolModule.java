/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.module.ModuleDescriptor;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

/**
  * Link-time representation of a module.
  */
public interface ResourcePoolModule {
    /**
     * The module name.
     *
     * @return The module name.
     */
    public String name();

    /**
     * Retrieves a ResourcePoolEntry from the given path (e.g:
     * /mymodule/com.foo.bar/MyClass.class)
     *
     * @param path The piece of data path.
     * @return A ResourcePoolEntry of the given path, if found.
     */
    public Optional<ResourcePoolEntry> findEntry(String path);

    /**
     * The module descriptor of this module.
     *
     * @return The module descriptor.
     */
    public ModuleDescriptor descriptor();

    /**
     * The target platform
     *
     * @return The target platform
     */
    public String targetPlatform();

    /**
     * Retrieves all the packages located in this module.
     *
     * @return The set of packages.
     */
    public Set<String> packages();

    /**
     * Retrieves the stream of ResourcePoolEntry.
     *
     * @return The ResourcePoolEntry stream.
     */
    public Stream<ResourcePoolEntry> entries();

    /**
     * Return the number of ResourcePoolEntry count in this ResourcePoolModule.
     *
     * @return the entry count.
     */
    public int entryCount();
}
