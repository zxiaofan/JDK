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
import com.sun.istack.internal.Nullable;

import javax.xml.namespace.QName;

/**
 * Abstracts wsdl:binding/wsdl:operation/wsdl:fault
 *
 * @author Vivek Pandey
 */
public interface WSDLBoundFault extends WSDLObject, WSDLExtensible {

    /**
     * Gives the wsdl:binding/wsdl:operation/wsdl:fault@name value
     */
    public
    @NotNull
    String getName();

    /**
     * Gives the qualified name associated with the fault. the namespace URI of the bounded fault
     * will be the one derived from wsdl:portType namespace.
     *
     * Maybe null if this method is called before the model is completely build (frozen), if a binding fault has no
     * corresponding fault in abstractwsdl:portType/wsdl:operation then the namespace URI of the fault will be that of
     * the WSDBoundPortType.
     */
    public @Nullable QName getQName();

    /**
     * Gives the associated abstract fault from
     * wsdl:portType/wsdl:operation/wsdl:fault. It is only available after
     * the WSDL parsing is complete and the entire model is frozen.
     * <p/>
     * Maybe null if a binding fault has no corresponding fault in abstract
     * wsdl:portType/wsdl:operation
     */
    public
    @Nullable
    WSDLFault getFault();

    /**
     * Gives the owner {@link WSDLBoundOperation}
     */
    @NotNull WSDLBoundOperation getBoundOperation();
}
