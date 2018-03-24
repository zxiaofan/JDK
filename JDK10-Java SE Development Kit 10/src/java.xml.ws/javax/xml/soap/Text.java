/*
 * Copyright (c) 2004, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.soap;

/**
 * A representation of a node whose value is text.  A {@code Text} object
 * may represent text that is content or text that is a comment.
 *
 * @since 1.6
 */
public interface Text extends Node, org.w3c.dom.Text {

    /**
     * Retrieves whether this {@code Text} object represents a comment.
     *
     * @return {@code true} if this {@code Text} object is a
     *         comment; {@code false} otherwise
     */
    public boolean isComment();
}
