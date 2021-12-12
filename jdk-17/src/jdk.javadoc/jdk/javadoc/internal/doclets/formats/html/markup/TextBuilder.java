/*
 * Copyright (c) 2010, 2021, Oracle and/or its affiliates. All rights reserved.
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

import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocletConstants;

/**
 * Class for generating string content for HTML tags of javadoc output.
 * The content is mutable to the extent that additional content may be added.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class TextBuilder extends Content {

    private final StringBuilder stringBuilder;

    /**
     * Constructor to construct StringContent object.
     */
    public TextBuilder() {
        stringBuilder = new StringBuilder();
    }

    /**
     * Constructor to construct StringContent object with some initial content.
     *
     * @param initialContent initial content for the object
     */
    public TextBuilder(CharSequence initialContent) {
        stringBuilder = new StringBuilder();
        Entity.escapeHtmlChars(initialContent, stringBuilder);
    }

    /**
     * Adds content for the StringContent object.  The method escapes
     * HTML characters for the string content that is added.
     *
     * @param strContent string content to be added
     */
    @Override
    public TextBuilder add(CharSequence strContent) {
        Entity.escapeHtmlChars(strContent, stringBuilder);
        return this;
    }

    @Override
    public boolean isEmpty() {
        return (stringBuilder.length() == 0);
    }

    @Override
    public int charCount() {
        return RawHtml.charCount(stringBuilder.toString());
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    @Override
    public boolean write(Writer out, boolean atNewline) throws IOException {
        String s = stringBuilder.toString();
        out.write(s);
        return s.endsWith(DocletConstants.NL);
    }
}
