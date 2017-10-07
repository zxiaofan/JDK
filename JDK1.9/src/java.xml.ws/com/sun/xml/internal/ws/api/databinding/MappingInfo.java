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

import javax.xml.namespace.QName;

import com.sun.xml.internal.ws.api.BindingID;

/**
 * A MappingInfo object is the collection of all the properties of the mapping
 * between a JAVA contract class (SEI) and it's corresponding WSDL artifacts
 * (wsdl:portType and wsdl:binding). A MappingInfo object can be used to provide
 * additional mapping metadata for WSDL generation and the runtime of WebService
 * databinding.
 *
 * @author shih-chang.chen@oracle.com
 */
public class MappingInfo {
        protected String targetNamespace;
        protected String databindingMode;
        protected SoapBodyStyle soapBodyStyle;
        protected BindingID bindingID;
        protected QName serviceName;
        protected QName portName;
        protected String defaultSchemaNamespaceSuffix;

    public String getTargetNamespace() {
                return targetNamespace;
        }
        public void setTargetNamespace(String targetNamespace) {
                this.targetNamespace = targetNamespace;
        }
        public String getDatabindingMode() {
                return databindingMode;
        }
        public void setDatabindingMode(String databindingMode) {
                this.databindingMode = databindingMode;
        }
        public SoapBodyStyle getSoapBodyStyle() {
                return soapBodyStyle;
        }
        public void setSoapBodyStyle(SoapBodyStyle soapBodyStyle) {
                this.soapBodyStyle = soapBodyStyle;
        }
        public BindingID getBindingID() {
                return bindingID;
        }
        public void setBindingID(BindingID bindingID) {
                this.bindingID = bindingID;
        }
        public QName getServiceName() {
                return serviceName;
        }
        public void setServiceName(QName serviceName) {
                this.serviceName = serviceName;
        }
        public QName getPortName() {
                return portName;
        }
        public void setPortName(QName portName) {
                this.portName = portName;
        }
    public String getDefaultSchemaNamespaceSuffix() {
        return defaultSchemaNamespaceSuffix;
    }
    public void setDefaultSchemaNamespaceSuffix(String defaultSchemaNamespaceSuffix) {
        this.defaultSchemaNamespaceSuffix = defaultSchemaNamespaceSuffix;
    }
}
