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

import com.sun.tools.internal.ws.processor.model.java.JavaType;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author WS Development Team
 */
public abstract class AbstractType {

    protected AbstractType() {}

    protected AbstractType(QName name) {
        this(name, null, null);
    }

    protected AbstractType(QName name, String version) {
        this(name, null, version);
    }

    protected AbstractType(QName name, JavaType javaType) {
        this(name, javaType, null);
    }

    protected AbstractType(QName name, JavaType javaType, String version) {
        this.name = name;
        this.javaType = javaType;
        this.version = version;
    }

    public QName getName() {
        return name;
    }

    public void setName(QName name) {
        this.name = name;
    }

    public JavaType getJavaType() {
        return javaType;
    }

    public void setJavaType(JavaType javaType) {
        this.javaType = javaType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isNillable() {
        return false;
    }

    public boolean isSOAPType() {
        return false;
    }

    public boolean isLiteralType() {
        return false;
    }

    public Object getProperty(String key) {
        if (properties == null) {
            return null;
        }
        return properties.get(key);
    }

    public void setProperty(String key, Object value) {
        if (value == null) {
            removeProperty(key);
            return;
        }

        if (properties == null) {
            properties = new HashMap();
        }
        properties.put(key, value);
    }

    public void removeProperty(String key) {
        if (properties != null) {
            properties.remove(key);
        }
    }

    public Iterator getProperties() {
        if (properties == null) {
            return Collections.emptyList().iterator();
        } else {
            return properties.keySet().iterator();
        }
    }

    /* serialization */
    public Map getPropertiesMap() {
        return properties;
    }

    /* serialization */
    public void setPropertiesMap(Map m) {
        properties = m;
    }

    private QName name;
    private JavaType javaType;
    private String version = null;
    private Map properties;
}
