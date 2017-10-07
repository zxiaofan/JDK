/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.mimepull;

import java.nio.ByteBuffer;

/**
 * @author Jitendra Kotamraju
 */
abstract class MIMEEvent {

    enum EVENT_TYPE {START_MESSAGE, START_PART, HEADERS, CONTENT, END_PART, END_MESSAGE}

    /**
     * Returns a event for parser's current cursor location in the MIME message.
     *
     * <p>
     * {@link EVENT_TYPE#START_MESSAGE} and {@link EVENT_TYPE#START_MESSAGE} events
     * are generated only once.
     *
     * <p>
     * {@link EVENT_TYPE#START_PART}, {@link EVENT_TYPE#END_PART}, {@link EVENT_TYPE#HEADERS}
     * events are generated only once for each attachment part.
     *
     * <p>
     * {@link EVENT_TYPE#CONTENT} event may be generated more than once for an attachment
     * part.
     *
     * @return event type
     */
    abstract EVENT_TYPE getEventType();

    static final StartMessage START_MESSAGE = new StartMessage();
    static final StartPart START_PART = new StartPart();
    static final EndPart END_PART = new EndPart();
    static final EndMessage END_MESSAGE = new EndMessage();

    static final class StartMessage extends MIMEEvent {
        EVENT_TYPE getEventType() {
            return EVENT_TYPE.START_MESSAGE;
        }
    }

    static final class StartPart extends MIMEEvent {
        EVENT_TYPE getEventType() {
            return EVENT_TYPE.START_PART;
        }
    }

    static final class EndPart extends MIMEEvent {
        EVENT_TYPE getEventType () {
            return EVENT_TYPE.END_PART;
        }
    }

    static final class Headers extends MIMEEvent {
        InternetHeaders ih;

        Headers(InternetHeaders ih) {
            this.ih = ih;
        }

        EVENT_TYPE getEventType() {
            return EVENT_TYPE.HEADERS;
        }

        InternetHeaders getHeaders() {
            return ih;
        }
    }

    static final class Content extends MIMEEvent {
        private final ByteBuffer buf;

        Content(ByteBuffer buf) {
            this.buf = buf;
        }

        EVENT_TYPE getEventType() {
            return EVENT_TYPE.CONTENT;
        }

        ByteBuffer getData() {
            return buf;
        }
    }

    static final class EndMessage extends MIMEEvent {
        EVENT_TYPE getEventType() {
            return EVENT_TYPE.END_MESSAGE;
        }
    }

}
