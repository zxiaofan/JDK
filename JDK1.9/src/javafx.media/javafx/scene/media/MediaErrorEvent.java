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

package javafx.scene.media;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * An {@link Event} representing the occurrence of an error in handling media.
 * @since JavaFX 2.0
 */
public class MediaErrorEvent extends Event {

    private static final long serialVersionUID = 20121107L;

    /**
     * The only valid event type for the <code>MediaErrorEvent</code>.
     */
    public static final EventType<MediaErrorEvent> MEDIA_ERROR =
            new EventType<MediaErrorEvent>(Event.ANY, "Media Error Event");

    /**
     * The {@link MediaException} which provoked this error event.
     */
    private MediaException error;

    /**
     * Construct a new <code>MediaErrorEvent</code> with the specified event
     * source, target and error.
     *
     * @param source the event source which sent the event
     * @param target the event target to associate with the event
     * @param error the error which provoked the event
     * @throws <code>IllegalArgumentException</code> if <code>error</code> is
     * <code>null</code>.
     */
    MediaErrorEvent(Object source, EventTarget target, MediaException error) {
        super(source, target, MEDIA_ERROR);

        if(error == null) {
            throw new IllegalArgumentException("error == null!");
        }

        this.error = error;
    }

    /**
     * Retrieve the error associated with this event.
     *
     * @return The <code>MediaException</code>
     */
    public MediaException getMediaError() {
        return error;
    }

    /**
     * Retrieve a <code>String</code> representation of the event.
     */
    @Override
    public String toString() {
        return super.toString() + ": source " + getSource() +
                "; target " + getTarget() + "; error " + error;
    }

    @Override
    public MediaErrorEvent copyFor(Object newSource, EventTarget newTarget) {
        return (MediaErrorEvent) super.copyFor(newSource, newTarget);
    }

    @Override
    public EventType<MediaErrorEvent> getEventType() {
        return (EventType<MediaErrorEvent>) super.getEventType();
    }

}
