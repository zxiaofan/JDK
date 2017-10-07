/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.model.wsdl.editable;

import java.util.Map;

import javax.xml.namespace.QName;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLModel;
import com.sun.xml.internal.ws.policy.PolicyMap;

public interface EditableWSDLModel extends WSDLModel {

    @Override
    EditableWSDLPortType getPortType(@NotNull QName name);

    /**
     * Add Binding
     *
     * @param portType Bound port type
     */
    void addBinding(EditableWSDLBoundPortType portType);

    @Override
    EditableWSDLBoundPortType getBinding(@NotNull QName name);

    @Override
    EditableWSDLBoundPortType getBinding(@NotNull QName serviceName, @NotNull QName portName);

    @Override
    EditableWSDLService getService(@NotNull QName name);

    @Override
    @NotNull
    Map<QName, ? extends EditableWSDLMessage> getMessages();

    /**
     * Add message
     *
     * @param msg Message
     */
    public void addMessage(EditableWSDLMessage msg);

    @Override
    @NotNull
    Map<QName, ? extends EditableWSDLPortType> getPortTypes();

    /**
     * Add port type
     *
     * @param pt Port type
     */
    public void addPortType(EditableWSDLPortType pt);

    @Override
    @NotNull
    Map<QName, ? extends EditableWSDLBoundPortType> getBindings();

    @Override
    @NotNull
    Map<QName, ? extends EditableWSDLService> getServices();

    /**
     * Add service
     *
     * @param svc Service
     */
    public void addService(EditableWSDLService svc);

    @Override
    public EditableWSDLMessage getMessage(QName name);

    /**
     * @param policyMap
     * @deprecated
     */
    public void setPolicyMap(PolicyMap policyMap);

    /**
     * Finalize rpc-lit binding
     *
     * @param portType Binding
     */
    public void finalizeRpcLitBinding(EditableWSDLBoundPortType portType);

    /**
     * Freezes WSDL model to prevent further modification
     */
    public void freeze();

}
