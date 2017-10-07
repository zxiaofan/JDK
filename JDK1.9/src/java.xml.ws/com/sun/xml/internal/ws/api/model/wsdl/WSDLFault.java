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

package com.sun.xml.internal.ws.api.model.wsdl;

import com.sun.istack.internal.NotNull;

import javax.xml.namespace.QName;

/**
 * Abstracts wsdl:portType/wsdl:operation/wsdl:fault
 *
 * @author Vivek Pandey
 */
public interface WSDLFault extends WSDLObject, WSDLExtensible {
    /**
     * Gives wsdl:fault@name value
     */
    String getName();

    /**
     * Gives the WSDLMessage corresponding to wsdl:fault@message
     * This method should not be called before the entire WSDLModel is built. Basically after the WSDLModel is built
     * all the references are resolve in a post processing phase. IOW, the WSDL extensions should
     * not call this method.
     *
     * @return Always returns null when called from inside WSDL extensions.
     */
    WSDLMessage getMessage();

    /**
     * Gives the owning {@link WSDLOperation}
     */
    @NotNull
    WSDLOperation getOperation();

    /**
     * Gives qualified name of the wsdl:fault 'name' attribute value.
     * <p/>
     *
     * The namespace uri is determined from the enclosing wsdl:operation.
     */
    @NotNull
    QName getQName();

    /**
     * Gives the Action Message Addressing Property value for
     * {@link WSDLFault} message.
     * <p/>
     * This method provides the correct value irrespective of
     * whether the Action is explicitly specified in the WSDL or
     * implicitly derived using the rules defined in WS-Addressing.
     *
     * @return Action
     */
    String getAction();

    /**
     * True if this is the default action
     * @return
     */
    public boolean isDefaultAction();
}
