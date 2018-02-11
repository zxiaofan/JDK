/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.taglets;

import java.util.Map;
import com.sun.javadoc.Tag;
import com.sun.tools.doclets.internal.toolkit.Content;

/**
 * An inline Taglet used to index word or a phrase.
 * The enclosed text is interpreted as not containing HTML markup or
 * nested javadoc tags.
 *
 * @author Bhavesh Patel
 */

@Deprecated
public class IndexTaglet extends BaseInlineTaglet {

    private static final String NAME = "index";

    public static void register(Map<String, Taglet> map) {
        map.remove(NAME);
        map.put(NAME, new IndexTaglet());
    }

    public String getName() {
        return NAME;
    }

    /**
     * {@inheritDoc}
     */
    public Content getTagletOutput(Tag tag, TagletWriter writer) {
        return writer.indexTagOutput(tag);
    }
}
