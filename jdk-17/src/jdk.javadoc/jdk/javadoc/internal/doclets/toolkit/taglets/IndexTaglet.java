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

package jdk.javadoc.internal.doclets.toolkit.taglets;

import java.util.EnumSet;
import javax.lang.model.element.Element;

import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.IndexTree;
import jdk.javadoc.doclet.Taglet.Location;
import jdk.javadoc.internal.doclets.toolkit.Content;

/**
 * An inline Taglet used to index word or a phrase.
 * The enclosed text is interpreted as not containing HTML markup or
 * nested javadoc tags.
 */

public class IndexTaglet extends BaseTaglet {

    IndexTaglet() {
        super(DocTree.Kind.INDEX, true, EnumSet.allOf(Location.class));
    }

    @Override
    public Content getInlineTagOutput(Element element, DocTree tag, TagletWriter writer) {
        return writer.indexTagOutput(element, (IndexTree) tag);
    }
}
