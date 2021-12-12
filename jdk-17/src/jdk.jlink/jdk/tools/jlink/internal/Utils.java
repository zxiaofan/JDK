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
package jdk.tools.jlink.internal;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import jdk.tools.jlink.plugin.Plugin;

public class Utils {

    private Utils() {}

    // jrt-fs file system
    private static FileSystem JRT_FILE_SYSTEM;

    // current module
    private static final Module THIS_MODULE = Utils.class.getModule();

    public static List<String> parseList(String arguments) {
        return Arrays.stream(arguments.split(","))
                     .map((p) -> p.trim())
                     .filter((p) -> !p.isEmpty())
                     .toList();
    }


    public static List<Plugin> getSortedPlugins(List<Plugin> plugins) {
        List<Plugin> res = new ArrayList<>();
        res.addAll(plugins);
        res.sort(new Comparator<Plugin>() {
            @Override
            public int compare(Plugin o1, Plugin o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return res;
    }

    public static boolean isFunctional(Plugin prov) {
        return prov.getState().contains(Plugin.State.FUNCTIONAL);
    }

    public static boolean isAutoEnabled(Plugin prov) {
        return prov.getState().contains(Plugin.State.AUTO_ENABLED);
    }

    public static boolean isDisabled(Plugin prov) {
        return prov.getState().contains(Plugin.State.DISABLED);
    }

    // is this a builtin (jdk.jlink) plugin?
    public static boolean isBuiltin(Plugin prov) {
        return THIS_MODULE.equals(prov.getClass().getModule());
    }

    public static FileSystem jrtFileSystem() {
        if (JRT_FILE_SYSTEM == null) {
            JRT_FILE_SYSTEM = FileSystems.getFileSystem(URI.create("jrt:/"));
        }

        return JRT_FILE_SYSTEM;
    }

    public static PathMatcher getPathMatcher(FileSystem fs, String pattern) {
        if (!pattern.startsWith("glob:") && !pattern.startsWith("regex:")) {
            pattern = "glob:" + pattern;
        }

        return fs.getPathMatcher(pattern);
    }

    public static PathMatcher getJRTFSPathMatcher(String pattern) {
        return getPathMatcher(jrtFileSystem(), pattern);
    }

    public static Path getJRTFSPath(String first, String... more) {
        return jrtFileSystem().getPath(first, more);
    }
}
