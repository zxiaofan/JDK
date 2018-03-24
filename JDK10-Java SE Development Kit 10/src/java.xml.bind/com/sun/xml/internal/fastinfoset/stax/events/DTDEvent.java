/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.stax.events;

import java.util.List;

import javax.xml.stream.events.DTD;
import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.NotationDeclaration;

/**
 * DTDEvent. Notations and Entities are not used
 */
public class DTDEvent extends EventBase implements DTD{

    private String _dtd;
    private List _notations;
    private List _entities;

    /** Creates a new instance of DTDEvent */
    public DTDEvent() {
        setEventType(DTD);
    }

    public DTDEvent(String dtd){
        setEventType(DTD);
        _dtd = dtd;
    }

   /**
   * Returns the entire Document Type Declaration as a string, including
   * the internal DTD subset.
   * This may be null if there is not an internal subset.
   * If it is not null it must return the entire
   * Document Type Declaration which matches the doctypedecl
   * production in the XML 1.0 specification
   */
   public String getDocumentTypeDeclaration() {
        return _dtd;
    }
   public void setDTD(String dtd){
        _dtd = dtd;
    }

   /**
   * Return a List containing the general entities,
   * both external and internal, declared in the DTD.
   * This list must contain EntityDeclaration events.
   * @see EntityDeclaration
   * @return an unordered list of EntityDeclaration events
   */
    public List getEntities() {
        return _entities;
    }

   /**
   * Return a List containing the notations declared in the DTD.
   * This list must contain NotationDeclaration events.
   * @see NotationDeclaration
   * @return an unordered list of NotationDeclaration events
   */
   public List getNotations() {
        return _notations;
    }

    /**
     *Returns an implementation defined representation of the DTD.
     * This method may return null if no representation is available.
     *
     */
    public Object getProcessedDTD() {
        return null;
    }

    public void setEntities(List entites){
        _entities = entites;
    }

    public void setNotations(List notations){
        _notations = notations;
    }

    public String toString(){
        return _dtd ;
    }
}
