/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.messaging.saaj.soap;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.transform.Source;

/**
 * Different implementations for SOAP Envelope must all implement this
 * interface.
 *
 * @author Anil Vijendran (akv@eng.sun.com)
 */
public interface Envelope extends SOAPEnvelope {
    /**
     * Get the content as a JAXP Source.
     *
     * @return source
     */
    Source getContent();

    /**
     * Output the content.
     *
     * @param out output stream.
     * @exception IOException in case of an I/O error.
     */
    void output(OutputStream out) throws IOException;

    /**
     * Output the content.
     *
     * @param out output stream
     * @param isFastInfoset true if it is fast infoset.
     * @exception IOException in case of an I/O error.
     */
    void output(OutputStream out, boolean isFastInfoset) throws IOException;

    void setStaxBridge(StaxBridge bridge) throws SOAPException;

    StaxBridge getStaxBridge() throws SOAPException;
}
