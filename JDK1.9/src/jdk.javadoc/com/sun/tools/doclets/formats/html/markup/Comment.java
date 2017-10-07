/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.tools.doclets.internal.toolkit.Content;
import com.sun.tools.doclets.internal.toolkit.util.*;

/**
 * Class for generating a comment for HTML pages of javadoc output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
@Deprecated
public class Comment extends Content {

    private String commentText;

    /**
     * Constructor to construct a Comment object.
     *
     * @param comment comment text for the comment
     */
    public Comment(String comment) {
        commentText = nullCheck(comment);
    }

    /**
     * This method is not supported by the class.
     *
     * @param content content that needs to be added
     * @throws DocletAbortException this method will always throw a
     *                              DocletAbortException because it
     *                              is not supported.
     */
    public void addContent(Content content) {
        throw new DocletAbortException("not supported");
    }

    /**
     * This method is not supported by the class.
     *
     * @param stringContent string content that needs to be added
     * @throws DocletAbortException this method will always throw a
     *                              DocletAbortException because it
     *                              is not supported.
     */
    public void addContent(String stringContent) {
        throw new DocletAbortException("not supported");
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return commentText.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
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
