/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.dfa;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Collection;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;

/**
 * Ensures that an element is only in the worklist once.
 *
 */
class UniqueWorkList extends ArrayDeque<AbstractBlockBase<?>> {
    private static final long serialVersionUID = 8009554570990975712L;
    BitSet valid;

    UniqueWorkList(int size) {
        this.valid = new BitSet(size);
    }

    @Override
    public AbstractBlockBase<?> poll() {
        AbstractBlockBase<?> result = super.poll();
        if (result != null) {
            valid.set(result.getId(), false);
        }
        return result;
    }

    @Override
    public boolean add(AbstractBlockBase<?> pred) {
        if (!valid.get(pred.getId())) {
            valid.set(pred.getId(), true);
            return super.add(pred);
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends AbstractBlockBase<?>> collection) {
        boolean changed = false;
        for (AbstractBlockBase<?> element : collection) {
            if (!valid.get(element.getId())) {
                valid.set(element.getId(), true);
                super.add(element);
                changed = true;
            }
        }
        return changed;
    }
}
