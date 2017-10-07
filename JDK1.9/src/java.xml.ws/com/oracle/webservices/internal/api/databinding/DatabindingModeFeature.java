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

package com.oracle.webservices.internal.api.databinding;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.WebServiceFeature;

public class DatabindingModeFeature extends WebServiceFeature implements com.sun.xml.internal.ws.api.ServiceSharedFeatureMarker {
    /**
     * Constant value identifying the DatabindingFeature
     */
    static public final String ID = "http://jax-ws.java.net/features/databinding";

    static public final String GLASSFISH_JAXB = "glassfish.jaxb";

    //These constants should be defined in the corresponding plugin package
//    static public final String ECLIPSELINK_JAXB = "eclipselink.jaxb";
//    static public final String ECLIPSELINK_SDO = "eclipselink.sdo";
//    static public final String TOPLINK_JAXB = "toplink.jaxb";
//    static public final String TOPLINK_SDO = "toplink.sdo";

    private String mode;
    private Map<String, Object> properties;

    public DatabindingModeFeature(String mode) {
        super();
        this.mode = mode;
        properties = new HashMap<String, Object>();
    }

    public String getMode() {
        return mode;
    }

    public String getID() {
        return ID;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public static Builder builder() { return new Builder(new DatabindingModeFeature(null)); }

    public final static class Builder {
        final private DatabindingModeFeature o;
        Builder(final DatabindingModeFeature x) { o = x; }
        public DatabindingModeFeature build() { return o; }
//        public DatabindingModeFeature build() { return (DatabindingModeFeature) FeatureValidator.validate(o); }
        public Builder value(final String x) { o.mode = x; return this; }
    }
}
