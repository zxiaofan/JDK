/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamReader;
import com.sun.org.apache.xerces.internal.xni.parser.XMLInputSource;

/**
 *
 * @author  Neeraj
 *
 * This class wraps XMLInputSource and is also capable of telling whether application
 * returned XMLStreamReader or not when XMLResolver.resolveEntity
 * was called.
 */
public class StaxXMLInputSource {

    XMLStreamReader fStreamReader ;
    XMLEventReader fEventReader ;
    XMLInputSource fInputSource ;

    //indicates if the source is created by a resolver
    boolean fIsCreatedByResolver = false;

    /** Creates a new instance of StaxXMLInputSource */
    public StaxXMLInputSource(XMLStreamReader streamReader, boolean byResolver) {
        fStreamReader = streamReader ;
    }

    /** Creates a new instance of StaxXMLInputSource */
    public StaxXMLInputSource(XMLEventReader eventReader, boolean byResolver) {
        fEventReader = eventReader ;
    }

    public StaxXMLInputSource(XMLInputSource inputSource, boolean byResolver){
        fInputSource = inputSource ;
        fIsCreatedByResolver = byResolver;
    }

    public XMLStreamReader getXMLStreamReader(){
        return fStreamReader ;
    }

    public XMLEventReader getXMLEventReader(){
        return fEventReader ;
    }

    public XMLInputSource getXMLInputSource(){
        return fInputSource ;
    }

    public boolean hasXMLStreamOrXMLEventReader(){
        return (fStreamReader == null) && (fEventReader == null) ? false : true ;
    }

    public boolean isCreatedByResolver() {
        return fIsCreatedByResolver;
    }
}
