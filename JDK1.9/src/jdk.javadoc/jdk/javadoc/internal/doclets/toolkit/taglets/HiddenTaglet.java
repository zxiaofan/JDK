/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.taglets;

import javax.lang.model.element.Element;

import jdk.javadoc.internal.doclets.toolkit.Content;

import static com.sun.source.doctree.DocTree.Kind.*;

/**
 * A taglet that represents the @hidden tag.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */

public class HiddenTaglet extends BaseTaglet{

    public HiddenTaglet() {
        name = HIDDEN.tagName;
    }

    /**
     * {@inheritDoc}
     */
    public Content getTagletOutput(Element holder, TagletWriter writer) {
        return writer.deprecatedTagOutput(holder);
    }
}

