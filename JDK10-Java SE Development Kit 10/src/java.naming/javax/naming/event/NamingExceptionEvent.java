/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming.event;

import javax.naming.NamingException;

/**
  * This class represents an event fired when the procedures/processes
  * used to collect information for notifying listeners of
  * {@code NamingEvent}s threw a {@code NamingException}.
  * This can happen, for example, if the server which the listener is using
  * aborts subsequent to the {@code addNamingListener()} call.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see NamingListener#namingExceptionThrown
  * @see EventContext
  * @since 1.3
  */

public class NamingExceptionEvent extends java.util.EventObject {
    /**
     * Contains the exception that was thrown
     * @serial
     */
    private NamingException exception;

    /**
     * Constructs an instance of {@code NamingExceptionEvent} using
     * the context in which the {@code NamingException} was thrown and the exception
     * that was thrown.
     *
     * @param source The non-null context in which the exception was thrown.
     * @param exc    The non-null {@code NamingException} that was thrown.
     *
     */
    public NamingExceptionEvent(EventContext source, NamingException exc) {
        super(source);
        exception = exc;
    }

    /**
     * Retrieves the exception that was thrown.
     * @return The exception that was thrown.
     */
    public NamingException getException() {
        return exception;
    }

    /**
     * Retrieves the {@code EventContext} that fired this event.
     * This returns the same object as {@code EventObject.getSource()}.
     * @return The non-null {@code EventContext} that fired this event.
     */
    public EventContext getEventContext() {
        return (EventContext)getSource();
    }

    /**
     * Invokes the {@code namingExceptionThrown()} method on
     * a listener using this event.
     * @param listener The non-null naming listener on which to invoke
     * the method.
     */
    public void dispatch(NamingListener listener) {
        listener.namingExceptionThrown(this);
    }

    private static final long serialVersionUID = -4877678086134736336L;
}
