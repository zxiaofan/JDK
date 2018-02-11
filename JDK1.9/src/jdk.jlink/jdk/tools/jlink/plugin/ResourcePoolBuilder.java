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
package jdk.tools.jlink.plugin;

import java.nio.ByteOrder;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Resource pool builder to build a resource pool by incrementally
 * adding a set of resources one at a time.
 */
public interface ResourcePoolBuilder {
    /**
     * Add a ResourcePoolEntry.
     *
     * @param data The ResourcePoolEntry to add.
     */
    public void add(ResourcePoolEntry data);

    /**
     * Done with adding resource entries. Construct
     * a ResourcePool with the added resource entries.
     *
     * @return a new ResourcePool filled with entries added.
     */
    public ResourcePool build();
}
