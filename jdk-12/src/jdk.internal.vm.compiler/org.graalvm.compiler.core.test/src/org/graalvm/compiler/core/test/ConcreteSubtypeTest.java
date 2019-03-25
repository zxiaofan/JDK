/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Test;

import jdk.vm.ci.meta.Assumptions.ConcreteSubtype;

/**
 * Ensure that abstract classes with a single implementor are properly optimized and that loading a
 * subclass below the leaf type triggers invalidation.
 */
public class ConcreteSubtypeTest extends GraalCompilerAssumptionsTest {
    abstract static class AbstractBase {
        abstract void check();
    }

    static class Subclass extends AbstractBase {
        @Override
        public void check() {
            throw new InternalError();
        }
    }

    static class SubSubclass extends Subclass {
        @Override
        public void check() {
        }
    }

    public void callAbstractType(AbstractBase object) {
        object.check();
    }

    /**
     * Test that {@link #callAbstractType} gets compiled into an empty method with a
     * {@link ConcreteSubtype} assumption on {@link AbstractBase} and {@link Subclass}. Then ensures
     * that loading and initialization of {@link SubSubclass} causes the compiled method to be
     * invalidated.
     */
    @Test
    public void testLeafAbstractType() {
        testAssumptionInvalidate("callAbstractType", new ConcreteSubtype(resolveAndInitialize(AbstractBase.class), resolveAndInitialize(Subclass.class)), "SubSubclass");
    }
}
