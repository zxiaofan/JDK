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

import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocletConstants;

/**
 * Class for generating string content for HTML tags of javadoc output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
public class StringContent extends Content {

    private final StringBuilder stringContent;

    /**
     * Constructor to construct StringContent object.
     */
    public StringContent() {
        stringContent = new StringBuilder();
    }

    /**
     * Constructor to construct StringContent object with some initial content.
     *
     * @param initialContent initial content for the object
     */
    public StringContent(CharSequence initialContent) {
        stringContent = new StringBuilder();
        appendChars(initialContent);
    }

    /**
     * This method is not supported by the class.
     *
     * @param content content that needs to be added
     * @throws UnsupportedOperationException always
     */
    @Override
    public void addContent(Content content) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adds content for the StringContent object.  The method escapes
     * HTML characters for the string content that is added.
     *
     * @param strContent string content to be added
     */
    @Override
    public void addContent(CharSequence strContent) {
        appendChars(strContent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return (stringContent.length() == 0);
    }

    @Override
    public int charCount() {
        return RawHtml.charCount(stringContent.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return stringContent.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean write(Writer out, boolean atNewline) throws IOException {
        String s = stringContent.toString();
        out.write(s);
        return s.endsWith(DocletConstants.NL);
    }

    private void appendChars(CharSequence s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '<': stringContent.append("&lt;");  break;
                case '>': stringContent.append("&gt;");  break;
                case '&': stringContent.append("&amp;"); break;
                default:  stringContent.append(ch);      break;
            }
        }
    }
}
