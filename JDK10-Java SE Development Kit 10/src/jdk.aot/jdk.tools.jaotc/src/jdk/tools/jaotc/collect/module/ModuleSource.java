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

package jdk.tools.jaotc.collect.module;

import jdk.tools.jaotc.collect.ClassSource;
import jdk.tools.jaotc.collect.FileSystemFinder;

import java.nio.file.Path;
import java.util.function.BiConsumer;

public final class ModuleSource implements ClassSource {
    private final Path modulePath;
    private final ClassLoader classLoader;

    ModuleSource(Path modulePath, ClassLoader classLoader) {
        this.modulePath = modulePath;
        this.classLoader = classLoader;
    }

    public Path getModulePath() {
        return modulePath;
    }

    @Override
    public void eachClass(BiConsumer<String, ClassLoader> consumer) {
        FileSystemFinder finder = new FileSystemFinder(modulePath, ClassSource::pathIsClassFile);

        for (Path path : finder) {
            consumer.accept(ClassSource.makeClassName(modulePath.relativize(path).normalize()), classLoader);
        }
    }

    @Override
    public String toString() {
        return "module:" + modulePath.toString();
    }
}
