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

package com.sun.xml.internal.ws.encoding.xml;

import com.oracle.webservices.internal.api.message.BasePropertySet;
import com.oracle.webservices.internal.api.message.PropertySet;

public class XMLPropertyBag extends BasePropertySet {

    private String contentType;
    protected PropertyMap getPropertyMap() {
        return model;
    }

    @Property(XMLConstants.OUTPUT_XML_CHARACTER_ENCODING)
    public String getXMLContentType(){
        return contentType;
    }

    public void setXMLContentType(String content){
        contentType = content;
    }

    private static final PropertyMap model;

    static {
        model = parse(XMLPropertyBag.class);
    }

}
