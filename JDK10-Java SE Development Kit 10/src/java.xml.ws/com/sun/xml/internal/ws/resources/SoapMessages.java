/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.resources;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.Generated;
import com.sun.istack.internal.localization.Localizable;
import com.sun.istack.internal.localization.LocalizableMessageFactory;
import com.sun.istack.internal.localization.LocalizableMessageFactory.ResourceBundleSupplier;
import com.sun.istack.internal.localization.Localizer;


/**
 * Defines string formatting method for each constant in the resource file
 *
 */
@Generated("com.sun.istack.internal.maven.ResourceGenMojo")
public final class SoapMessages {

    private final static String BUNDLE_NAME = "com.sun.xml.internal.ws.resources.soap";
    private final static LocalizableMessageFactory MESSAGE_FACTORY = new LocalizableMessageFactory(BUNDLE_NAME, new SoapMessages.BundleSupplier());
    private final static Localizer LOCALIZER = new Localizer();

    public static Localizable localizableSOAP_FAULT_CREATE_ERR(Object arg0) {
        return MESSAGE_FACTORY.getMessage("soap.fault.create.err", arg0);
    }

    /**
     * Couldn''t create SOAP Fault due to exception: {0}
     *
     */
    public static String SOAP_FAULT_CREATE_ERR(Object arg0) {
        return LOCALIZER.localize(localizableSOAP_FAULT_CREATE_ERR(arg0));
    }

    public static Localizable localizableSOAP_PROTOCOL_INVALID_FAULT_CODE(Object arg0) {
        return MESSAGE_FACTORY.getMessage("soap.protocol.invalidFaultCode", arg0);
    }

    /**
     * Invalid fault code: {0}
     *
     */
    public static String SOAP_PROTOCOL_INVALID_FAULT_CODE(Object arg0) {
        return LOCALIZER.localize(localizableSOAP_PROTOCOL_INVALID_FAULT_CODE(arg0));
    }

    public static Localizable localizableSOAP_VERSION_MISMATCH_ERR(Object arg0, Object arg1) {
        return MESSAGE_FACTORY.getMessage("soap.version.mismatch.err", arg0, arg1);
    }

    /**
     * Couldn''t create SOAP message. Expecting Envelope in namespace {0}, but got {1}
     *
     */
    public static String SOAP_VERSION_MISMATCH_ERR(Object arg0, Object arg1) {
        return LOCALIZER.localize(localizableSOAP_VERSION_MISMATCH_ERR(arg0, arg1));
    }

    public static Localizable localizableSOAP_MSG_FACTORY_CREATE_ERR(Object arg0) {
        return MESSAGE_FACTORY.getMessage("soap.msg.factory.create.err", arg0);
    }

    /**
     * Couldn''t create SOAP message factory due to exception: {0}
     *
     */
    public static String SOAP_MSG_FACTORY_CREATE_ERR(Object arg0) {
        return LOCALIZER.localize(localizableSOAP_MSG_FACTORY_CREATE_ERR(arg0));
    }

    public static Localizable localizableSOAP_MSG_CREATE_ERR(Object arg0) {
        return MESSAGE_FACTORY.getMessage("soap.msg.create.err", arg0);
    }

    /**
     * Couldn''t create SOAP message due to exception: {0}
     *
     */
    public static String SOAP_MSG_CREATE_ERR(Object arg0) {
        return LOCALIZER.localize(localizableSOAP_MSG_CREATE_ERR(arg0));
    }

    public static Localizable localizableSOAP_FACTORY_CREATE_ERR(Object arg0) {
        return MESSAGE_FACTORY.getMessage("soap.factory.create.err", arg0);
    }

    /**
     * Couldn''t create SOAP factory due to exception: {0}
     *
     */
    public static String SOAP_FACTORY_CREATE_ERR(Object arg0) {
        return LOCALIZER.localize(localizableSOAP_FACTORY_CREATE_ERR(arg0));
    }

    private static class BundleSupplier
        implements ResourceBundleSupplier
    {


        public ResourceBundle getResourceBundle(Locale locale) {
            return ResourceBundle.getBundle(BUNDLE_NAME, locale);
        }

    }

}
