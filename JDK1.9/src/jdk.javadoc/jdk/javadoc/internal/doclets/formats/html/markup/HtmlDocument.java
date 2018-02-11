/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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
import java.util.*;

import jdk.javadoc.internal.doclets.toolkit.Content;

/**
 * Class for generating an HTML document for javadoc output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
public class HtmlDocument extends Content {

    private List<Content> docContent = Collections.emptyList();

    /**
     * Constructor to construct an HTML document.
     *
     * @param docType document type for the HTML document
     * @param docComment comment for the document
     * @param htmlTree HTML tree of the document
     */
    public HtmlDocument(Content docType, Content docComment, Content htmlTree) {
        docContent = new ArrayList<>();
        addContent(nullCheck(docType));
        addContent(nullCheck(docComment));
        addContent(nullCheck(htmlTree));
    }

    /**
     * Constructor to construct an HTML document.
     *
     * @param docType document type for the HTML document
     * @param htmlTree HTML tree of the document
     */
    public HtmlDocument(Content docType, Content htmlTree) {
        docContent = new ArrayList<>();
        addContent(nullCheck(docType));
        addContent(nullCheck(htmlTree));
    }

    /**
     * Adds content for the HTML document.
     *
     * @param htmlContent html content to be added
     */
    public final void addContent(Content htmlContent) {
        if (htmlContent.isValid())
            docContent.add(htmlContent);
    }

    /**
     * This method is not supported by the class.
     *
     * @param stringContent string content that needs to be added
     * @throws UnsupportedOperationException always
     */
    @Override
    public void addContent(CharSequence stringContent) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return (docContent.isEmpty());
    }

    /**
     * {@inheritDoc}
     */
    public boolean write(Writer out,  boolean atNewline) throws IOException {
        for (Content c : docContent)
            atNewline = c.write(out, atNewline);
        return atNewline;
    }
}
