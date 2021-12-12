/*
 * Copyright (c) 2019, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Function;

import jdk.tools.jlink.plugin.ResourcePool;
import jdk.tools.jlink.plugin.ResourcePoolBuilder;
import jdk.tools.jlink.plugin.ResourcePoolEntry;

/**
 * Base plugin to add a resource
 */
abstract class AddResourcePlugin extends AbstractPlugin {

    private final String path;
    private String value;

    protected AddResourcePlugin(String name, String p) {
        super(name);
        path = p;
    }

    @Override
    public Category getType() {
        return Category.ADDER;
    }

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasRawArgument() {
        return true;
    }


    @Override
    public void configure(Map<String, String> config) {
        var v = config.get(getName());
        if (v == null)
            throw new AssertionError();
        value = v;
    }

    @Override
    public ResourcePool transform(ResourcePool in, ResourcePoolBuilder out) {
        in.transformAndCopy(Function.identity(), out);
        out.add(ResourcePoolEntry.create(path,
                                         value.getBytes(StandardCharsets.UTF_8)));
        return out.build();
    }

}
