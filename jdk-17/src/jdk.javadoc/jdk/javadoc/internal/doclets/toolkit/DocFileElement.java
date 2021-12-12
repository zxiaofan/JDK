/*
 * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
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

import javax.lang.model.element.Element;
import javax.lang.model.element.ModuleElement;
import javax.lang.model.element.PackageElement;
import javax.tools.FileObject;

import jdk.javadoc.internal.doclets.toolkit.util.Utils;

/**
 * This is a pseudo-element wrapper for doc-files html contents, essentially to
 * associate the doc-files' html documentation's {@code DocCommentTree} to an element.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class DocFileElement implements DocletElement {

    private final PackageElement packageElement;
    private final FileObject fo;

    public DocFileElement(Utils utils, Element element, FileObject fo) {
        this.fo = fo;

        switch(element.getKind()) {
            case MODULE:
                ModuleElement moduleElement = (ModuleElement) element;
                packageElement = utils.elementUtils.getPackageElement(moduleElement, "");
                break;

            case PACKAGE:
                packageElement = (PackageElement) element;
                break;

            default:
                throw new AssertionError("unknown kind: " + element.getKind());
        }
    }

    @Override
    public PackageElement getPackageElement() {
        return packageElement;
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

