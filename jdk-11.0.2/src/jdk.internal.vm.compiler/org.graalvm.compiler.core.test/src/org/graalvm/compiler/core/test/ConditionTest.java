/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.graalvm.compiler.core.common.calc.Condition;
import org.junit.Test;

import jdk.vm.ci.meta.JavaConstant;

public class ConditionTest {

    @Test
    public void testImplies() {
        Random rand = new Random(13);
        for (Condition c1 : Condition.values()) {
            for (Condition c2 : Condition.values()) {
                boolean implies = c1.implies(c2);
                if (implies) {
                    for (int i = 0; i < 1000; i++) {
                        JavaConstant a = JavaConstant.forInt(rand.nextInt());
                        JavaConstant b = JavaConstant.forInt(i < 100 ? a.asInt() : rand.nextInt());
                        boolean result1 = c1.foldCondition(a, b, null, false);
                        boolean result2 = c2.foldCondition(a, b, null, false);
                        if (result1) {
                            assertTrue(result2);
                        }
                    }
                }
            }
        }
    }

    @Test
    public void testJoin() {
        Random rand = new Random(13);
        for (Condition c1 : Condition.values()) {
            for (Condition c2 : Condition.values()) {
                Condition join = c1.join(c2);
                assertEquals(join, c2.join(c1));
                if (join != null) {
                    for (int i = 0; i < 1000; i++) {
                        JavaConstant a = JavaConstant.forInt(rand.nextInt());
                        JavaConstant b = JavaConstant.forInt(i < 100 ? a.asInt() : rand.nextInt());
                        boolean result1 = c1.foldCondition(a, b, null, false);
                        boolean result2 = c2.foldCondition(a, b, null, false);
                        boolean resultJoin = join.foldCondition(a, b, null, false);
                        if (result1 && result2) {
                            assertTrue(resultJoin);
                        } else {
                            assertFalse(resultJoin);
                        }
                    }
                }
            }
        }
    }

    @Test
    public void testMeet() {
        Random rand = new Random(13);
        for (Condition c1 : Condition.values()) {
            for (Condition c2 : Condition.values()) {
                Condition meet = c1.meet(c2);
                assertEquals(meet, c2.meet(c1));
                if (meet != null) {
                    for (int i = 0; i < 1000; i++) {
                        JavaConstant a = JavaConstant.forInt(rand.nextInt());
                        JavaConstant b = JavaConstant.forInt(i < 100 ? a.asInt() : rand.nextInt());
                        boolean result1 = c1.foldCondition(a, b, null, false);
                        boolean result2 = c2.foldCondition(a, b, null, false);
                        boolean resultMeet = meet.foldCondition(a, b, null, false);
                        if (result1 || result2) {
                            assertTrue(resultMeet);
                        } else {
                            assertFalse(resultMeet);
                        }
                    }
                }
            }
        }
    }

}
