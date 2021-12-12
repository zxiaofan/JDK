/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi.request;

import com.sun.jdi.event.EventQueue;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.event.ModificationWatchpointEvent;

/**
 * Request for notification when a field is set.
 * This event will be triggered when a value is assigned to the specified
 * field with a Java programming
 * language statement (assignment, increment, etc) or by a
 * Java Native Interface (JNI) set function (<code>Set&lt;Type&gt;Field,
 * SetStatic&lt;Type&gt;Field</code>).
 * Setting a field to a value which is the same as the previous value
 * still triggers this event.
 * Modification by JDI does not trigger this event.
 * When an enabled ModificationWatchpointRequest is satisfied, an
 * {@link EventSet event set} containing a
 * {@link ModificationWatchpointEvent ModificationWatchpointEvent}
 * will be placed on the {@link EventQueue EventQueue}.
 * The collection of existing watchpoints is
 * managed by the {@link EventRequestManager}.
 *
 * @see ModificationWatchpointEvent
 * @see AccessWatchpointRequest
 * @see EventQueue
 * @see EventRequestManager
 *
 * @author Robert Field
 * @since  1.3
 */
public interface ModificationWatchpointRequest extends WatchpointRequest {
}
