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

package com.sun.tools.internal.ws.processor.modeler.annotation;

import javax.xml.namespace.QName;

/**
 *
 * @author  dkohlert
 */
public class FaultInfo {
    public String beanName;
    public TypeMoniker beanTypeMoniker;
    public boolean isWsdlException;
    public QName elementName;

    /** Creates a new instance of FaultInfo */
    public FaultInfo() {
    }
    public FaultInfo(String beanName) {
        this.beanName = beanName;
    }
    public FaultInfo(String beanName, boolean isWsdlException) {
        this.beanName = beanName;
        this.isWsdlException = isWsdlException;
    }
    public FaultInfo(TypeMoniker typeMoniker, boolean isWsdlException) {
        this.beanTypeMoniker = typeMoniker;
        this.isWsdlException = isWsdlException;
    }

    public void setIsWsdlException(boolean isWsdlException) {
        this.isWsdlException = isWsdlException;
    }

    public boolean isWsdlException() {
        return isWsdlException;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setElementName(QName elementName) {
        this.elementName =  elementName;
    }

    public QName getElementName() {
        return elementName;
    }
    public void setBeanTypeMoniker(TypeMoniker typeMoniker) {
        this.beanTypeMoniker = typeMoniker;
    }
    public TypeMoniker getBeanTypeMoniker() {
        return beanTypeMoniker;
    }

}
