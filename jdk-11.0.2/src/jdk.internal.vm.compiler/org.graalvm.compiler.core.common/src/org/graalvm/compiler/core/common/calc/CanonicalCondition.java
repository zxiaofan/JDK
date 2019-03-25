/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.calc;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.PrimitiveConstant;

public enum CanonicalCondition {
    EQ(Condition.EQ),
    LT(Condition.LT),
    BT(Condition.BT);

    private final Condition condition;

    CanonicalCondition(Condition condition) {
        assert condition.isCanonical();
        this.condition = condition;
    }

    public Condition asCondition() {
        return condition;
    }

    public boolean foldCondition(Constant lt, Constant rt, ConstantReflectionProvider constantReflection, boolean unorderedIsTrue) {
        return asCondition().foldCondition(lt, rt, constantReflection, unorderedIsTrue);
    }

    public boolean foldCondition(PrimitiveConstant lp, PrimitiveConstant rp, boolean unorderedIsTrue) {
        return asCondition().foldCondition(lp, rp, unorderedIsTrue);
    }
}
