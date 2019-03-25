/*
 * Copyright (c) 2001, 2017, Oracle and/or its affiliates. All rights reserved.
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
import com.sun.jdi.event.VMDeathEvent;

/**
 * Request for notification when the target VM terminates.
 * When an enabled VMDeathRequest is satisfied, an
 * {@link EventSet event set} containing a
 * {@link VMDeathEvent VMDeathEvent}
 * will be placed on the {@link EventQueue EventQueue}.
 * The collection of existing VMDeathRequests is
 * managed by the {@link EventRequestManager}
 * <P>
 * Even without creating a VMDeathRequest, a single
 * unsolicited VMDeathEvent will be sent with a
 * {@link EventRequest#suspendPolicy() suspend policy}
 * of {@link EventRequest#SUSPEND_NONE SUSPEND_NONE}.
 * This request would typically be created so that a
 * VMDeathEvent with a suspend policy of
 * {@link EventRequest#SUSPEND_ALL SUSPEND_ALL}
 * will be sent.  This event can be used to assure
 * completion of any processing which requires the VM
 * to be alive (e.g. event processing).  Note: the
 * unsolicited VMDeathEvent will still be sent.
 *
 * @see VMDeathEvent
 * @see EventQueue
 * @see EventRequestManager
 *
 * @author Robert Field
 * @since  1.4
 */
public interface VMDeathRequest extends EventRequest {
}
