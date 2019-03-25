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

import java.util.function.Predicate;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.tools.jlink.plugin.ResourcePool;
import jdk.tools.jlink.plugin.ResourcePoolBuilder;
import jdk.tools.jlink.plugin.ResourcePoolEntry;
import jdk.tools.jlink.plugin.Plugin;

/**
 *
 * Strip debug attributes plugin
 */
public final class StripDebugPlugin implements Plugin {
    public static final String NAME = "strip-debug";
    private final Predicate<String> predicate;

    public StripDebugPlugin() {
        this((path) -> false);
    }

    StripDebugPlugin(Predicate<String> predicate) {
        this.predicate = predicate;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return PluginsResourceBundle.getDescription(NAME);
    }

    @Override
    public ResourcePool transform(ResourcePool in, ResourcePoolBuilder out) {
        //remove *.diz files as well as debug attributes.
        in.transformAndCopy((resource) -> {
            ResourcePoolEntry res = resource;
            if (resource.type().equals(ResourcePoolEntry.Type.CLASS_OR_RESOURCE)) {
                String path = resource.path();
                if (path.endsWith(".class")) {
                    if (path.endsWith("module-info.class")) {
                        // XXX. Do we have debug info? Is Asm ready for module-info?
                    } else {
                        ClassReader reader = new ClassReader(resource.contentBytes());
                        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                        reader.accept(writer, ClassReader.SKIP_DEBUG);
                        byte[] content = writer.toByteArray();
                        res = resource.copyWithContent(content);
                    }
                }
            } else if (predicate.test(res.path())) {
                res = null;
            }
            return res;
        }, out);

        return out.build();
    }
}
