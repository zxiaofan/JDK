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

package com.sun.xml.internal.ws.model.soap;

import com.sun.xml.internal.ws.api.model.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import com.sun.xml.internal.ws.api.SOAPVersion;

/**
 * A wsdl:opeartion binding object that represents soap:binding. This can be
 * the return of {@link com.sun.xml.internal.ws.api.model.JavaMethod#getBinding()}.
 * <p/>
 * the default values are always document/literal and SoapVersion is SOAP 1.1.
 *
 * @author Vivek Pandey
 */
public class SOAPBindingImpl extends SOAPBinding {
    public SOAPBindingImpl() {
    }

    public SOAPBindingImpl(SOAPBinding sb) {
        this.use = sb.getUse();
        this.style = sb.getStyle();
        this.soapVersion = sb.getSOAPVersion();
        this.soapAction = sb.getSOAPAction();
    }

    /**
     * @param style The style to set.
     */
    public void setStyle(Style style) {
        this.style = style;
    }

    /**
     * @param version
     */
    public void setSOAPVersion(SOAPVersion version) {
        this.soapVersion = version;
    }

    /**
     * @param soapAction The soapAction to set.
     */
    public void setSOAPAction(String soapAction) {
        this.soapAction = soapAction;
    }
}
