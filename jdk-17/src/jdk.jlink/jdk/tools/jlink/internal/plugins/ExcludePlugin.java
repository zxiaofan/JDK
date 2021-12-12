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

import jdk.tools.jlink.plugin.PluginException;
import jdk.tools.jlink.plugin.ResourcePool;
import jdk.tools.jlink.plugin.ResourcePoolBuilder;
import jdk.tools.jlink.plugin.ResourcePoolEntry;

/**
 *
 * Exclude resources plugin
 */
public final class ExcludePlugin extends AbstractPlugin {

    private Predicate<String> predicate;


    public ExcludePlugin() {
        super("exclude-resources");
    }

    @Override
    public ResourcePool transform(ResourcePool in, ResourcePoolBuilder out) {
        in.transformAndCopy((resource) -> {
            if (resource.type().equals(ResourcePoolEntry.Type.CLASS_OR_RESOURCE)) {
                boolean shouldExclude = !predicate.test(resource.path());
                // do not allow filtering module-info.class to avoid mutating module graph.
                if (shouldExclude &&
                    resource.path().equals("/" + resource.moduleName() + "/module-info.class")) {
                    throw new PluginException("Cannot exclude " + resource.path());
                }
                return shouldExclude? null : resource;
            }
            return resource;
        }, out);
        return out.build();
    }

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public Category getType() {
        return Category.FILTER;
    }

    @Override
    public void configure(Map<String, String> config) {
        predicate = ResourceFilter.excludeFilter(config.get(getName()));
    }
}
