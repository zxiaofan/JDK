/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit;

import java.lang.annotation.Annotation;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Name;
import javax.lang.model.type.TypeMirror;

import jdk.javadoc.doclet.DocletEnvironment;

/**
 * This is a pseudo element wrapper for the overview element, essentially to
 * associate overview documentation's DocCommentTree to this element.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class OverviewElement implements Element {

    public final DocletEnvironment docEnv;

    OverviewElement(DocletEnvironment docEnv) {
        this.docEnv = docEnv;
    }

    @Override
    public TypeMirror asType() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    @Override
    public ElementKind getKind() {
        return ElementKind.OTHER;
    }

    @Override
    public Set<javax.lang.model.element.Modifier> getModifiers() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    @Override
    public Name getSimpleName() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    @Override
    public Element getEnclosingElement() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    @Override
    public java.util.List<? extends Element> getEnclosedElements() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    @Override
    public java.util.List<? extends AnnotationMirror> getAnnotationMirrors() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    @Override
    public <R, P> R accept(ElementVisitor<R, P> v, P p) {
        return v.visitUnknown(this, p);
    }

    @Override
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationType) {
        throw new UnsupportedOperationException("Unsupported method");
    }
}

