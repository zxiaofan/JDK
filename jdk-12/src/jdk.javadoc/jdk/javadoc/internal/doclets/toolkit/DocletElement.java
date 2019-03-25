/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.FileObject;
import java.lang.annotation.Annotation;
import java.util.Set;

public interface DocletElement extends Element {

    public default TypeMirror asType() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    default ElementKind getKind() {
        return ElementKind.OTHER;
    }

    default Set<Modifier> getModifiers() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    default Name getSimpleName() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    default Element getEnclosingElement() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    default java.util.List<? extends Element> getEnclosedElements() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    default java.util.List<? extends AnnotationMirror> getAnnotationMirrors() {
        throw new UnsupportedOperationException("Unsupported method");
    }

    default <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    default <R, P> R accept(ElementVisitor<R, P> v, P p) {
        return v.visitUnknown(this, p);
    }

    default <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationType) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    /**
     * Returns the anchoring package element, in the case of a
     * module element, this is the module's unnamed package.
     * @return the anchor element.
     */
    PackageElement getPackageElement();

    /**
     * Returns the file object associated with this special
     * element such as overview.html, doc-file/foo.html.
     * @return the file object
     */
    FileObject getFileObject();

    /**
     * Returns the subkind of this element.
     * @return a subkind
     */
    Kind getSubKind();

    /**
     * Sub kind enums that this element supports.
     */
    public static enum Kind {
        OVERVIEW, DOCFILE;
    }
}
