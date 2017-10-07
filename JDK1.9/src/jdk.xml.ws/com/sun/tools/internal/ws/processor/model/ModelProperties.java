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

package com.sun.tools.internal.ws.processor.model;

/**
 *
 * @author WS Development Team
 */
public interface ModelProperties {

    //to set WSDL_MODELER_NAME from inside WSDLModeler
    public static final String WSDL_MODELER_NAME =
        "com.sun.xml.internal.ws.processor.modeler.wsdl.WSDLModeler";
    public static final String PROPERTY_PARAM_MESSAGE_PART_NAME =
        "com.sun.xml.internal.ws.processor.model.ParamMessagePartName";
    public static final String PROPERTY_ANONYMOUS_TYPE_NAME =
        "com.sun.xml.internal.ws.processor.model.AnonymousTypeName";
    public static final String PROPERTY_ANONYMOUS_ARRAY_TYPE_NAME =
        "com.sun.xml.internal.ws.processor.model.AnonymousArrayTypeName";
    public static final String PROPERTY_ANONYMOUS_ARRAY_JAVA_TYPE =
        "com.sun.xml.internal.ws.processor.model.AnonymousArrayJavaType";

    public static final String PROPERTY_PTIE_CLASS_NAME =
        "com.sun.xml.internal.ws.processor.model.PtieClassName";
    public static final String PROPERTY_EPTFF_CLASS_NAME =
        "com.sun.xml.internal.ws.processor.model.EPTFFClassName";
    public static final String PROPERTY_SED_CLASS_NAME =
        "com.sun.xml.internal.ws.processor.model.SEDClassName";
        public static final String PROPERTY_WSDL_PORT_NAME =
        "com.sun.xml.internal.ws.processor.model.WSDLPortName";
    public static final String PROPERTY_WSDL_PORT_TYPE_NAME =
        "com.sun.xml.internal.ws.processor.model.WSDLPortTypeName";
    public static final String PROPERTY_WSDL_BINDING_NAME =
        "com.sun.xml.internal.ws.processor.model.WSDLBindingName";
    public static final String PROPERTY_WSDL_MESSAGE_NAME =
        "com.sun.xml.internal.ws.processor.model.WSDLMessageName";
    public static final String PROPERTY_MODELER_NAME =
        "com.sun.xml.internal.ws.processor.model.ModelerName";
    public static final String PROPERTY_STUB_CLASS_NAME =
        "com.sun.xml.internal.ws.processor.model.StubClassName";
    public static final String PROPERTY_STUB_OLD_CLASS_NAME =
        "com.sun.xml.internal.ws.processor.model.StubOldClassName";
    public static final String PROPERTY_DELEGATE_CLASS_NAME =
        "com.sun.xml.internal.ws.processor.model.DelegateClassName";
    public static final String PROPERTY_CLIENT_ENCODER_DECODER_CLASS_NAME =
        "com.sun.xml.internal.ws.processor.model.ClientEncoderClassName";
    public static final String PROPERTY_CLIENT_CONTACTINFOLIST_CLASS_NAME =
        "com.sun.xml.internal.ws.processor.model.ClientContactInfoListClassName";
    public static final String PROPERTY_TIE_CLASS_NAME =
        "com.sun.xml.internal.ws.processor.model.TieClassName";
    public static final String PROPERTY_JAVA_PORT_NAME =
        "com.sun.xml.internal.ws.processor.model.JavaPortName";
}
