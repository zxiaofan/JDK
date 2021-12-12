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
package jdk.tools.jlink.internal.plugins;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jdk.tools.jlink.plugin.ResourcePool;
import jdk.tools.jlink.plugin.ResourcePoolBuilder;
import jdk.tools.jlink.plugin.ResourcePoolEntry.Type;

/**
 *
 * A plugin to exclude a JMOD section such as man pages or header files
 */
public final class ExcludeJmodSectionPlugin extends AbstractPlugin {

    public static final String MAN_PAGES = "man";
    public static final String INCLUDE_HEADER_FILES = "headers";

    private final Set<Type> filters = new HashSet<>();

    public ExcludeJmodSectionPlugin() {
        super("exclude-jmod-section");
    }

    @Override
    public void configure(Map<String, String> config) {
        String arg = config.get(getName());
        if (arg.isEmpty()) {
            throw new IllegalArgumentException("Section name must be specified");
        }

        switch (arg) {
            case MAN_PAGES:
                filters.add(Type.MAN_PAGE);
                break;
            case INCLUDE_HEADER_FILES:
                filters.add(Type.HEADER_FILE);
                break;
            default:
                throw new IllegalArgumentException("Invalid section name: " + arg);
        }
    }

    @Override
    public ResourcePool transform(ResourcePool in, ResourcePoolBuilder out) {
        in.transformAndCopy(entry -> {
            // filter entries whose type corresponds to the specified JMOD section
            if (filters.contains(entry.type())) {
                entry = null;
            }
            return entry;
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

}
