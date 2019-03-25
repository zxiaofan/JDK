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

/**
 * @test
 * @requires vm.aot
 * @modules jdk.aot/jdk.tools.jaotc
 *          jdk.aot/jdk.tools.jaotc.collect
 *          jdk.aot/jdk.tools.jaotc.collect.module
 * @compile ../Utils.java
 * @run junit/othervm jdk.tools.jaotc.test.collect.module.ModuleSourceProviderTest
 */



package jdk.tools.jaotc.test.collect.module;

import static jdk.tools.jaotc.test.collect.Utils.mkpath;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiFunction;

import org.junit.Before;
import org.junit.Test;

import jdk.tools.jaotc.collect.FileSupport;
import jdk.tools.jaotc.collect.module.ModuleSource;
import jdk.tools.jaotc.collect.module.ModuleSourceProvider;

public class ModuleSourceProviderTest {
    private ClassLoader classLoader;
    private ModuleSourceProvider target;
    private FileSupport fileSupport;
    private BiFunction<Path, Path, Path> getSubDirectory = null;

    @Before
    public void setUp() {
        classLoader = new FakeClassLoader();
        fileSupport = new FileSupport() {

            @Override
            public boolean isDirectory(Path path) {
                return true;
            }

            @Override
            public Path getSubDirectory(FileSystem fileSystem, Path root, Path path) throws IOException {
                if (getSubDirectory == null) {
                    throw new IOException("Nope");
                }
                return getSubDirectory.apply(root, path);
            }
        };
        target = new ModuleSourceProvider(FileSystems.getDefault(), classLoader, fileSupport);
    }

    @Test
    public void itShouldUseFileSupport() {
        getSubDirectory = (root, path) -> {
            if (root.toString().equals("modules") && path.toString().equals("test.module")) {
                return Paths.get("modules/test.module");
            }
            return null;
        };

        ModuleSource source = (ModuleSource) target.findSource("test.module", null);
        assertEquals(mkpath("modules/test.module"), source.getModulePath().toString());
        assertEquals("module:" + mkpath("modules/test.module"), source.toString());
    }

    private static class FakeClassLoader extends ClassLoader {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return null;
        }
    }
}
