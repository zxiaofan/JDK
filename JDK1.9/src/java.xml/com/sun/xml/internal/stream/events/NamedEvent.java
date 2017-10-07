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

package com.sun.xml.internal.stream.events ;

import javax.xml.namespace.QName;
/**
 *
 *@author Neeraj Bajaj, Sun Microsystems
 *
 */
public class NamedEvent extends DummyEvent {

    private QName name;

    public NamedEvent() {
    }


    public NamedEvent(QName qname) {
        this.name = qname;
    }


    public NamedEvent(String prefix, String uri, String localpart) {
        this.name = new QName(uri, localpart, prefix);
    }

    public String getPrefix() {
        return this.name.getPrefix();
    }


    public QName getName() {
        return name;
    }

    public void setName(QName qname) {
        this.name = qname;
    }

    public String nameAsString() {
        if("".equals(name.getNamespaceURI()))
            return name.getLocalPart();
        if(name.getPrefix() != null)
            return "['" + name.getNamespaceURI() + "']:" + getPrefix() + ":" + name.getLocalPart();
        else
            return "['" + name.getNamespaceURI() + "']:" + name.getLocalPart();
    }

    public String getNamespace(){
        return name.getNamespaceURI();
    }

    protected void writeAsEncodedUnicodeEx(java.io.Writer writer)
    throws java.io.IOException
    {
        writer.write(nameAsString());
    }

}
