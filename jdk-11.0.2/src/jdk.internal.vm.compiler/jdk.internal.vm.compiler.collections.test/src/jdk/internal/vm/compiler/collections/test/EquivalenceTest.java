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

import jdk.internal.vm.compiler.collections.Equivalence;
import org.junit.Assert;
import org.junit.Test;

public class EquivalenceTest {

    private static final String TEST_STRING = "Graal";
    private static final String TEST_STRING2 = "Graal2";

    @Test
    public void testDEFAULT() {
        Assert.assertTrue(Equivalence.DEFAULT.equals(TEST_STRING, new String(TEST_STRING)));
        Assert.assertEquals(Equivalence.DEFAULT.hashCode(TEST_STRING), Equivalence.DEFAULT.hashCode(new String(TEST_STRING)));
        Assert.assertFalse(Equivalence.DEFAULT.equals(TEST_STRING, TEST_STRING2));
        Assert.assertNotEquals(Equivalence.DEFAULT.hashCode(TEST_STRING), Equivalence.DEFAULT.hashCode(TEST_STRING2));
    }

    @Test
    public void testIDENTITY() {
        Assert.assertFalse(Equivalence.IDENTITY.equals(TEST_STRING, new String(TEST_STRING)));
        Assert.assertEquals(Equivalence.IDENTITY.hashCode(TEST_STRING), Equivalence.IDENTITY.hashCode(new String(TEST_STRING)));
        Assert.assertFalse(Equivalence.IDENTITY.equals(TEST_STRING, TEST_STRING2));
        Assert.assertNotEquals(Equivalence.IDENTITY.hashCode(TEST_STRING), Equivalence.IDENTITY.hashCode(TEST_STRING2));
    }

    @Test
    public void testIDENTITYWITHSYSTEMHASHCODE() {
        Assert.assertFalse(Equivalence.IDENTITY_WITH_SYSTEM_HASHCODE.equals(TEST_STRING, new String(TEST_STRING)));
        Assert.assertNotEquals(Equivalence.IDENTITY_WITH_SYSTEM_HASHCODE.hashCode(TEST_STRING), Equivalence.IDENTITY_WITH_SYSTEM_HASHCODE.hashCode(new String(TEST_STRING)));
        Assert.assertFalse(Equivalence.IDENTITY_WITH_SYSTEM_HASHCODE.equals(TEST_STRING, TEST_STRING2));
        Assert.assertNotEquals(Equivalence.IDENTITY_WITH_SYSTEM_HASHCODE.hashCode(TEST_STRING), Equivalence.IDENTITY_WITH_SYSTEM_HASHCODE.hashCode(TEST_STRING2));
    }

}
