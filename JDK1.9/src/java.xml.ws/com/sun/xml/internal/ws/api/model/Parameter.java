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

package com.sun.xml.internal.ws.api.model;

import com.sun.xml.internal.bind.api.Bridge;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;

/**
 * Runtime Parameter that abstracts the annotated java parameter
 * <p/>
 * <p/>
 * A parameter may be bound to a header, a body, or an attachment.
 * Note that when it's bound to a body, it's bound to a body,
 * it binds to the whole payload.
 * <p/>
 * <p/>
 * Sometimes multiple Java parameters are packed into the payload,
 * in which case the subclass {@link com.sun.xml.internal.ws.model.WrapperParameter} is used.
 *
 * @author Vivek Pandey
 */
public interface Parameter {
    /**
     * Gets the root {@link SEIModel} that owns this model.
     */
    SEIModel getOwner();

    /**
     * Gets the parent {@link JavaMethod} to which this parameter belongs.
     */
    JavaMethod getParent();

    /**
     * @return Returns the {@link QName} of the payload/infoset of a SOAP body or header.
     */
    QName getName();

    /**
     * Gives the {@link Bridge} associated with this Parameter
     * @deprecated
     */
    Bridge getBridge();

    /**
     * @return Returns the mode, such as IN, OUT or INOUT.
     */
    Mode getMode();

    /**
     * Position of a parameter in the method signature. It would be -1 if the parameter is a return.
     *
     * @return Returns the index.
     */
    int getIndex();

    /**
     * @return true if {@code this instanceof} {@link com.sun.xml.internal.ws.model.WrapperParameter}.
     */
    boolean isWrapperStyle();

    /**
     * Returns true if this parameter is bound to the return value from the {@link JavaMethod}.
     *
     * <p>
     * Just the convenience method for {@code getIndex()==-1}
     */
    boolean isReturnValue();

    /**
     * Returns the binding associated with the parameter. For IN parameter the binding will be
     * same as {@link #getInBinding()}, for OUT parameter the binding will be same as
     * {@link #getOutBinding()} and for INOUT parameter the binding will be same as calling
     * {@link #getInBinding()}
     *
     * @return the Binding for this Parameter. Returns {@link ParameterBinding#BODY} by default.
     */
    ParameterBinding getBinding();

    /**
     * Returns the {@link ParameterBinding} associated with the IN mode
     *
     * @return the binding
     */
    ParameterBinding getInBinding();

    /**
     * Returns the {@link ParameterBinding} associated with the OUT mode
     *
     * @return the binding
     */
    ParameterBinding getOutBinding();

    /**
     * @return true if the {@link Mode} associated with the parameter is {@link Mode#IN} and false otherwise.
     */
    boolean isIN();

    /**
     * @return true if the {@link Mode} associated with the parameter is {@link Mode#OUT} and false otherwise.
     */
    boolean isOUT();

    /**
     * @return true if the {@link Mode} associated with the parameter is {@link Mode#INOUT} and false otherwise.
     */
    boolean isINOUT();

    /**
     * If true, this parameter maps to the return value of a method invocation.
     *
     * <p>
     * {@link JavaMethod#getResponseParameters()} is guaranteed to have
     * at most one such {@link Parameter}. Note that there coule be none,
     * in which case the method returns {@code void}.
     *
     * <p>
     * Other response parameters are bound to {@link Holder}.
     */
    boolean isResponse();

    /**
     * Gets the holder value if applicable. To be called for inbound client side
     * message.
     *
     * @param obj
     * @return the holder value if applicable.
     */
    Object getHolderValue(Object obj);

    /**
     * Gives the wsdl:part@name value
     *
     * @return Value of {@link WebParam#partName()} annotation if present,
     *         otherwise its the localname of the infoset associated with the parameter
     */
    String getPartName();
}
