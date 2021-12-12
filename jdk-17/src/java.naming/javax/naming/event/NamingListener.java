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

/**
  * This interface is the root of listener interfaces that
  * handle {@code NamingEvent}s.
  * It does not make sense for a listener to implement just this interface.
  * A listener typically implements a subinterface of {@code NamingListener},
  * such as {@code ObjectChangeListener} or {@code NamespaceChangeListener}.
  *<p>
  * This interface contains a single method, {@code namingExceptionThrown()},
  * that must be implemented so that the listener can be notified of
  * exceptions that are thrown (by the service provider) while gathering
  * information about the events that they're interested in.
  * When this method is invoked, the listener has been automatically deregistered
  * from the {@code EventContext} with which it has registered.
  *<p>
  * For example, suppose a listener implements {@code ObjectChangeListener} and
  * registers with an {@code EventContext}.
  * Then, if the connection to the server is subsequently broken,
  * the listener will receive a {@code NamingExceptionEvent} and may
  * take some corrective action, such as notifying the user of the application.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see NamingEvent
  * @see NamingExceptionEvent
  * @see EventContext
  * @see EventDirContext
  * @since 1.3
  */
public interface NamingListener extends java.util.EventListener {
    /**
     * Called when a naming exception is thrown while attempting
     * to fire a {@code NamingEvent}.
     *
     * @param evt The nonnull event.
     */
    void namingExceptionThrown(NamingExceptionEvent evt);
}
