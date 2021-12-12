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
 * Class for containing immutable string content for HTML tags of javadoc output.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class Text extends Content {
    private final String string;

    public static final Text EMPTY = Text.of("");

    /**
     * Creates a new object containing immutable text.
     *
     * @param content the text content
     * @return the object
     */
    public static Text of(CharSequence content) {
        return new Text(content);
    }

    /**
     * Constructs an immutable text object.
     *
     * @param content content for the object
     */
    private Text(CharSequence content) {
        string = Entity.escapeHtmlChars(content);
    }

    @Override
    public boolean isEmpty() {
        return string.isEmpty();
    }

    @Override
    public int charCount() {
        return RawHtml.charCount(string);
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public boolean write(Writer out, boolean atNewline) throws IOException {
        out.write(string);
        return string.endsWith(DocletConstants.NL);
    }

}
