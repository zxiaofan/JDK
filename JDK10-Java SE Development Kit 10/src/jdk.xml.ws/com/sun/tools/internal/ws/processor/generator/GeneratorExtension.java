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

package com.sun.tools.internal.ws.processor.generator;

import com.sun.codemodel.internal.JCodeModel;
import com.sun.codemodel.internal.JDefinedClass;
import com.sun.tools.internal.ws.processor.model.Model;
import com.sun.tools.internal.ws.processor.model.Port;
import com.sun.tools.internal.ws.wscompile.WsimportOptions;
import com.sun.xml.internal.ws.api.SOAPVersion;

/**
 * Service Generator Extension for Custom Binding and Transport
 *
 * @since 2.2.6
 * @see JwsImplGenerator
 */
public abstract class GeneratorExtension {

    /**
     * Derive  Binding ID based on transport and SOAP version
     * @param transport
     * @param soapVersion
     * @return BindingID
     */
    public String getBindingValue(String transport, SOAPVersion soapVersion) {
      return null;
    }

    /**
     * Create annotations in service JWS generated
     * @param model
     * @param cm
     * @param cls
     * @param port
     */
    public void writeWebServiceAnnotation(Model model, JCodeModel cm, JDefinedClass cls, Port port) {
    }

    /**
     * Allow additional wsimport options
     * @param name for instance, "-neoption"
     * @return whether the name specifies an option recognized by the extension
     */
    public boolean validateOption(String name) {
      return false;
    }

    /**
     * Create annotations in service client generated
     * @param options
     * @param cm
     * @param cls
     */
    public void writeWebServiceClientAnnotation(WsimportOptions options, JCodeModel cm, JDefinedClass cls) {
    }
}
