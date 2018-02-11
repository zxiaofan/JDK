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

package com.sun.xml.internal.ws.client.sei;

import com.sun.xml.internal.ws.model.ParameterImpl;

import javax.xml.ws.WebServiceException;

/**
 * {@link ValueSetterFactory} is used to create {@link ValueSetter}.
 *
 * @author Jitendra Kotamraju
 */
public abstract class ValueSetterFactory {

    public abstract ValueSetter get(ParameterImpl p);

    public static final ValueSetterFactory SYNC = new ValueSetterFactory() {
        public ValueSetter get(ParameterImpl p) {
            return ValueSetter.getSync(p);
        }
    };

    public static final ValueSetterFactory NONE = new ValueSetterFactory() {
        public ValueSetter get(ParameterImpl p) {
            throw new WebServiceException("This shouldn't happen. No response parameters.");
        }
    };

    public static final ValueSetterFactory SINGLE = new ValueSetterFactory() {
        public ValueSetter get(ParameterImpl p) {
            return ValueSetter.SINGLE_VALUE;
        }
    };

    public static final class AsyncBeanValueSetterFactory extends ValueSetterFactory {
        private Class asyncBean;

        public AsyncBeanValueSetterFactory(Class asyncBean) {
            this.asyncBean = asyncBean;
        }

        public ValueSetter get(ParameterImpl p) {
            return new ValueSetter.AsyncBeanValueSetter(p, asyncBean);
        }
    }

}
