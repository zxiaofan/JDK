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

package com.sun.xml.internal.ws.developer;

import com.sun.xml.internal.ws.api.FeatureConstructor;

import javax.xml.ws.WebServiceFeature;

/**
 * {@link javax.xml.ws.WebServiceFeature} for configuration serialization.
 *
 * @since JAX-WS RI 2.2.6
 * @author Jitendra Kotamraju
 * @see com.sun.xml.internal.ws.developer.Serialization
 */
public class SerializationFeature extends WebServiceFeature {
    /**
     * Constant value identifying this feature
     */
    public static final String ID = "http://jax-ws.java.net/features/serialization";
    private final String encoding;

    public SerializationFeature() {
        this("");
    }

    @FeatureConstructor({"encoding"})
    public SerializationFeature(String encoding) {
        this.encoding = encoding;
    }

    public String getID() {
        return ID;
    }

    public String getEncoding() {
        return encoding;
    }
}
