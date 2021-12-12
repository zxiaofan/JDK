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

import javax.xml.stream.events.NotationDeclaration;
import javax.xml.stream.events.XMLEvent;
import com.sun.xml.internal.stream.dtd.nonvalidating.XMLNotationDecl;

/**
 * Implementation of NotationDeclaration event.
 *
 * @author k venugopal
 */
public class NotationDeclarationImpl extends DummyEvent implements NotationDeclaration {

    String fName = null;
    String fPublicId = null;
    String fSystemId = null;

    /** Creates a new instance of NotationDeclarationImpl */
    public NotationDeclarationImpl() {
        setEventType(XMLEvent.NOTATION_DECLARATION);
    }

    public NotationDeclarationImpl(String name,String publicId,String systemId){
        this.fName = name;
        this.fPublicId = publicId;
        this.fSystemId = systemId;
        setEventType(XMLEvent.NOTATION_DECLARATION);
    }

    public NotationDeclarationImpl(XMLNotationDecl notation){
        this.fName = notation.name;
        this.fPublicId = notation.publicId;
        this.fSystemId = notation.systemId;
        setEventType(XMLEvent.NOTATION_DECLARATION);
    }

    public String getName() {
        return fName;
    }

    public String getPublicId() {
        return fPublicId;
    }

    public String getSystemId() {
        return fSystemId;
    }

    void setPublicId(String publicId){
        this.fPublicId = publicId;
    }

    void setSystemId(String systemId){
        this.fSystemId = systemId;
    }

    void setName(String name){
        this.fName = name;
    }

    protected void writeAsEncodedUnicodeEx(java.io.Writer writer)
    throws java.io.IOException
    {
        writer.write("<!NOTATION ");
        writer.write(getName());
        if (fPublicId != null) {
            writer.write(" PUBLIC \"");
            writer.write(fPublicId);
            writer.write("\"");
        } else if (fSystemId != null) {
            writer.write(" SYSTEM");
            writer.write(" \"");
            writer.write(fSystemId);
            writer.write("\"");
        }
        writer.write('>');
    }
}
