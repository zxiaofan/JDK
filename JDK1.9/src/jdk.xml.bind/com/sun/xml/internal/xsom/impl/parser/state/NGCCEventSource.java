/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.xsom.impl.parser.state;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public interface NGCCEventSource {
    /**
     * Replaces an old handler with a new handler, and returns
     * ID of the EventReceiver thread.
     */
    int replace( NGCCEventReceiver _old, NGCCEventReceiver _new );

    /** Sends an enter element event to the specified EventReceiver thread. */
    void sendEnterElement( int receiverThreadId, String uri, String local, String qname, Attributes atts ) throws SAXException;

    void sendLeaveElement( int receiverThreadId, String uri, String local, String qname ) throws SAXException;
    void sendEnterAttribute( int receiverThreadId, String uri, String local, String qname ) throws SAXException;
    void sendLeaveAttribute( int receiverThreadId, String uri, String local, String qname ) throws SAXException;
    void sendText( int receiverThreadId, String value ) throws SAXException;
}
