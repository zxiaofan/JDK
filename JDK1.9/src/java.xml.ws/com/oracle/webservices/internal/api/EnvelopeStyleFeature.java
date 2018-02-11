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

package com.oracle.webservices.internal.api;

import javax.xml.ws.WebServiceFeature;

public class EnvelopeStyleFeature extends WebServiceFeature {

    private EnvelopeStyle.Style[] styles;

    public EnvelopeStyleFeature(EnvelopeStyle.Style... s) {
        styles = s;
    }

    public EnvelopeStyle.Style[] getStyles() {
        return styles;
    }

    public String getID() {
        return EnvelopeStyleFeature.class.getName();
    }
}
