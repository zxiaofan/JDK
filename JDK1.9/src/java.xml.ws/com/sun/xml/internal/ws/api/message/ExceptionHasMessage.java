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

package com.sun.xml.internal.ws.api.message;

import com.sun.xml.internal.ws.util.exception.JAXWSExceptionBase;
import com.sun.xml.internal.ws.protocol.soap.VersionMismatchException;

/**
 * This class represents an Exception that needs to be marshalled
 * with a specific protocol wire format. For example, the SOAP's
 * VersionMismatchFault needs to be written with a correct fault code.
 * In that case, decoder could throw {@link VersionMismatchException},
 * and the corresponding fault {@link Message} from {@link ExceptionHasMessage#getFaultMessage()}
 * is sent on the wire.
 *
 * @author Jitendra Kotamraju
 */
public abstract class ExceptionHasMessage extends JAXWSExceptionBase {

    public ExceptionHasMessage(String key, Object... args) {
        super(key, args);
    }

    /**
     * Returns the exception into a fault Message
     *
     * @return Message for this exception
     */
    public abstract Message getFaultMessage();
}
