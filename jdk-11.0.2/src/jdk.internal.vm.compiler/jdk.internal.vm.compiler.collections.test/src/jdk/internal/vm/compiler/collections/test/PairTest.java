/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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


package jdk.internal.vm.compiler.collections.test;

import jdk.internal.vm.compiler.collections.Pair;
import org.junit.Assert;
import org.junit.Test;

public class PairTest {

    @Test
    public void testCreate() {
        Assert.assertEquals(Pair.create(null, null), Pair.empty());
        Assert.assertNotEquals(Pair.create(null, null), null);
        Assert.assertEquals(Pair.createLeft(null), Pair.empty());
        Assert.assertEquals(Pair.createRight(null), Pair.empty());
        Assert.assertEquals(Pair.create(1, null), Pair.createLeft(1));
        Assert.assertEquals(Pair.create(null, 1), Pair.createRight(1));
    }

    @Test
    public void testUtilities() {
        Pair<Integer, Integer> pair = Pair.create(1, null);
        Assert.assertEquals(pair.getLeft(), Integer.valueOf(1));
        Assert.assertEquals(pair.getRight(), null);
        Assert.assertEquals(pair.toString(), "(1, null)");
        Assert.assertEquals(pair.hashCode(), Pair.createLeft(1).hashCode());
    }

}
