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

import javax.jws.WebParam;

/**
 * {@link ValueGetterFactory} is used to create {@link ValueGetter} objects.
 *
 * @author Jitendra Kotamraju
 */
abstract class ValueGetterFactory {

    abstract ValueGetter get(ParameterImpl p);

    static final ValueGetterFactory SYNC = new ValueGetterFactory() {
        ValueGetter get(ParameterImpl p) {
            return (p.getMode()== WebParam.Mode.IN || p.getIndex() == -1)
                    ? ValueGetter.PLAIN : ValueGetter.HOLDER;
        }
    };

    /**
     * In case of SEI async signatures, there are no holders. The OUT
     * parameters go in async bean class
     */
    static final ValueGetterFactory ASYNC = new ValueGetterFactory() {
        ValueGetter get(ParameterImpl p) {
            return ValueGetter.PLAIN;
        }
    };

}
