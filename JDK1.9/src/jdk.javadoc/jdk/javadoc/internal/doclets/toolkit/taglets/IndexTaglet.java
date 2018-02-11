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

package jdk.javadoc.internal.doclets.toolkit.taglets;

import com.sun.source.doctree.DocTree;
import java.util.Map;
import javax.lang.model.element.Element;
import jdk.javadoc.internal.doclets.toolkit.Content;

/**
 * An inline Taglet used to index word or a phrase.
 * The enclosed text is interpreted as not containing HTML markup or
 * nested javadoc tags.
 *
 * @author Bhavesh Patel
 */

public class IndexTaglet extends BaseInlineTaglet {

    private static final String NAME = "index";

    public String getName() {
        return NAME;
    }

    /**
     * {@inheritDoc}
     */
    public Content getTagletOutput(Element element, DocTree tag, TagletWriter writer) {
        return writer.indexTagOutput(element, tag);
    }
}
