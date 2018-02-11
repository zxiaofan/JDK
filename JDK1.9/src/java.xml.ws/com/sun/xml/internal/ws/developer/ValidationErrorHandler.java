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

package com.sun.xml.internal.ws.developer;

import com.sun.xml.internal.ws.api.message.Packet;
import org.xml.sax.ErrorHandler;

import javax.xml.ws.handler.MessageContext;
import javax.xml.validation.Validator;

/**
 * An {@link ErrorHandler} to receive errors encountered during the
 * {@link Validator#validate} method invocation. Specify
 * a custom handler in {@link SchemaValidation}, {@link SchemaValidationFeature}
 * to customize the error handling process during validation.
 *
 * @see SchemaValidation
 * @author Jitendra Kotamraju
 */
public abstract class ValidationErrorHandler implements ErrorHandler {
    protected Packet packet;

    /**
     * Use it to communicate validation errors with the application.
     *
     * For e.g validation exceptions can be stored in {@link Packet#invocationProperties}
     * during request processing and can be accessed in the endpoint
     * via {@link MessageContext}
     *
     * @param packet for request or response message
     */
    public void setPacket(Packet packet) {
        this.packet = packet;
    }

}
