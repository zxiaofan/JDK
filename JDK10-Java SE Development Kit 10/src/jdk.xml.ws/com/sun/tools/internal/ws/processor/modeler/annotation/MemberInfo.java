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

package com.sun.tools.internal.ws.processor.modeler.annotation;

import javax.lang.model.type.TypeMirror;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Note: this class has a natural ordering that is inconsistent with equals.
 * @author  WS Development Team
 */
final class MemberInfo implements Comparable<MemberInfo> {
    private final TypeMirror paramType;
    private final String paramName;
    private final List<Annotation> jaxbAnnotations;

    public MemberInfo(TypeMirror paramType, String paramName, List<Annotation> jaxbAnnotations) {
        this.paramType = paramType;
        this.paramName = paramName;
        this.jaxbAnnotations = jaxbAnnotations;
    }

    public List<Annotation> getJaxbAnnotations() {
        return jaxbAnnotations;
    }

    public TypeMirror getParamType() {
        return paramType;
    }

    public String getParamName() {
        return paramName;
    }

    @Override
    public int compareTo(MemberInfo member) {
        return paramName.compareTo(member.paramName);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.paramType != null ? this.paramType.hashCode() : 0);
        hash = 47 * hash + (this.paramName != null ? this.paramName.hashCode() : 0);
        hash = 47 * hash + (this.jaxbAnnotations != null ? this.jaxbAnnotations.hashCode() : 0);
        return hash;
    }

}
