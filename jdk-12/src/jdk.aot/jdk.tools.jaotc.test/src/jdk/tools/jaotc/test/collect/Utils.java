/*
 * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
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
 */


package jdk.tools.jaotc.test.collect;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Utils {
    @SafeVarargs
    public static <T> Set<T> set(T... entries) {
        Set<T> set = new HashSet<>();
        for (T entry : entries) {
            set.add(entry);
        }
        return set;
    }

    public static String mkpath(String path) {
        return getpath(path).toString();
    }

    public static Set<String> mkpaths(String... paths) {
        Set<String> set = new HashSet<>();
        for (String entry : paths) {
            set.add(mkpath(entry));
        }
        return set;
    }

    public static Path getpath(String path) {
        if (path.startsWith("/") && System.getProperty("os.name").startsWith("Windows")) {
            return Paths.get(new File(path).getAbsolutePath());
        } else {
            return Paths.get(path);
        }
    }
}
