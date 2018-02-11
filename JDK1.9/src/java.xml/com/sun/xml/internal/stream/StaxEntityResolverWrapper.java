/*
 * Copyright (c) 2005, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.io.InputStream;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLResolver;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import com.sun.org.apache.xerces.internal.xni.XMLResourceIdentifier;
import com.sun.org.apache.xerces.internal.xni.XNIException;
import com.sun.org.apache.xerces.internal.xni.parser.XMLInputSource;
import javax.xml.catalog.CatalogException;

/**
 *
 * @author  Neeraj Bajaj
 */
public class StaxEntityResolverWrapper {

    XMLResolver fStaxResolver ;

    /** Creates a new instance of StaxEntityResolverWrapper */
    public StaxEntityResolverWrapper(XMLResolver resolver) {
        fStaxResolver = resolver ;
    }

    public void setStaxEntityResolver(XMLResolver resolver ){
        fStaxResolver = resolver ;
    }

    public XMLResolver getStaxEntityResolver(){
        return fStaxResolver ;
    }

    public StaxXMLInputSource resolveEntity(XMLResourceIdentifier resourceIdentifier)
    throws XNIException, java.io.IOException {
        Object object = null ;
        try {
            object = fStaxResolver.resolveEntity(resourceIdentifier.getPublicId(), resourceIdentifier.getLiteralSystemId(),
            resourceIdentifier.getBaseSystemId(), null);
            return getStaxInputSource(object) ;
        } catch(XMLStreamException | CatalogException streamException){
            throw new XNIException(streamException) ;
        }
    }

    StaxXMLInputSource getStaxInputSource(Object object){
        if(object == null) return null ;

        if(object  instanceof java.io.InputStream){
            return new StaxXMLInputSource(new XMLInputSource(null, null, null, (InputStream)object, null), true);
        }
        else if(object instanceof XMLStreamReader){
            return new StaxXMLInputSource((XMLStreamReader)object, true) ;
        }else if(object instanceof XMLEventReader){
            return new StaxXMLInputSource((XMLEventReader)object, true) ;
        }

        return null ;
    }
}//class StaxEntityResolverWrapper
