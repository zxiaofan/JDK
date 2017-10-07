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

import com.sun.tools.internal.ws.processor.model.Model;
import com.sun.tools.internal.ws.processor.model.Operation;
import com.sun.tools.internal.ws.processor.model.Port;
import com.sun.tools.internal.ws.processor.model.Service;
import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author  dkohlert
 */
public class AnnotationProcessorContext {

    private Map<Name, SeiContext> seiContextMap = new HashMap<Name, SeiContext>();
    private int round = 1;
    private boolean modelCompleted = false;

    public void addSeiContext(Name seiName, SeiContext seiContext) {
        seiContextMap.put(seiName, seiContext);
    }

    public SeiContext getSeiContext(Name seiName) {
        SeiContext context = seiContextMap.get(seiName);
        if (context == null) {
            context = new SeiContext();
            addSeiContext(seiName, context);
        }
        return context;
    }

    public SeiContext getSeiContext(TypeElement d) {
        return getSeiContext(d.getQualifiedName());
    }

    public Collection<SeiContext> getSeiContexts() {
        return seiContextMap.values();
    }

    public int getRound() {
        return round;
    }

    public void incrementRound() {
        round++;
    }

    public static boolean isEncoded(Model model) {
        if (model == null)
            return false;
        for (Service service : model.getServices()) {
            for (Port port : service.getPorts()) {
                for (Operation operation : port.getOperations()) {
                    if (operation.getUse() != null && operation.getUse().equals(SOAPUse.LITERAL))
                        return false;
                }
            }
        }
        return true;
    }

    public void setModelCompleted(boolean modelCompleted) {
        this.modelCompleted = modelCompleted;
    }

    public boolean isModelCompleted() {
        return modelCompleted;
    }

    public static class SeiContext {

        private Map<String, WrapperInfo> reqOperationWrapperMap = new HashMap<String, WrapperInfo>();
        private Map<String, WrapperInfo> resOperationWrapperMap = new HashMap<String, WrapperInfo>();
        private Map<Name, FaultInfo> exceptionBeanMap = new HashMap<Name, FaultInfo>();

        private Name seiImplName;
        private boolean implementsSei;
        private String namespaceUri;

        public SeiContext() {};

        /**
         * @deprecated use empty constructor, seiName value is ignored
         * @param seiName
         */
        public SeiContext(Name seiName) {};

        public void setImplementsSei(boolean implementsSei) {
            this.implementsSei = implementsSei;
        }

        public boolean getImplementsSei() {
            return implementsSei;
        }

        public void setNamespaceUri(String namespaceUri) {
            this.namespaceUri = namespaceUri;
        }

        public String getNamespaceUri() {
            return namespaceUri;
        }

        public Name getSeiImplName() {
            return seiImplName;
        }

        public void setSeiImplName(Name implName) {
            seiImplName = implName;
        }

        public void setReqWrapperOperation(ExecutableElement method, WrapperInfo wrapperInfo) {
            reqOperationWrapperMap.put(methodToString(method), wrapperInfo);
        }

        public WrapperInfo getReqOperationWrapper(ExecutableElement method) {
            return reqOperationWrapperMap.get(methodToString(method));
        }

        public void setResWrapperOperation(ExecutableElement method, WrapperInfo wrapperInfo) {
            resOperationWrapperMap.put(methodToString(method), wrapperInfo);
        }

        public WrapperInfo getResOperationWrapper(ExecutableElement method) {
            return resOperationWrapperMap.get(methodToString(method));
        }

        public String methodToString(ExecutableElement method) {
            StringBuilder buf = new StringBuilder(method.getSimpleName());
            for (VariableElement param : method.getParameters())
                buf.append(';').append(param.asType());
            return buf.toString();
        }

        public void clearExceptionMap() {
            exceptionBeanMap.clear();
        }

        public void addExceptionBeanEntry(Name exception, FaultInfo faultInfo, ModelBuilder builder) {
            exceptionBeanMap.put(exception, faultInfo);
        }

        public FaultInfo getExceptionBeanName(Name exception) {
            return exceptionBeanMap.get(exception);
        }
    }
}
