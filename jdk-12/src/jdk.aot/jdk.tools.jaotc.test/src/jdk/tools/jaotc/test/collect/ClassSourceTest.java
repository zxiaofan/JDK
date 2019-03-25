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
 * @build jdk.tools.jaotc.test.collect.Utils
 * @run junit/othervm jdk.tools.jaotc.test.collect.ClassSourceTest
 */



package jdk.tools.jaotc.test.collect;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;

import static jdk.tools.jaotc.collect.ClassSource.makeClassName;

import static jdk.tools.jaotc.test.collect.Utils.getpath;

public class ClassSourceTest {
    @Test(expected = IllegalArgumentException.class)
    public void itShouldThrowExceptionIfPathDoesntEndWithClass() {
        makeClassName(Paths.get("Bar.clazz"));
    }

    @Test
    public void itShouldReplaceSlashesWithDots() {
        Assert.assertEquals("foo.Bar", makeClassName(getpath("foo/Bar.class")));
    }

    @Test
    public void itShouldStripLeadingSlash() {
        Assert.assertEquals("Hello", makeClassName(getpath("/Hello.class")));
    }

    @Test
    public void itShouldReplaceMultipleDots() {
        Assert.assertEquals("some.foo.bar.FooBar", makeClassName(getpath("/some/foo/bar/FooBar.class")));
    }
}
