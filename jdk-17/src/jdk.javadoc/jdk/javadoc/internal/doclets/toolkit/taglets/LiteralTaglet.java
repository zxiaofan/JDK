/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.EnumSet;
import javax.lang.model.element.Element;

import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.LiteralTree;
import jdk.javadoc.doclet.Taglet.Location;
import jdk.javadoc.internal.doclets.toolkit.Content;
/**
 * An inline Taglet used to denote literal text.
 * For example, the text:
 * <blockquote>  {@code {@literal a<B>c}}  </blockquote>
 * displays as:
 * <blockquote>  {@literal a<B>c}  </blockquote>
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */

public class LiteralTaglet extends BaseTaglet {

    LiteralTaglet() {
        super(DocTree.Kind.LITERAL, true, EnumSet.allOf(Location.class));
    }

    @Override
    public Content getInlineTagOutput(Element e, DocTree tag, TagletWriter writer) {
        return writer.literalTagOutput(e, (LiteralTree) tag);
    }
}
