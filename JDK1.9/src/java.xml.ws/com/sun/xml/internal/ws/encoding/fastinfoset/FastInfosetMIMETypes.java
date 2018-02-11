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

package com.sun.xml.internal.ws.encoding.fastinfoset;

/**
 * MIME types for Infosets encoded as fast infoset documents.
 *
 * @author Paul.Sandoz@Sun.Com
 */
public final class FastInfosetMIMETypes {
    /**
     * MIME type for a generic Infoset encoded as a fast infoset document.
     */
    static public final String INFOSET = "application/fastinfoset";
    /**
     * MIME type for a SOAP 1.1 Infoset encoded as a fast infoset document.
     */
    static public final String SOAP_11 = "application/fastinfoset";
    /**
     * MIME type for a SOAP 1.2 Infoset encoded as a fast infoset document.
     */
    static public final String SOAP_12 = "application/soap+fastinfoset";

    /**
     * MIME type for a generic Infoset encoded as a stateful fast infoset document.
     */
    static public final String STATEFUL_INFOSET = "application/vnd.sun.stateful.fastinfoset";
    /**
     * MIME type for a SOAP 1.1 Infoset encoded as a stateful fast infoset document.
     */
    static public final String STATEFUL_SOAP_11 = "application/vnd.sun.stateful.fastinfoset";
    /**
     * MIME type for a SOAP 1.2 Infoset encoded as a stateful fast infoset document.
     */
    static public final String STATEFUL_SOAP_12 = "application/vnd.sun.stateful.soap+fastinfoset";
}
