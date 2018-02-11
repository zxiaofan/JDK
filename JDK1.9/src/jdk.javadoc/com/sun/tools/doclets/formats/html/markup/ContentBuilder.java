/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.formats.html.markup;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.sun.tools.doclets.internal.toolkit.Content;

/**
 * A sequence of Content nodes.
 */
@Deprecated
public class ContentBuilder extends Content {
    protected List<Content> contents = Collections.emptyList();

    @Override
    public void addContent(Content content) {
        nullCheck(content);
        ensureMutableContents();
        if (content instanceof ContentBuilder) {
            contents.addAll(((ContentBuilder) content).contents);
        } else
            contents.add(content);
    }

    @Override
    public void addContent(String text) {
        if (text.isEmpty())
            return;
        ensureMutableContents();
        Content c = contents.isEmpty() ? null : contents.get(contents.size() - 1);
        StringContent sc;
        if (c != null && c instanceof StringContent) {
            sc = (StringContent) c;
        } else {
            contents.add(sc = new StringContent());
        }
        sc.addContent(text);
    }

    @Override
    public boolean write(Writer writer, boolean atNewline) throws IOException {
        for (Content content: contents) {
            atNewline = content.write(writer, atNewline);
        }
        return atNewline;
    }

    @Override
    public boolean isEmpty() {
        for (Content content: contents) {
            if (!content.isEmpty())
                return false;
        }
        return true;
    }

    @Override
    public int charCount() {
        int n = 0;
        for (Content c : contents)
            n += c.charCount();
        return n;
    }

    private void ensureMutableContents() {
        if (contents.isEmpty())
            contents = new ArrayList<>();
    }
}
