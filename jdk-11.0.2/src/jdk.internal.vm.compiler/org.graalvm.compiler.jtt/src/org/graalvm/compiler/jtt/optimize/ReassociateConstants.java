/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Assert;
import org.junit.Test;

public class ReassociateConstants {

    public static int rnd = (int) (Math.random() * 100);

    @Test
    public void run0() throws Throwable {
        Assert.assertEquals(rnd + 3, 1 + (rnd + 2));
        Assert.assertEquals(rnd + 3, (rnd + 2) + 1);
        Assert.assertEquals(rnd + 3, 1 + (2 + rnd));
        Assert.assertEquals(rnd + 3, (2 + rnd) + 1);

        Assert.assertEquals(-1 - rnd, 1 - (rnd + 2));
        Assert.assertEquals(rnd + 1, (rnd + 2) - 1);
        Assert.assertEquals(-1 - rnd, 1 - (2 + rnd));
        Assert.assertEquals(rnd + 1, (2 + rnd) - 1);

        Assert.assertEquals(rnd - 1, 1 + (rnd - 2));
        Assert.assertEquals(rnd - 1, (rnd - 2) + 1);
        Assert.assertEquals(-rnd + 3, 1 + (2 - rnd));
        Assert.assertEquals(-rnd + 3, (2 - rnd) + 1);

        Assert.assertEquals(-rnd + 3, 1 - (rnd - 2));
        Assert.assertEquals(rnd - 3, (rnd - 2) - 1);
        Assert.assertEquals(rnd + -1, 1 - (2 - rnd));
        Assert.assertEquals(-rnd + 1, (2 - rnd) - 1);
    }
}
