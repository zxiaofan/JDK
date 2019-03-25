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
 *          jdk.aot/jdk.tools.jaotc.collect.directory
 * @compile ../Utils.java
 * @compile ../FakeFileSupport.java
 * @run junit/othervm jdk.tools.jaotc.test.collect.directory.DirectorySourceProviderTest
 */



package jdk.tools.jaotc.test.collect.directory;

import jdk.tools.jaotc.collect.ClassSource;
import jdk.tools.jaotc.collect.directory.DirectorySourceProvider;
import jdk.tools.jaotc.test.collect.FakeFileSupport;
import jdk.tools.jaotc.collect.FileSupport;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.Set;

import static jdk.tools.jaotc.test.collect.Utils.set;

public class DirectorySourceProviderTest {
    @Test
    public void itShouldReturnNullForNonExistantPath() {
        DirectorySourceProvider target = new DirectorySourceProvider(new FakeFileSupport(set(), set()));
        ClassSource result = target.findSource("hello", null);
        Assert.assertNull(result);
    }

    @Test
    public void itShouldReturnNullForNonDirectory() {
        DirectorySourceProvider target = new DirectorySourceProvider(new FakeFileSupport(set("foobar"), set()));
        ClassSource result = target.findSource("foobar", null);
        Assert.assertNull(result);
    }

    @Test
    public void itShouldReturnNullForMalformedURI() {
        Set<String> visited = set();
        DirectorySourceProvider target = new DirectorySourceProvider(new FakeFileSupport(set("foobar"), set("foobar")) {
            @Override
            public ClassLoader createClassLoader(Path path) throws MalformedURLException {
                visited.add("1");
                throw new MalformedURLException("...");
            }
        });
        ClassSource result = target.findSource("foobar", null);
        Assert.assertNull(result);
        Assert.assertEquals(set("1"), visited);
    }

    @Test
    public void itShouldCreateSourceIfNameExistsAndIsADirectory() {
        FileSupport fileSupport = new FakeFileSupport(set("foo"), set("foo"));
        DirectorySourceProvider target = new DirectorySourceProvider(fileSupport);
        ClassSource foo = target.findSource("foo", null);
        Assert.assertNotNull(foo);
        Assert.assertEquals("directory:foo", foo.toString());
    }

}
