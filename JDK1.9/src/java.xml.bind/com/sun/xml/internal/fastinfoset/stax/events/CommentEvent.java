/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.stax.events ;


import javax.xml.stream.events.Comment;

public class CommentEvent extends EventBase implements Comment {

    /* String data for this event */
    private String _text;

    public CommentEvent() {
        super(COMMENT);
    }

    public CommentEvent(String text) {
        this();
        _text = text;
    }


    /**
     * @return String String representation of this event
     */
    public String toString() {
        return "<!--" + _text + "-->";
    }

  /**
   * Return the string data of the comment, returns empty string if it
   * does not exist
   */
    public String getText() {
        return _text ;
    }

    public void setText(String text) {
        _text = text;
    }
}
