/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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
import jdk.javadoc.internal.doclets.toolkit.Content;

import static com.sun.source.doctree.DocTree.Kind.INDEX;

/**
 * An inline Taglet used to index word or a phrase.
 * The enclosed text is interpreted as not containing HTML markup or
 * nested javadoc tags.
 *
 * @author Bhavesh Patel
 */

public class IndexTaglet extends BaseTaglet {

    IndexTaglet() {
        super(INDEX.tagName, true, EnumSet.allOf(Site.class));
    }

    @Override
    public Content getTagletOutput(Element element, DocTree tag, TagletWriter writer) {
        return writer.indexTagOutput(element, tag);
    }
}
