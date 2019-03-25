/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.cfg;

import java.util.function.BiConsumer;

/**
 * A {@linkplain PrintableCFG printable} {@link DominatorOptimizationProblem}.
 */
public abstract class PrintableDominatorOptimizationProblem<E extends Enum<E>, C extends PropertyConsumable> extends DominatorOptimizationProblem<E, C> implements PrintableCFG {

    protected PrintableDominatorOptimizationProblem(Class<E> keyType, AbstractControlFlowGraph<?> cfg) {
        super(keyType, cfg);
    }

    @Override
    public void forEachPropertyPair(AbstractBlockBase<?> block, BiConsumer<String, String> action) {
        // for each flag
        getFlags().forEach(flag -> ((BiConsumer<String, Boolean>) (name, value) -> action.accept(name, value ? "true" : "false")).accept(getName(flag), get(flag, block)));
        // for each property
        C cost = getCost(block);
        if (cost != null) {
            cost.forEachProperty((name, value) -> action.accept(name, value));
        }
    }
}
