/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.pubapi;

import java.io.Serializable;

import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.util.SimpleTypeVisitor14;

import com.sun.tools.javac.code.Type.ClassType;
import com.sun.tools.javac.util.DefinedBy;
import com.sun.tools.javac.util.DefinedBy.Api;
import com.sun.tools.javac.util.StringUtils;

public abstract class TypeDesc implements Serializable {

    private static final long serialVersionUID = -8201634143915519172L;

    TypeKind typeKind;

    public TypeDesc(TypeKind typeKind) {
        this.typeKind = typeKind;
    }

    public static TypeDesc decodeString(String s) {
        s = s.trim();
        if (s.endsWith("[]")) {
            String componentPart = s.substring(0, s.length()-2);
            return new ArrayTypeDesc(decodeString(componentPart));
        }

        if (s.startsWith("#"))
            return new TypeVarTypeDesc(s.substring(1));

        if (s.matches("boolean|byte|char|double|float|int|long|short|void")) {
            TypeKind tk = TypeKind.valueOf(StringUtils.toUpperCase(s));
            return new PrimitiveTypeDesc(tk);
        }

        return new ReferenceTypeDesc(s);
    }

    public static String encodeAsString(TypeDesc td) {
        if (td.typeKind.isPrimitive() || td.typeKind == TypeKind.VOID)
            return StringUtils.toLowerCase(td.typeKind.toString());

        if (td.typeKind == TypeKind.ARRAY)
            return encodeAsString(((ArrayTypeDesc) td).compTypeDesc) + "[]";

        if (td.typeKind == TypeKind.TYPEVAR)
            return "#" + ((TypeVarTypeDesc) td).identifier;

        if (td.typeKind == TypeKind.DECLARED)
            return ((ReferenceTypeDesc) td).javaType.toString();

        throw new AssertionError("Unhandled type: " + td.typeKind);
    }

    public static TypeDesc fromType(TypeMirror type) {
        TypeVisitor<TypeDesc, Void> v = new SimpleTypeVisitor14<TypeDesc, Void>() {
            @Override @DefinedBy(Api.LANGUAGE_MODEL)
            public TypeDesc visitArray(ArrayType t, Void p) {
                return new ArrayTypeDesc(t.getComponentType().accept(this, p));
            }

            @Override @DefinedBy(Api.LANGUAGE_MODEL)
            public TypeDesc visitDeclared(DeclaredType t, Void p) {
                return new ReferenceTypeDesc(((ClassType) t).tsym.flatName().toString());
            }

            @Override @DefinedBy(Api.LANGUAGE_MODEL)
            public TypeDesc visitNoType(NoType t, Void p) {
                return new PrimitiveTypeDesc(TypeKind.VOID);
            }

            @Override @DefinedBy(Api.LANGUAGE_MODEL)
            public TypeDesc visitTypeVariable(TypeVariable t, Void p) {
                return new TypeVarTypeDesc(t.toString());
            }

            @Override @DefinedBy(Api.LANGUAGE_MODEL)
            public TypeDesc visitPrimitive(PrimitiveType t, Void p) {
                return new PrimitiveTypeDesc(t.getKind());
            }

            @Override @DefinedBy(Api.LANGUAGE_MODEL)
            public TypeDesc visitError(ErrorType t, Void p) {
                return new ReferenceTypeDesc("<error type>");
            }
        };

        TypeDesc td = v.visit(type);
        if (td == null)
            throw new AssertionError("Unhandled type mirror: " + type + " (" + type.getClass() + ")");
        return td;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        return typeKind.equals(((TypeDesc) obj).typeKind);
    }

    @Override
    public int hashCode() {
        return typeKind.hashCode();
    }
}
