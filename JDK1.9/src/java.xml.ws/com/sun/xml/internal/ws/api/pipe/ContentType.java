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

package com.sun.xml.internal.ws.api.pipe;

/**
 * A Content-Type transport header that will be returned by {@link Codec#encode(com.sun.xml.internal.ws.api.message.Packet, java.io.OutputStream)}.
 * It will provide the Content-Type header and also take care of SOAP 1.1 SOAPAction header.
 *
 * @see com.oracle.webservices.internal.api.message.ContentType
 * TODO: rename to ContentMetadata?
 *
 * @author Vivek Pandey
 */
public interface ContentType extends com.oracle.webservices.internal.api.message.ContentType {
}
