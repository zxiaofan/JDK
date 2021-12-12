/*
 * Copyright (c) 2019, Red Hat, Inc.
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

import jdk.tools.jlink.internal.PluginRepository;
import jdk.tools.jlink.internal.ResourcePoolManager;
import jdk.tools.jlink.internal.ResourcePoolManager.ResourcePoolImpl;
import jdk.tools.jlink.plugin.Plugin;
import jdk.tools.jlink.plugin.ResourcePool;
import jdk.tools.jlink.plugin.ResourcePoolBuilder;

/**
 * Combined debug stripping plugin: Java debug attributes and native debug
 * symbols.
 *
 */
public final class DefaultStripDebugPlugin extends AbstractPlugin {

    private static final String STRIP_NATIVE_DEBUG_PLUGIN = "strip-native-debug-symbols";
    private static final String EXCLUDE_DEBUGINFO = "exclude-debuginfo-files";

    private final Plugin javaStripPlugin;
    private final NativePluginFactory stripNativePluginFactory;

    public DefaultStripDebugPlugin() {
        this(new StripJavaDebugAttributesPlugin(),
             new DefaultNativePluginFactory());
    }

    public DefaultStripDebugPlugin(Plugin javaStripPlugin,
                                   NativePluginFactory nativeStripPluginFact) {
        super("strip-debug");
        this.javaStripPlugin = javaStripPlugin;
        this.stripNativePluginFactory = nativeStripPluginFact;
    }

    @Override
    public ResourcePool transform(ResourcePool in, ResourcePoolBuilder out) {
        Plugin stripNativePlugin = stripNativePluginFactory.create();
        if (stripNativePlugin != null) {
            Map<String, String> stripNativeConfig = Map.of(
                                     STRIP_NATIVE_DEBUG_PLUGIN, EXCLUDE_DEBUGINFO);
            stripNativePlugin.configure(stripNativeConfig);
            ResourcePoolManager outRes =
                                 new ResourcePoolManager(in.byteOrder(),
                                                        ((ResourcePoolImpl)in).getStringTable());
            ResourcePool strippedJava = javaStripPlugin.transform(in,
                                                                  outRes.resourcePoolBuilder());
            return stripNativePlugin.transform(strippedJava, out);
        } else {
            return javaStripPlugin.transform(in, out);
        }
    }

    public interface NativePluginFactory {
        Plugin create();
    }

    private static class DefaultNativePluginFactory implements NativePluginFactory {

        @Override
        public Plugin create() {
            return PluginRepository.getPlugin(STRIP_NATIVE_DEBUG_PLUGIN,
                                              ModuleLayer.boot());
        }

    }

}
