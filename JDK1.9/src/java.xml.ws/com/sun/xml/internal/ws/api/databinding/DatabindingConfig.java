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

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.ws.WebServiceFeature;

import org.xml.sax.EntityResolver;

import com.sun.xml.internal.ws.api.WSBinding;
import com.sun.xml.internal.ws.api.WSFeatureList;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPort;
import com.sun.xml.internal.ws.binding.WebServiceFeatureList;

/**
 * DatabindingConfig contains the initial states for Databinding. After a Databinding
 * instance is created, all it's internal states should be considered
 * 'immutable' and therefore the operations on Databinding are thread-safe.
 *
 * @author shih-chang.chen@oracle.com
 */
public class DatabindingConfig {
    protected Class contractClass;
        protected Class endpointClass;
        protected Set<Class> additionalValueTypes = new HashSet<Class>();
        protected MappingInfo mappingInfo = new MappingInfo();
        protected URL wsdlURL;
        protected ClassLoader classLoader;
        protected Iterable<WebServiceFeature> features;
        protected WSBinding wsBinding;
        protected WSDLPort wsdlPort;
        protected MetadataReader metadataReader;
        protected Map<String, Object> properties = new HashMap<String, Object>();
    protected Source wsdlSource;
    protected EntityResolver entityResolver;

        public Class getContractClass() {
                return contractClass;
        }
        public void setContractClass(Class contractClass) {
                this.contractClass = contractClass;
        }
        public Class getEndpointClass() {
                return endpointClass;
        }
        public void setEndpointClass(Class implBeanClass) {
                this.endpointClass = implBeanClass;
        }
        public MappingInfo getMappingInfo() {
                return mappingInfo;
        }
        public void setMappingInfo(MappingInfo mappingInfo) {
                this.mappingInfo = mappingInfo;
        }
        public URL getWsdlURL() {
                return wsdlURL;
        }
        public void setWsdlURL(URL wsdlURL) {
                this.wsdlURL = wsdlURL;
        }
        public ClassLoader getClassLoader() {
                return classLoader;
        }
        public void setClassLoader(ClassLoader classLoader) {
                this.classLoader = classLoader;
        }
        public Iterable<WebServiceFeature> getFeatures() {
            if (features == null && wsBinding != null) return wsBinding.getFeatures();
                return features;
        }
        public void setFeatures(WebServiceFeature[] features) {
                setFeatures(new WebServiceFeatureList(features));
        }
        public void setFeatures(Iterable<WebServiceFeature> features) {
                this.features = WebServiceFeatureList.toList(features);
        }
        public WSDLPort getWsdlPort() {
                return wsdlPort;
        }
        public void setWsdlPort(WSDLPort wsdlPort) {
                this.wsdlPort = wsdlPort;
        }
        public Set<Class> additionalValueTypes() {
                return additionalValueTypes;
        }
        public Map<String, Object> properties() {
                return properties;
        }
        public WSBinding getWSBinding() {
                return wsBinding;
        }
        public void setWSBinding(WSBinding wsBinding) {
                this.wsBinding = wsBinding;
        }
        public MetadataReader getMetadataReader() {
                return metadataReader;
        }
        public void setMetadataReader(MetadataReader  reader) {
                this.metadataReader = reader;
        }

    public Source getWsdlSource() {
        return wsdlSource;
    }
    public void setWsdlSource(Source wsdlSource) {
        this.wsdlSource = wsdlSource;
    }
    public EntityResolver getEntityResolver() {
        return entityResolver;
    }
    public void setEntityResolver(EntityResolver entityResolver) {
        this.entityResolver = entityResolver;
    }
}
