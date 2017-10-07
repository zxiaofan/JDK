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

package com.sun.tools.internal.ws.processor.model.jaxb;

import com.sun.tools.internal.ws.processor.model.java.JavaStructureMember;

import javax.xml.namespace.QName;

/**
 * @author Kathy Walsh, Vivek Pandey
 *
 *
 */

public class JAXBElementMember {
    public JAXBElementMember() {
    }
    public JAXBElementMember(QName name, JAXBType type) {
        this(name, type, null);
    }
    public JAXBElementMember(QName name, JAXBType type,
            JavaStructureMember javaStructureMember) {
        _name = name;
        _type = type;
        _javaStructureMember = javaStructureMember;
    }
    public QName getName() {
        return _name;
    }
    public void setName(QName n) {
        _name = n;
    }
    public JAXBType getType() {
        return _type;
    }
    public void setType(JAXBType t) {
        _type = t;
    }
    public boolean isRepeated() {
        return _repeated;
    }
    public void setRepeated(boolean b) {
        _repeated = b;
    }
    public JavaStructureMember getJavaStructureMember() {
        return _javaStructureMember;
    }
    public void setJavaStructureMember(JavaStructureMember javaStructureMember) {
        _javaStructureMember = javaStructureMember;
    }
    public boolean isInherited() {
        return isInherited;
    }
    public void setInherited(boolean b) {
        isInherited = b;
    }
    public JAXBProperty getProperty() {
        if(_prop == null && _type != null) {
            for (JAXBProperty prop: _type.getWrapperChildren()){
                if(prop.getElementName().equals(_name))
                    setProperty(prop);
            }
        }
        return _prop;
    }
    public void setProperty(JAXBProperty prop) {
        _prop = prop;
    }

    private QName _name;
    private JAXBType _type;
    private JavaStructureMember _javaStructureMember;
    private boolean _repeated;
    private boolean isInherited = false;
    private JAXBProperty _prop;
    private static final String JAXB_UNIQUE_PARRAM = "__jaxbUniqueParam_";
}
