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

import jdk.tools.jlink.plugin.ResourcePool;
import jdk.tools.jlink.plugin.ResourcePoolBuilder;
import jdk.tools.jlink.plugin.ResourcePoolEntry;

/**
 *
 * Strip Native Commands plugin
 */
public final class StripNativeCommandsPlugin extends AbstractPlugin {

    public StripNativeCommandsPlugin() {
        super("strip-native-commands");
    }

    @Override
    public Category getType() {
        return Category.FILTER;
    }

    @Override
    public ResourcePool transform(ResourcePool in, ResourcePoolBuilder out) {
        in.transformAndCopy((file) -> {
            return file.type() == ResourcePoolEntry.Type.NATIVE_CMD ? null : file;
        }, out);

        return out.build();
    }
}
