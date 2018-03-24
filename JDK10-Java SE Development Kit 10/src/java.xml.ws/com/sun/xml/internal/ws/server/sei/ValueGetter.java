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

import com.sun.xml.internal.ws.model.ParameterImpl;
import com.sun.xml.internal.ws.api.model.Parameter;

import javax.jws.WebParam.Mode;
import javax.xml.ws.Holder;

/**
 * Gets a value from an object that represents a parameter passed
 * as a method argument.
 *
 * <p>
 * This abstraction hides the handling of {@link Holder}.
 *
 * <p>
 * {@link ValueGetter} is a stateless behavior encapsulation.
 *
 * @author Kohsuke Kawaguchi
 */
public enum ValueGetter {
    /**
     * {@link ValueGetter} that works for {@link Mode#IN}  parameter.
     *
     * <p>
     * Since it's the IN mode, the parameter is not a {@link Holder},
     * therefore the parameter itself is a value.
     */
    PLAIN() {
        public Object get(Object parameter) {
            return parameter;
        }
    },
    /**
     * Creates {@link ValueGetter} that works for {@link Holder},
     * which is  {@link Mode#INOUT} or  {@link Mode#OUT}.
     *
     * <p>
     * In those {@link Mode}s, the parameter is a {@link Holder},
     * so the value to be sent is obtained by getting the value of the holder.
     */
    HOLDER() {
        public Object get(Object parameter) {
            if(parameter==null)
                // the user is allowed to pass in null where a Holder is expected.
                return null;
            return ((Holder)parameter).value;
        }
    };

    /**
     * Gets the value to be sent, from a parameter given as a method argument.
     */
    public abstract Object get(Object parameter);

    /**
     * Returns a {@link ValueGetter} suitable for the given {@link Parameter}.
     */
    public static ValueGetter get(ParameterImpl p) {
        // return value is always PLAIN
        if(p.getMode() == Mode.IN || p.getIndex() == -1) {
            return PLAIN;
        } else {
            return HOLDER;
        }
    }
}
