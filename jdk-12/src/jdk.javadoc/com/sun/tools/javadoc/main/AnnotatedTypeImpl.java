/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javadoc.main;

import com.sun.javadoc.*;
import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.Attribute.TypeCompound;
import com.sun.tools.javac.util.List;

/**
 * Implementation of <code>AnnotatedType</code>, which
 * represents an annotated type.
 *
 * @author Mahmood Ali
 * @since 1.8
 */
@Deprecated(since="9", forRemoval=true)
@SuppressWarnings("removal")
public class AnnotatedTypeImpl
        extends AbstractTypeImpl implements AnnotatedType {

    AnnotatedTypeImpl(DocEnv env, com.sun.tools.javac.code.Type type) {
        super(env, type);
    }

    /**
     * Get the annotations of this program element.
     * Return an empty array if there are none.
     */
    @Override
    public AnnotationDesc[] annotations() {
        List<? extends TypeCompound> tas = type.getAnnotationMirrors();
        if (tas == null ||
                tas.isEmpty()) {
            return new AnnotationDesc[0];
        }
        AnnotationDesc res[] = new AnnotationDesc[tas.length()];
        int i = 0;
        for (Attribute.Compound a : tas) {
            res[i++] = new AnnotationDescImpl(env, a);
        }
        return res;
    }

    @Override
    public com.sun.javadoc.Type underlyingType() {
        return TypeMaker.getType(env, type, true, false);
    }

    @Override
    public AnnotatedType asAnnotatedType() {
        return this;
    }

    @Override
    public String toString() {
        return typeName();
    }

    @Override
    public String typeName() {
        return this.underlyingType().typeName();
    }

    @Override
    public String qualifiedTypeName() {
        return this.underlyingType().qualifiedTypeName();
    }

    @Override
    public String simpleTypeName() {
        return this.underlyingType().simpleTypeName();
    }

    @Override
    public String dimension() {
        return this.underlyingType().dimension();
    }

    @Override
    public boolean isPrimitive() {
        return this.underlyingType().isPrimitive();
    }

    @Override
    public ClassDoc asClassDoc() {
        return this.underlyingType().asClassDoc();
    }

    @Override
    public TypeVariable asTypeVariable() {
        return this.underlyingType().asTypeVariable();
    }

    @Override
    public WildcardType asWildcardType() {
        return this.underlyingType().asWildcardType();
    }

    @Override
    public ParameterizedType asParameterizedType() {
        return this.underlyingType().asParameterizedType();
    }
}
