/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.server.sei;

import com.sun.xml.internal.ws.api.model.Parameter;
import com.sun.xml.internal.ws.model.ParameterImpl;

import javax.xml.ws.Holder;

/**
 * Moves a Java value unmarshalled from a response message
 * to the right place.
 *
 * <p>
 * Sometimes values are returned as a return value, and
 * others are returned in the {@link Holder} value. Instances
 * of this interface abstracts this detail.
 *
 * <p>
 * {@link EndpointValueSetter} is a stateless behavior encapsulation.
 *
 * @author Jitendra Kotamraju
 */
public abstract class EndpointValueSetter {
    private EndpointValueSetter() {}

    /**
     * Moves the value to the expected place.
     *
     * @param obj
     *      The unmarshalled object.
     * @param args
     *      The arguments that need to be given to the Java method invocation.
     *      If {@code obj} is supposed to be returned as a {@link Holder}
     *      value, a suitable {@link Holder} is obtained from
     *      this argument list and {@code obj} is set.
     *
     */
    abstract void put(Object obj, Object[] args);

    /**
     * {@link Param}s with small index numbers are used often,
     * so we pool them to reduce the footprint.
     */
    private static final EndpointValueSetter[] POOL = new EndpointValueSetter[16];

    static {
        for( int i=0; i<POOL.length; i++ )
            POOL[i] = new Param(i);
    }

    /**
     * Returns a {@link EndpointValueSetter} suitable for the given {@link Parameter}.
     */
    public static EndpointValueSetter get(ParameterImpl p) {
        int idx = p.getIndex();
        if (p.isIN()) {
            if (idx<POOL.length) {
                return POOL[idx];
            } else {
                return new Param(idx);
            }
        } else {
            return new HolderParam(idx);
        }
    }

    static class Param extends EndpointValueSetter {
        /**
         * Index of the argument to put the value to.
         */
        protected final int idx;

        public Param(int idx) {
            this.idx = idx;
        }

        void put(Object obj, Object[] args) {
            if (obj != null) {
                args[idx] = obj;
            }
        }
    }

    static final class HolderParam extends Param {

        public HolderParam(int idx) {
            super(idx);
        }

        @Override
        void put(Object obj, Object[] args) {
            Holder holder = new Holder();
            if (obj != null) {
                holder.value = obj;
            }
            args[idx] = holder;
        }
    }
}
