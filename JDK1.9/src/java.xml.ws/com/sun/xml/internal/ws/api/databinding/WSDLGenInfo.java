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

package com.sun.xml.internal.ws.api.databinding;

import com.oracle.webservices.internal.api.databinding.WSDLResolver;
import com.sun.xml.internal.ws.api.server.Container;
import com.sun.xml.internal.ws.api.wsdl.writer.WSDLGeneratorExtension;

/**
 * WSDLGenInfo provides the WSDL generation options
 *
 * @author shih-chang.chen@oracle.com
 */
public class WSDLGenInfo {
        WSDLResolver wsdlResolver;
        Container container;
    boolean inlineSchemas;
    boolean secureXmlProcessingDisabled;
    WSDLGeneratorExtension[] extensions;

        public WSDLResolver getWsdlResolver() {
                return wsdlResolver;
        }
        public void setWsdlResolver(WSDLResolver wsdlResolver) {
                this.wsdlResolver = wsdlResolver;
        }
        public Container getContainer() {
                return container;
        }
        public void setContainer(Container container) {
                this.container = container;
        }
        public boolean isInlineSchemas() {
                return inlineSchemas;
        }
        public void setInlineSchemas(boolean inlineSchemas) {
                this.inlineSchemas = inlineSchemas;
        }
        public WSDLGeneratorExtension[] getExtensions() {
            if (extensions == null) return new WSDLGeneratorExtension[0];
                return extensions;
        }
        public void setExtensions(WSDLGeneratorExtension[] extensions) {
                this.extensions = extensions;
        }

    public void setSecureXmlProcessingDisabled(boolean secureXmlProcessingDisabled) {
        this.secureXmlProcessingDisabled = secureXmlProcessingDisabled;
    }

    public boolean isSecureXmlProcessingDisabled() {
        return secureXmlProcessingDisabled;
    }
}
