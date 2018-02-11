/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.model;

import java.lang.reflect.Method;

import com.sun.xml.internal.bind.api.Bridge;
import com.sun.xml.internal.ws.api.model.CheckedException;
import com.sun.xml.internal.ws.api.model.ExceptionType;
import com.sun.xml.internal.ws.api.model.JavaMethod;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import com.sun.xml.internal.ws.spi.db.XMLBridge;
import com.sun.xml.internal.ws.spi.db.TypeInfo;

/**
 * CheckedException class. Holds the exception class - class that has public
 * constructor
 *
 * <code>public WrapperException()String message, FaultBean){}</code>
 *
 * and method
 *
 * <code>public FaultBean getFaultInfo();</code>
 *
 * @author Vivek Pandey
 */
public final class CheckedExceptionImpl implements CheckedException {
    private final Class exceptionClass;
    private final TypeInfo detail;
    private final ExceptionType exceptionType;
    private final JavaMethodImpl javaMethod;
    private String messageName;
    private String faultAction = "";
    private Method faultInfoGetter;

    /**
     * @param jm {@link JavaMethodImpl} that throws this exception
     * @param exceptionClass
     *            Userdefined or WSDL exception class that extends
     *            java.lang.Exception.
     * @param detail
     *            detail or exception bean's TypeReference
     * @param exceptionType
     *            either ExceptionType.UserDefined or
     */
    public CheckedExceptionImpl(JavaMethodImpl jm, Class exceptionClass, TypeInfo detail, ExceptionType exceptionType) {
        this.detail = detail;
        this.exceptionType = exceptionType;
        this.exceptionClass = exceptionClass;
        this.javaMethod = jm;
    }

    public AbstractSEIModelImpl getOwner() {
        return javaMethod.owner;
    }

    public JavaMethod getParent() {
        return javaMethod;
    }

    /**
     * @return the <code>Class</clode> for this object
     *
     */
    public Class getExceptionClass() {
        return exceptionClass;
    }

    public Class getDetailBean() {
        return (Class) detail.type;
    }
    /** @deprecated */
    public Bridge getBridge() {
//TODO        return getOwner().getBridge(detail);
        return null;
    }

    public XMLBridge getBond() {
        return getOwner().getXMLBridge(detail);
    }

    public TypeInfo getDetailType() {
        return detail;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getFaultAction() {
        return faultAction;
    }

    public void setFaultAction(String faultAction) {
        this.faultAction = faultAction;
    }

    public String getDefaultFaultAction() {
        return WsaActionUtil.getDefaultFaultAction(javaMethod,this);
    }

    public Method getFaultInfoGetter() {
        return faultInfoGetter;
    }

    public void setFaultInfoGetter(Method faultInfoGetter) {
        this.faultInfoGetter = faultInfoGetter;
    }
}
