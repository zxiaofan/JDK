/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.events ;

import javax.xml.stream.events.Comment;
import javax.xml.stream.events.XMLEvent;

/**
 * This class contains information about Comment event.
 *
 * @author Neeraj Bajaj, Sun Microsystems.
 */
public class CommentEvent extends DummyEvent implements Comment {

    /* String data for this event */
    private String fText ;

    public CommentEvent() {
        init();
    }

    public CommentEvent(String text) {
        init();
        fText = text;
    }

    protected void init() {
        setEventType(XMLEvent.COMMENT);
    }

    /**
     * @return String String representation of this event
     */
    public String toString() {
        return "<!--" + getText() + "-->";
    }


    /** Return the string data of the comment, returns empty string if it
     * does not exist
     * @return String
     */
    public String getText() {
        return fText ;
    }

    protected void writeAsEncodedUnicodeEx(java.io.Writer writer)
    throws java.io.IOException
    {
        writer.write("<!--" + getText() + "-->");
    }

}
