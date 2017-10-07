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

package com.sun.tools.doclets.internal.toolkit;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Objects;

import com.sun.tools.doclets.internal.toolkit.util.*;

/**
 * A class to create content for javadoc output pages.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
@Deprecated
public abstract class Content {

    /**
     * Returns a string representation of the content.
     *
     * @return string representation of the content
     */
    @Override
    public String toString() {
        StringWriter out = new StringWriter();
        try {
            write(out, true);
        } catch (IOException e) {
            // cannot happen from StringWriter
            throw new DocletAbortException(e);
        }
        return out.toString();
    }

    /**
     * Adds content to the existing content.
     *
     * @param content content that needs to be added
     */
    public abstract void addContent(Content content);

    /**
     * Adds a string content to the existing content.
     *
     * @param stringContent the string content to be added
     */
    public abstract void addContent(String stringContent);

    /**
     * Writes content to a writer.
     *
     */
    public abstract boolean write(Writer writer, boolean atNewline) throws IOException ;

    /**
     * Returns true if the content is empty.
     *
     * @return true if no content to be displayed else return false
     */
    public abstract boolean isEmpty();

    /**
     * Returns true if the content is valid.
     *
     * @return true if the content is valid else return false
     */
    public boolean isValid() {
        return !isEmpty();
    }

    /**
     * Return the number of characters of plain text content in this object
     * (optional operation.)
     * @return the number of characters of plain text content in this
     */
    public int charCount() {
        return 0;
    }

    /**
     * Checks for null values.
     *
     * @param t reference type to check for null values
     * @return the reference type if not null or else throws a null pointer exception
     */
    protected static <T> T nullCheck(T t) {
        return Objects.requireNonNull(t);
    }
}
