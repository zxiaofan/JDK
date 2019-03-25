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

package jdk.tools.jaotc.collect.jar;

import jdk.tools.jaotc.collect.ClassSource;
import jdk.tools.jaotc.collect.FileSystemFinder;

import java.nio.file.Path;
import java.util.function.BiConsumer;

public final class JarFileSource implements ClassSource {
    private final Path jarFile;
    private final Path jarRootPath;
    private final ClassLoader classLoader;

    JarFileSource(Path jarFile, Path jarRootPath, ClassLoader classLoader) {
        this.jarFile = jarFile;
        this.jarRootPath = jarRootPath;
        this.classLoader = classLoader;
    }

    @Override
    public void eachClass(BiConsumer<String, ClassLoader> consumer) {
        FileSystemFinder finder = new FileSystemFinder(jarRootPath, ClassSource::pathIsClassFile);

        for (Path path : finder) {
            consumer.accept(ClassSource.makeClassName(jarRootPath.relativize(path).normalize()), classLoader);
        }
    }

    @Override
    public String toString() {
        return "jar:" + jarFile.toString();
    }
}
