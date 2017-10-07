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

package com.sun.xml.internal.ws.model.wsdl;

import java.util.List;

import com.sun.xml.internal.ws.api.EndpointAddress;
import com.sun.xml.internal.ws.api.SOAPVersion;
import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPort;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLBoundPortType;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLModel;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLPort;
import com.sun.xml.internal.ws.api.model.wsdl.editable.EditableWSDLService;
import com.sun.xml.internal.ws.resources.ClientMessages;
import com.sun.xml.internal.ws.util.exception.LocatableWebServiceException;
import com.sun.xml.internal.ws.wsdl.parser.RuntimeWSDLParser;
import com.sun.xml.internal.ws.binding.WebServiceFeatureList;
import com.sun.istack.internal.Nullable;
import com.sun.istack.internal.NotNull;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;

/**
 * Implementation of {@link WSDLPort}
 *
 * @author Vivek Pandey
 */
public final class WSDLPortImpl extends AbstractFeaturedObjectImpl implements EditableWSDLPort {
    private final QName name;
    private EndpointAddress address;
    private final QName bindingName;
    private final EditableWSDLService owner;
    private WSEndpointReference epr;

    /**
     * To be set after the WSDL parsing is complete.
     */
    private EditableWSDLBoundPortType boundPortType;

    public WSDLPortImpl(XMLStreamReader xsr, EditableWSDLService owner, QName name, QName binding) {
        super(xsr);
        this.owner = owner;
        this.name = name;
        this.bindingName = binding;
    }

    public QName getName() {
        return name;
    }

    public QName getBindingName() {
        return bindingName;
    }

    public EndpointAddress getAddress() {
        return address;
    }

    public EditableWSDLService getOwner() {
        return owner;
    }

    /**
     * Only meant for {@link RuntimeWSDLParser} to call.
     */
    public void setAddress(EndpointAddress address) {
        assert address!=null;
        this.address = address;
    }

    /**
     * Only meant for {@link RuntimeWSDLParser} to call.
     */
    public void setEPR(@NotNull WSEndpointReference epr) {
        assert epr!=null;
        this.addExtension(epr);
        this.epr = epr;
    }

    public @Nullable WSEndpointReference getEPR() {
        return epr;
    }

    public EditableWSDLBoundPortType getBinding() {
        return boundPortType;
    }

    @SuppressWarnings("unchecked")
    public void freeze(EditableWSDLModel root) {
        boundPortType = root.getBinding(bindingName);
        if(boundPortType==null) {
            throw new LocatableWebServiceException(
                ClientMessages.UNDEFINED_BINDING(bindingName), getLocation());
        }
        if(features == null)
            features =  new WebServiceFeatureList();
        features.setParentFeaturedObject(boundPortType);
        notUnderstoodExtensions.addAll((List<UnknownWSDLExtension>)boundPortType.getNotUnderstoodExtensions());
    }
}
