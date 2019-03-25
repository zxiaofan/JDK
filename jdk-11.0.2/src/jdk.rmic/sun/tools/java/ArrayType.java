/*
 * Copyright (c) 1994, 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.java;

/**
 * This class represents an Java array type.
 * It overrides the relevant methods in class Type.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 *
 * @author      Arthur van Hoff
 */
public final
class ArrayType extends Type {
    /**
     * The type of the element.
     */
    Type elemType;

    /**
     * Construct an array type. Use Type.tArray to create
     * a new array type.
     */
    ArrayType(String typeSig, Type elemType) {
        super(TC_ARRAY, typeSig);
        this.elemType = elemType;
    }

    public Type getElementType() {
        return elemType;
    }

    public int getArrayDimension() {
        return elemType.getArrayDimension() + 1;
    }

    public String typeString(String id, boolean abbrev, boolean ret) {
        return getElementType().typeString(id, abbrev, ret) + "[]";
    }
}
