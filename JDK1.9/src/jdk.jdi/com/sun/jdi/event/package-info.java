/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * This package defines JDI events and event processing.
 * An {@link com.sun.jdi.event.Event} is always a member of an
 * {@link com.sun.jdi.event.EventSet}, which
 * is retrieved from the {@link com.sun.jdi.event.EventQueue}.
 * Examples of Events include
 * {@link com.sun.jdi.event.BreakpointEvent "breakpoints events"},
 * {@link com.sun.jdi.event.ThreadStartEvent "thread creation events"} and
 * {@link com.sun.jdi.event.VMDeathEvent "virtual machine death event"}.
 *  With the exception
 * of termination events, all events received must be requested with an
 * {@link com.sun.jdi.request.EventRequest "EventRequest"}.  The
 * {@link com.sun.jdi.request} package defines event requests and event
 * request management.
 * <p>
 * Methods may be added to the interfaces in the JDI packages in future
 * releases. Existing packages may be renamed if the JDI becomes a standard
 * extension.
 */

package com.sun.jdi.event;
