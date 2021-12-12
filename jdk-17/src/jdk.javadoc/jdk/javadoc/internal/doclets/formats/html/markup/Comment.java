/*
 * Copyright (c) 2010, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.formats.html.markup;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocletConstants;

/**
 * Class for generating a comment for HTML pages of javadoc output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class Comment extends Content {

    private String commentText;

    /**
     * Constructor to construct a Comment object.
     *
     * @param comment comment text for the comment
     */
    public Comment(String comment) {
        commentText = Objects.requireNonNull(comment);
    }

    @Override
    public boolean isEmpty() {
        return commentText.isEmpty();
    }

    @Override
    public boolean write(Writer out, boolean atNewline) throws IOException {
        if (!atNewline)
            out.write(DocletConstants.NL);
        out.write("<!-- ");
        out.write(commentText);
        out.write(" -->" + DocletConstants.NL);
        return true;
    }
}
