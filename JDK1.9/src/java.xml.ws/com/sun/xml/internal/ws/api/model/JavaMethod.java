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

package com.sun.xml.internal.ws.api.model;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.model.soap.SOAPBinding;

import javax.xml.namespace.QName;
import java.lang.reflect.Method;
import java.util.Collection;

import javax.jws.WebService;

/**
 * Abstracts the annotated {@link Method} of a SEI.
 *
 * @author Vivek Pandey
 */
public interface JavaMethod {

    /**
     * Gets the root {@link SEIModel} that owns this model.
     */
    SEIModel getOwner();

    /**
     * On the server side, it uses this for invocation of the web service
     *
     * <p>
     * {@literal @}{@link WebService}(endpointInterface="I")
     * class A { }
     *
     * In this case, it retuns A's method
     *
     * <p>
     * {@literal @}{@link WebService}(endpointInterface="I")
     * class A implements I { }
     * In this case, it returns A's method
     *
     * <p>
     * {@literal @}{@link WebService}
     * class A { }
     * In this case, it returns A's method
     *
     * @return Returns the java {@link Method}
     */
    @NotNull Method getMethod();


    /**
     * This should be used if you want to access annotations on WebMethod
     * Returns the SEI method if there is one.
     *
     * <p>
     * {@literal @}{@link WebService}(endpointInterface="I")
     * class A { }
     * In this case, it retuns I's method
     *
     * <p>
     * {@literal @}{@link WebService}(endpointInterface="I")
     * class A implements I { }
     * In this case, it returns I's method
     *
     * <p>
     * {@literal @}{@link WebService}
     * class A { }
     * In this case, it returns A's method
     *
     * @return Returns the java {@link Method}
     */
    @NotNull Method getSEIMethod();

    /**
     * @return Returns the {@link MEP}.
     */
    MEP getMEP();

    /**
     * Binding object - a {@link SOAPBinding} isntance.
     *
     * @return the Binding object
     */
    SOAPBinding getBinding();

    /**
     * Gives the wsdl:operation@name value
     */
    @NotNull String getOperationName();


    /**
     * Gives the request wsdl:message@name value
     */
    @NotNull String getRequestMessageName();

    /**
     * Gives the response wsdl:messageName value
     * @return null if its a oneway operation that is getMEP().isOneWay()==true.
     * @see com.sun.xml.internal.ws.api.model.MEP#isOneWay()
     */
    @Nullable String getResponseMessageName();

    /**
     * Gives soap:Body's first child's name for request message.
     *
     * @return
     *      null if this operation doesn't have any request parameter bound to the body.
     */
    @Nullable QName getRequestPayloadName();

    /**
     * Gives soap:Body's first child's name for response message.
     *
     * @return
     *      null if this operation doesn't have any response parameter bound to the body.
     */
    @Nullable QName getResponsePayloadName();

    /**
     * Gives the checked Exception thrown from this method.
     *
     * @return Returns the {@link CheckedException}.
     */
    Collection<? extends CheckedException> getCheckedExceptions();
}
