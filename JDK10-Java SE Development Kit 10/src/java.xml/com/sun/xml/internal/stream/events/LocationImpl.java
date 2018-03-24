/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.events;

import javax.xml.stream.Location;

/**
 *Implementation of Location interface to be used by
 *event readers.
 *@author Neeraj bajaj,k venugopal
 */
public class LocationImpl implements Location{
    String systemId;
    String publicId;
    int colNo;
    int lineNo;
    int charOffset;
    LocationImpl(Location loc){
        systemId = loc.getSystemId();
        publicId = loc.getPublicId();
        lineNo = loc.getLineNumber();
        colNo = loc.getColumnNumber();
        charOffset = loc.getCharacterOffset();
    }

    public int getCharacterOffset(){
        return charOffset;
    }

    public int getColumnNumber() {
        return colNo;
    }

    public int getLineNumber(){
        return lineNo;
    }

    public String getPublicId(){
        return publicId;
    }

    public String getSystemId(){
        return systemId;
    }

    public String toString(){
        StringBuffer sbuffer = new StringBuffer() ;
        sbuffer.append("Line number = " + getLineNumber());
        sbuffer.append("\n") ;
        sbuffer.append("Column number = " + getColumnNumber());
        sbuffer.append("\n") ;
        sbuffer.append("System Id = " + getSystemId());
        sbuffer.append("\n") ;
        sbuffer.append("Public Id = " + getPublicId());
        sbuffer.append("\n") ;
        sbuffer.append("CharacterOffset = " + getCharacterOffset());
        sbuffer.append("\n") ;
        return sbuffer.toString();
    }

}
