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

import javax.xml.stream.events.EntityReference;
import java.io.Writer;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.XMLEvent;

/** Implements EntityReference event.
 *
 *@author Neeraj Bajaj, Sun Microsystems,
 */
public class EntityReferenceEvent extends DummyEvent
implements EntityReference {
    private EntityDeclaration fEntityDeclaration ;
    private String fEntityName;

    public EntityReferenceEvent() {
        init();
    }

    public EntityReferenceEvent(String entityName , EntityDeclaration entityDeclaration) {
        init();
        fEntityName = entityName;
        fEntityDeclaration = entityDeclaration ;
    }

    public String getName() {
        return fEntityName;
    }

    public String toString() {
        String text = fEntityDeclaration.getReplacementText();
        if(text == null)
            text = "";
        return "&" + getName() + ";='" + text + "'";
    }

    protected void writeAsEncodedUnicodeEx(java.io.Writer writer)
    throws java.io.IOException
    {
        writer.write('&');
        writer.write(getName());
        writer.write(';');
    }

    public EntityDeclaration getDeclaration(){
        return fEntityDeclaration ;
    }

    protected void init() {
        setEventType(XMLEvent.ENTITY_REFERENCE);
    }


}
