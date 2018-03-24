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

package com.sun.tools.internal.ws.processor.model;

import com.sun.tools.internal.ws.wsdl.framework.Entity;
import com.sun.tools.internal.ws.wscompile.ErrorReceiver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.xml.sax.Locator;

/**
 *
 * @author WS Development Team
 */
public abstract class ModelObject {
    public abstract void accept(ModelVisitor visitor) throws Exception;

    private final Entity entity;
    protected ErrorReceiver errorReceiver;

    protected ModelObject(Entity entity) {
        this.entity = entity;
    }

    public void setErrorReceiver(ErrorReceiver errorReceiver) {
        this.errorReceiver = errorReceiver;
    }

    public Entity getEntity() {
        return entity;
    }

    public Object getProperty(String key) {
        if (_properties == null) {
            return null;
        }
        return _properties.get(key);
    }

    public void setProperty(String key, Object value) {
        if (value == null) {
            removeProperty(key);
            return;
        }

        if (_properties == null) {
            _properties = new HashMap();
        }
        _properties.put(key, value);
    }

    public void removeProperty(String key) {
        if (_properties != null) {
            _properties.remove(key);
        }
    }

    public Iterator getProperties() {
        if (_properties == null) {
            return Collections.emptyList().iterator();
        } else {
            return _properties.keySet().iterator();
        }
    }

    public Locator getLocator(){
        return entity.getLocator();
    }

    public Map getPropertiesMap() {
        return _properties;
    }

    public void setPropertiesMap(Map m) {
        _properties = m;
    }

    public String getJavaDoc() {
        return javaDoc;
    }

    public void setJavaDoc(String javaDoc) {
        this.javaDoc = javaDoc;
    }

    private String javaDoc;
    private Map _properties;
}
