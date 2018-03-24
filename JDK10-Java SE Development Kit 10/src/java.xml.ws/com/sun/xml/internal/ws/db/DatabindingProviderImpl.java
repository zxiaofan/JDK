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

package com.sun.xml.internal.ws.db;

import java.io.File;
import java.util.Map;

import com.oracle.webservices.internal.api.databinding.WSDLGenerator;
import com.oracle.webservices.internal.api.databinding.WSDLResolver;
import com.sun.xml.internal.ws.api.databinding.Databinding;
import com.sun.xml.internal.ws.api.databinding.DatabindingConfig;
import com.sun.xml.internal.ws.api.databinding.WSDLGenInfo;
import com.sun.xml.internal.ws.spi.db.DatabindingProvider;

/**
 * DatabindingProviderImpl is the  default JAXWS implementation of DatabindingProvider
 *
 * @author shih-chang.chen@oracle.com
 */
public class DatabindingProviderImpl implements DatabindingProvider {
    static final private String CachedDatabinding = "com.sun.xml.internal.ws.db.DatabindingProviderImpl";
        Map<String, Object> properties;

        public void init(Map<String, Object> p) {
            properties = p;
        }

        DatabindingImpl getCachedDatabindingImpl(DatabindingConfig config) {
            Object object = config.properties().get(CachedDatabinding);
            return (object != null && object instanceof DatabindingImpl)? (DatabindingImpl)object : null;
        }

        public Databinding create(DatabindingConfig config) {
            DatabindingImpl impl = getCachedDatabindingImpl(config);
            if (impl == null) {
                impl = new DatabindingImpl(this, config);
                config.properties().put(CachedDatabinding, impl);
            }
                return impl;
        }

    public WSDLGenerator wsdlGen(DatabindingConfig config) {
        DatabindingImpl impl = (DatabindingImpl)create(config);
        return new JaxwsWsdlGen(impl);
    }

    public boolean isFor(String databindingMode) {
        //This is the default one, so it always return true
        return true;
    }

    static public class JaxwsWsdlGen implements WSDLGenerator {
        DatabindingImpl databinding;
        WSDLGenInfo wsdlGenInfo;

        JaxwsWsdlGen(DatabindingImpl impl) {
            databinding = impl;
            wsdlGenInfo = new WSDLGenInfo();
        }

        public WSDLGenerator inlineSchema(boolean inline) {
            wsdlGenInfo.setInlineSchemas(inline);
            return this;
        }

        public WSDLGenerator property(String name, Object value) {
            // TODO wsdlGenInfo.set...
            return this;
        }

        public void generate(WSDLResolver wsdlResolver) {
            wsdlGenInfo.setWsdlResolver(wsdlResolver);
            databinding.generateWSDL(wsdlGenInfo);
        }

        public void generate(File outputDir, String name) {
            // TODO Auto-generated method stub
            databinding.generateWSDL(wsdlGenInfo);
        }
    }
}
