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

package com.sun.xml.internal.ws.runtime.config;

import com.sun.xml.internal.ws.api.FeatureConstructor;
import com.sun.org.glassfish.gmbal.ManagedAttribute;
import com.sun.org.glassfish.gmbal.ManagedData;

import javax.xml.ws.WebServiceFeature;
import java.util.List;

/**
 * WebServiceFeature for the Tubeline {@link javax.xml.ws.WebServiceFeature}
 *
 * @author Fabian Ritzmann
 */
@ManagedData
public class TubelineFeature extends WebServiceFeature {

    public static final String ID = "com.sun.xml.internal.ws.runtime.config.TubelineFeature";

    @FeatureConstructor({
        "enabled"
    })
    public TubelineFeature(boolean enabled) {
        super.enabled = enabled;
    }

    @Override
    @ManagedAttribute
    public String getID() {
        return ID;
    }

    // TODO implement
    List<String> getTubeFactories() {
        return null;
    }

}
