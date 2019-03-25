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

package com.sun.xml.internal.stream.events;

import java.util.List;
import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.NotationDeclaration;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author Neeraj Bajaj, Sun Microsystesm.
 *
 */
public class DTDEvent extends DummyEvent implements DTD {

    private String fDoctypeDeclaration;
    private List<NotationDeclaration> fNotations;
    private List<EntityDeclaration> fEntities;

    /**
     * Creates a new instance of DTDEvent
     */
    public DTDEvent() {
        init();
    }

    public DTDEvent(String doctypeDeclaration) {
        init();
        fDoctypeDeclaration = doctypeDeclaration;
    }

    public void setDocumentTypeDeclaration(String doctypeDeclaration) {
        fDoctypeDeclaration = doctypeDeclaration;
    }

    @Override
    public String getDocumentTypeDeclaration() {
        return fDoctypeDeclaration;
    }

    //xxx: we can change the signature if the implementation doesn't store the entities in List Datatype.
    //and then convert that DT to list format here. That way callee dont need to bother about conversion
    public void setEntities(List<EntityDeclaration> entites) {
        fEntities = entites;
    }

    @Override
    public List<EntityDeclaration> getEntities() {
        return fEntities;
    }

    //xxx: we can change the signature if the implementation doesn't store the entities in List Datatype.
    //and then convert that DT to list format here. That way callee dont need to bother about conversion
    public void setNotations(List<NotationDeclaration> notations) {
        fNotations = notations;
    }

    @Override
    public List<NotationDeclaration> getNotations() {
        return fNotations;
    }

    /**
     * Returns an implementation defined representation of the DTD. This method
     * may return null if no representation is available.
     *
     */
    @Override
    public Object getProcessedDTD() {
        return null;
    }

    protected final void init() {
        setEventType(XMLEvent.DTD);
    }

    @Override
    public String toString() {
        return fDoctypeDeclaration;
    }

    @Override
    protected void writeAsEncodedUnicodeEx(java.io.Writer writer)
            throws java.io.IOException {
        writer.write(fDoctypeDeclaration);
    }
}
