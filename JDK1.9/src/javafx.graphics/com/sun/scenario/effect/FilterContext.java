/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package com.sun.scenario.effect;

/**
 *
 */
public class FilterContext {

    private Object referent;

    protected FilterContext(Object referent) {
        if (referent == null) {
            throw new IllegalArgumentException("Referent must be non-null");
        }
        this.referent = referent;
    }

    public final Object getReferent() {
        return referent;
    }

    @Override
    public int hashCode() {
        return referent.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FilterContext)) {
            return false;
        }
        FilterContext that = (FilterContext)o;
        return referent.equals(that.referent);
    }
}
