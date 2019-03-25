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


package org.graalvm.compiler.hotspot.test;

import java.util.ArrayList;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderConfiguration;
import org.junit.Test;

/**
 * Exercise intrinsification of {@link Object#clone}.
 */
public class ObjectCloneTest extends GraalCompilerTest {

    public static Object cloneArray(int[] array) {
        return array.clone();
    }

    public static Object cloneList(ArrayList<?> list) {
        return list.clone();
    }

    static class ObjectCloneable implements Cloneable {
        int field;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    static class CloneableSubclass extends ObjectCloneable {

    }

    /*
     * This test checks that the ObjectCloneNode doesn't accidentally inject non-nullness into the
     * graph which is later removed.
     */
    public static Object notCloneable(ObjectCloneable cloneable) throws CloneNotSupportedException {
        ObjectCloneable clone = (ObjectCloneable) cloneable.clone();
        return clone.getClass();
    }

    @Test
    public void testNotIntrinsified() throws Throwable {
        test("notCloneable", new CloneableSubclass());
    }

    @Test
    public void testArray() throws Throwable {
        test("cloneArray", new int[]{1, 2, 4, 3});
    }

    @Test
    public void testList() throws Throwable {
        ArrayList<Object> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        test("cloneList", list);
    }

    @Override
    protected GraphBuilderConfiguration editGraphBuilderConfiguration(GraphBuilderConfiguration conf) {
        return super.editGraphBuilderConfiguration(conf.withNodeSourcePosition(true));
    }

    static final int[] ARRAY = new int[]{1, 2, 4, 3};

    public static int[] cloneConstantArray() {
        return ARRAY.clone();
    }

    @Test
    public void testCloneConstantArray() {
        test("cloneConstantArray");
    }
}
