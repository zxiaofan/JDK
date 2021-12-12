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

import javax.xml.namespace.QName;
import javax.xml.stream.events.Attribute;
import java.io.Writer;
import javax.xml.stream.events.XMLEvent;


//xxx: AttributeEvent is not really a first order event. Should we be renaming the class to AttributeImpl for consistent
//naming convention.

/**
 * Implementation of Attribute Event.
 *
 *@author Neeraj Bajaj, Sun Microsystems
 *@author K.Venugopal, Sun Microsystems
 *
 */

public class AttributeImpl extends DummyEvent implements Attribute

{
    //attribute value
    private String fValue;
    private String fNonNormalizedvalue;

    //name of the attribute
    private QName fQName;
    //attribute type
    private String fAttributeType = "CDATA";


    //A flag indicating whether this attribute was actually specified in the start-tag
    //of its element or was defaulted from the schema.
    private boolean fIsSpecified;

    public AttributeImpl(){
        init();
    }
    public AttributeImpl(String name, String value) {
        init();
        fQName = new QName(name);
        fValue = value;
    }

    public AttributeImpl(String prefix, String name, String value) {
        this(prefix, null,name, value, null,null,false );
    }

    public AttributeImpl(String prefix, String uri, String localPart, String value, String type) {
        this(prefix, uri, localPart, value, null, type, false);
    }

    public AttributeImpl(String prefix, String uri, String localPart, String value, String nonNormalizedvalue, String type, boolean isSpecified) {
        this(new QName(uri, localPart, prefix), value, nonNormalizedvalue, type, isSpecified);
    }


    public AttributeImpl(QName qname, String value, String nonNormalizedvalue, String type, boolean isSpecified) {
        init();
        fQName = qname ;
        fValue = value ;
        if(type != null && !type.isEmpty())
            fAttributeType = type;

        fNonNormalizedvalue = nonNormalizedvalue;
        fIsSpecified = isSpecified ;

    }

    public String toString() {
        if( fQName.getPrefix() != null && fQName.getPrefix().length() > 0 )
            return fQName.getPrefix() + ":" + fQName.getLocalPart() + "='" + fValue + "'";
        else
            return fQName.getLocalPart() + "='" + fValue + "'";
    }

    public void setName(QName name){
        fQName = name ;
    }

    public QName getName() {
        return fQName;
    }

    public void setValue(String value){
        fValue = value;
    }

    public String getValue() {
        return fValue;
    }

    public void setNonNormalizedValue(String nonNormalizedvalue){
        fNonNormalizedvalue = nonNormalizedvalue;
    }

    public String getNonNormalizedValue(){
        return fNonNormalizedvalue ;
    }

    public void setAttributeType(String attributeType){
        fAttributeType = attributeType ;
    }

    /** Gets the type of this attribute, default is "CDATA   */
    // We dont need to take care of default value.. implementation takes care of it.
    public String getDTDType() {
        return fAttributeType;
    }

    /** is this attribute is specified in the instance document */

    public void setSpecified(boolean isSpecified){
        fIsSpecified = isSpecified ;
    }

    public boolean isSpecified() {
        return fIsSpecified ;
    }

    protected void writeAsEncodedUnicodeEx(java.io.Writer writer)
    throws java.io.IOException
    {
        writer.write(toString());
     }


    protected void init(){
        setEventType(XMLEvent.ATTRIBUTE);
    }




}//AttributeImpl
