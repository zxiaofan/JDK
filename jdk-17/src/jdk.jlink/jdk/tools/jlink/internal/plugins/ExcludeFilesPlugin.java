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
package jdk.tools.jlink.internal.plugins;

import java.util.Map;
import java.util.function.Predicate;

import jdk.tools.jlink.plugin.ResourcePool;
import jdk.tools.jlink.plugin.ResourcePoolBuilder;
import jdk.tools.jlink.plugin.ResourcePoolEntry;

/**
 *
 * Exclude files plugin
 */
public final class ExcludeFilesPlugin extends AbstractPlugin {

    private Predicate<String> predicate;

    public ExcludeFilesPlugin () {
        super("exclude-files");
    }

    @Override
    public ResourcePool transform(ResourcePool in, ResourcePoolBuilder out) {
        in.transformAndCopy((file) -> {
            if (!file.type().equals(ResourcePoolEntry.Type.CLASS_OR_RESOURCE)) {
                file = predicate.test(file.path()) ? file : null;
            }
            return file;
        }, out);
        return out.build();
    }

    @Override
    public Category getType() {
        return Category.FILTER;
    }

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public void configure(Map<String, String> config) {
        predicate = ResourceFilter.excludeFilter(config.get(getName()));
    }
}
