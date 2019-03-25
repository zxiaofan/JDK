/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
import javax.lang.model.element.PackageElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.FileObject;

import jdk.javadoc.doclet.DocletEnvironment;

/**
 * This is a pseudo element wrapper for doc-files html contents, essentially to
 * associate the doc-file's html documentation's DocCommentTree to an element.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class DocFileElement implements DocletElement {

    private final Element element;
    private final FileObject fo;

    public DocFileElement(Element element, FileObject fo) {
        this.element = element;
        this.fo = fo;
    }

    @Override
    public PackageElement getPackageElement() {
        switch(element.getKind()) {
            case MODULE:
                // uncomment to support doc-files in modules
                // return configuration.workArounds.getUnnamedPackage();
                throw new UnsupportedOperationException("not implemented");
            case PACKAGE:
                return (PackageElement)element;
            default:
                throw new AssertionError("unknown kind: " + element.getKind());
        }
    }

    @Override
    public FileObject getFileObject() {
        return fo;
    }

    @Override
    public Kind getSubKind() {
        return Kind.DOCFILE;
    }
}

