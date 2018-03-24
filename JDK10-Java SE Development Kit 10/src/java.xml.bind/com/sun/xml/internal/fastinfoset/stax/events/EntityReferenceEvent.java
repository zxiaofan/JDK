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

package com.sun.xml.internal.fastinfoset.stax.events ;

import javax.xml.stream.events.EntityDeclaration;
import javax.xml.stream.events.EntityReference;


public class EntityReferenceEvent extends EventBase implements EntityReference {
    private EntityDeclaration _entityDeclaration ;
    private String _entityName;

    public EntityReferenceEvent() {
        init();
    }

    public EntityReferenceEvent(String entityName , EntityDeclaration entityDeclaration) {
        init();
        _entityName = entityName;
        _entityDeclaration = entityDeclaration;
    }

  /**
   * The name of the entity
   * @return the entity's name, may not be null
   */
    public String getName() {
        return _entityName;
    }

  /**
   * Return the declaration of this entity.
   */
    public EntityDeclaration getDeclaration(){
        return _entityDeclaration ;
    }

    public void setName(String name){
        _entityName = name;
    }

    public void setDeclaration(EntityDeclaration declaration) {
        _entityDeclaration = declaration ;
    }

    public String toString() {
        String text = _entityDeclaration.getReplacementText();
        if(text == null)
            text = "";
        return "&" + getName() + ";='" + text + "'";
    }

    protected void init() {
        setEventType(ENTITY_REFERENCE);
    }


}
