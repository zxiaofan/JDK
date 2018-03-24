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

package com.sun.xml.internal.ws.spi.db;

import java.net.URL;
import java.util.Collection;
import java.util.Map;

import com.sun.xml.internal.ws.api.model.SEIModel;

/**
 * BindingInfo
 *
 * @author shih-chang.chen@oracle.com
 */
public class BindingInfo {

        private String databindingMode;
        private String defaultNamespace;

        private Collection<Class> contentClasses = new java.util.ArrayList<Class>();
    private Collection<TypeInfo> typeInfos = new java.util.ArrayList<TypeInfo>();
    private Map<Class,Class> subclassReplacements = new java.util.HashMap<Class, Class>();
    private Map<String, Object> properties = new java.util.HashMap<String, Object>();
        protected ClassLoader classLoader;

    private SEIModel seiModel;
    private URL wsdlURL;

    public String getDatabindingMode() {
                return databindingMode;
        }
        public void setDatabindingMode(String databindingMode) {
                this.databindingMode = databindingMode;
        }

        public String getDefaultNamespace() {
                return defaultNamespace;
        }
        public void setDefaultNamespace(String defaultNamespace) {
                this.defaultNamespace = defaultNamespace;
        }

        public Collection<Class> contentClasses() {
                return contentClasses;
        }
        public Collection<TypeInfo> typeInfos() {
                return typeInfos;
        }
        public Map<Class, Class> subclassReplacements() {
                return subclassReplacements;
        }
        public Map<String, Object> properties() {
                return properties;
        }

        public SEIModel getSEIModel() {
                return seiModel;
        }
        public void setSEIModel(SEIModel seiModel) {
                this.seiModel = seiModel;
        }
        public ClassLoader getClassLoader() {
                return classLoader;
        }
        public void setClassLoader(ClassLoader classLoader) {
                this.classLoader = classLoader;
        }
    public URL getWsdlURL() {
        return wsdlURL;
    }
    public void setWsdlURL(URL wsdlURL) {
        this.wsdlURL = wsdlURL;
    }
}
