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

import java.lang.reflect.Method;

/**
 * On the client or service-requestor side, a JavaCallInfo object represents a
 * method call on the service proxy to be serialized as a SOAP request message
 * to be sent to the service. A SOAP response message returned to the service
 * client is deserialized as an update to the JavaCallInfo object which is used
 * to generated the request.
 * <p>
 * </p>
 * On the server or service provider side, a SOAP request message is
 * deserialized to a JavaCallInfo object which can be used to determine which
 * method to call, and get the parameter values to call the back-end service
 * implementation object. The return value or exception returned from the
 * service implementation should be set to the JavaCallInfo object which then
 * can be used to serialize to a A SOAP response or fault message to be sent
 * back to the service client.
 *
 * @author shih-chang.chen@oracle.com
 */
public class JavaCallInfo implements com.oracle.webservices.internal.api.databinding.JavaCallInfo {

        private Method method;
        private Object[] parameters;
        private Object returnValue;
        private Throwable exception;

        public JavaCallInfo() {
        }

        public JavaCallInfo(Method m, Object[] args) {
                method = m;
                parameters = args;
        }

        /**
         * Gets the method of this JavaCallInfo
         *
         * @return the method
         */
        public Method getMethod() {
                return method;
        }

        /**
         * Sets the method of this JavaCallInfo
         *
         * @param method
         *            the method to set
         */
        public void setMethod(Method method) {
                this.method = method;
        }

        /**
         * Gets the parameters of this JavaCallInfo
         *
         * @return the parameters
         */
        public Object[] getParameters() {
                return parameters;
        }

        /**
         * Sets the parameters of this JavaCallInfo
         *
         * @param parameters
         *            the parameters to set
         */
        public void setParameters(Object[] parameters) {
                this.parameters = parameters;
        }

        /**
         * Gets the returnValue of this JavaCallInfo
         *
         * @return the returnValue
         */
        public Object getReturnValue() {
                return returnValue;
        }

        /**
         * Sets the returnValue of this JavaCallInfo
         *
         * @param returnValue
         *            the returnValue to set
         */
        public void setReturnValue(Object returnValue) {
                this.returnValue = returnValue;
        }

        /**
         * Gets the exception of this JavaCallInfo
         *
         * @return the exception
         */
        public Throwable getException() {
                return exception;
        }

        /**
         * Sets the exception of this JavaCallInfo
         *
         * @param exception
         *            the exception to set
         */
        public void setException(Throwable exception) {
                this.exception = exception;
        }
}
