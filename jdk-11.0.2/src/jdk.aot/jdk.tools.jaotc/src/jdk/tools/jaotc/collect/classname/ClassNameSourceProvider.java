/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc.collect.classname;

import jdk.tools.jaotc.collect.ClassSource;
import jdk.tools.jaotc.collect.FileSupport;
import jdk.tools.jaotc.collect.SearchPath;
import jdk.tools.jaotc.collect.SourceProvider;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class ClassNameSourceProvider implements SourceProvider {
    public final static String TYPE = "class";
    private final ClassLoader classLoader;

    public ClassNameSourceProvider(FileSupport fileSupport) {
        String classPath = System.getProperty("java.class.path");
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (classPath != null && !classPath.isEmpty()) {
            classLoader = systemClassLoader;
        } else {
            Path path = Paths.get(".").toAbsolutePath();
            classLoader = fileSupport.createClassLoader(path, systemClassLoader);
        }
    }

    @Override
    public ClassSource findSource(String name0, SearchPath searchPath) {
        String name = name0;
        Path path = Paths.get(name);
        if (ClassSource.pathIsClassFile(path)) {
            name = ClassSource.makeClassName(path);
        }
        try {
            classLoader.loadClass(name);
            return new ClassNameSource(name, classLoader);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public boolean supports(String type) {
        return TYPE.equals(type);
    }
}
