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

import jdk.javadoc.internal.doclets.toolkit.Content;
import jdk.javadoc.internal.doclets.toolkit.util.DocletConstants;

/**
 * Class for generating raw HTML content to be added to HTML pages of javadoc output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class RawHtml extends Content {

    private final String rawHtmlContent;

    /**
     * Constructor to construct a RawHtml object.
     *
     * @param rawHtml raw HTML text to be added
     */
    public RawHtml(CharSequence rawHtml) {
        rawHtmlContent = rawHtml.toString();
    }

    @Override
    public boolean isEmpty() {
        return rawHtmlContent.isEmpty();
    }

    @Override
    public String toString() {
        return rawHtmlContent;
    }

    private enum State { TEXT, ENTITY, TAG, STRING }

    @Override
    public int charCount() {
        return charCount(rawHtmlContent);
    }

    static int charCount(CharSequence htmlText) {
        State state = State.TEXT;
        int count = 0;
        for (int i = 0; i < htmlText.length(); i++) {
            char c = htmlText.charAt(i);
            switch (state) {
                case TEXT:
                    switch (c) {
                        case '<':
                            state = State.TAG;
                            break;
                        case '&':
                            state = State.ENTITY;
                            count++;
                            break;
                        case '\r':
                        case '\n':
                            // Windows uses "\r\n" as line separator while UNIX uses "\n".
                            // Ignore line separators to get consistent results across platforms.
                            break;
                        default:
                            count++;
                    }
                    break;

                case ENTITY:
                    if (!Character.isLetterOrDigit(c))
                        state = State.TEXT;
                    break;

                case TAG:
                    switch (c) {
                        case '"':
                            state = State.STRING;
                            break;
                        case '>':
                            state = State.TEXT;
                            break;
                    }
                    break;

                case STRING:
                    switch (c) {
                        case '"':
                            state = State.TAG;
                            break;
                    }
            }
        }
        return count;
    }

    @Override
    public boolean write(Writer out, boolean atNewline) throws IOException {
        out.write(rawHtmlContent);
        return rawHtmlContent.endsWith(DocletConstants.NL);
    }
}
