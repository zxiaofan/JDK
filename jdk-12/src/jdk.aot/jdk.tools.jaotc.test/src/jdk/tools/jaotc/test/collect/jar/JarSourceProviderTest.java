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
 *          jdk.aot/jdk.tools.jaotc.collect.jar
 * @compile ../Utils.java
 * @compile ../FakeFileSupport.java
 * @compile ../FakeSearchPath.java
 *
 * @run junit/othervm jdk.tools.jaotc.test.collect.jar.JarSourceProviderTest
 */



package jdk.tools.jaotc.test.collect.jar;

import static jdk.tools.jaotc.test.collect.Utils.mkpath;
import static jdk.tools.jaotc.test.collect.Utils.set;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.ProviderNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import jdk.tools.jaotc.collect.ClassSource;
import jdk.tools.jaotc.collect.jar.JarSourceProvider;
import jdk.tools.jaotc.test.collect.FakeFileSupport;
import jdk.tools.jaotc.test.collect.FakeSearchPath;

public class JarSourceProviderTest {

    private FakeFileSupport fileSupport;
    private JarSourceProvider target;

    @Before
    public void setUp() throws Exception {
        fileSupport = new FakeFileSupport(set(), set());
        target = new JarSourceProvider(fileSupport);
    }

    @Test
    public void itShouldUseSearchPathToFindPath() {
        FakeSearchPath searchPath = new FakeSearchPath(null);
        target.findSource("hello", searchPath);

        Assert.assertEquals(set("hello"), searchPath.entries);
    }

    @Test
    public void itShouldReturnNullIfPathIsNull() {
        ClassSource source = target.findSource("foobar", new FakeSearchPath(null));
        Assert.assertNull(source);
    }

    @Test
    public void itShouldReturnNullIfPathIsDirectory() {
        fileSupport.addDirectory("hello/foobar");
        ClassSource source = target.findSource("foobar", new FakeSearchPath("hello/foobar"));

        Assert.assertNull(source);
        Assert.assertEquals(set(mkpath("hello/foobar")), fileSupport.getCheckedDirectory());
    }

    @Test
    public void itShouldReturnNullIfUnableToMakeJarFileSystem() {
        fileSupport.setJarFileSystemRoot(null);
        ClassSource result = target.findSource("foobar", new FakeSearchPath("foo/bar"));

        Assert.assertEquals(set(mkpath("foo/bar")), fileSupport.getCheckedJarFileSystemRoots());
        Assert.assertNull(result);
    }

    @Test
    public void itShouldReturnNullIfNotValidJarProvider() {
        fileSupport = new FakeFileSupport(set(), set()) {

            @Override
            public Path getJarFileSystemRoot(Path jarFile) {
                super.getJarFileSystemRoot(jarFile);
                throw new ProviderNotFoundException();
            }
        };
        fileSupport.setJarFileSystemRoot(null);
        target = new JarSourceProvider(fileSupport);

        ClassSource result = target.findSource("foobar", new FakeSearchPath("foo/bar"));

        Assert.assertEquals(set(mkpath("foo/bar")), fileSupport.getCheckedJarFileSystemRoots());
        Assert.assertNull(result);
    }

    @Test
    public void itShouldReturnSourceWhenAllIsValid() {
        fileSupport.setJarFileSystemRoot(Paths.get("some/bar"));
        ClassSource result = target.findSource("foobar", new FakeSearchPath("this/bar"));

        Assert.assertEquals(set(mkpath("this/bar")), fileSupport.getClassloaderPaths());
        Assert.assertEquals("jar:" + mkpath("this/bar"), result.toString());
    }
}
