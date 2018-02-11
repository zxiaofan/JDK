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

package com.sun.tools.internal.ws.processor.model.java;

/**
 *
 * @author WS Development Team
 */
public class JavaStructureMember {

    public JavaStructureMember() {}

    public JavaStructureMember(String name, JavaType type, Object owner) {
        this(name, type, owner, false);
    }
    public JavaStructureMember(String name, JavaType type,
        Object owner, boolean isPublic) {

        this.name = name;
        this.type = type;
        this.owner = owner;
        this.isPublic = isPublic;
        constructorPos = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public JavaType getType() {
        return type;
    }

    public void setType(JavaType t) {
        type = t;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean b) {
        isPublic = b;
    }

    public boolean isInherited() {
        return isInherited;
    }

    public void setInherited(boolean b) {
        isInherited = b;
    }

    public String getReadMethod() {
        return readMethod;
    }

    public void setReadMethod(String readMethod) {
        this.readMethod = readMethod;
    }

    public String getWriteMethod() {
        return writeMethod;
    }

    public void setWriteMethod(String writeMethod) {
        this.writeMethod = writeMethod;
    }

    public String getDeclaringClass() {
        return declaringClass;
    }
    public void setDeclaringClass(String declaringClass) {
        this.declaringClass = declaringClass;
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public int getConstructorPos() {
        return constructorPos;
    }

    public void setConstructorPos(int idx) {
        constructorPos = idx;
    }

    private String name;
    private JavaType type;
    private boolean isPublic = false;
    private boolean isInherited = false;
    private String readMethod;
    private String writeMethod;
    private String declaringClass;
    private Object owner;
    private int constructorPos;
}
