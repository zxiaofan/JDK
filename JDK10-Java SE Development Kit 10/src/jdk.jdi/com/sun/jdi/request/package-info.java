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
 * This package is used to request that a JDI
 * event be sent under specified conditions.
 * With the exception of termination events, which are
 * always sent, there is one kind of
 * {@link com.sun.jdi.request.EventRequest} for each kind of
 * {@link com.sun.jdi.event.Event Event} - for example,
 * {@link com.sun.jdi.request.BreakpointRequest} is used to request a
 * {@link com.sun.jdi.event.BreakpointEvent BreakpointEvent}.
 * Event requests are created by the
 * {@link com.sun.jdi.request.EventRequestManager}.
 * Events and event processing are defined in the
 * {@link com.sun.jdi.event} package.
 * <p>
 * Methods may be added to the interfaces in the JDI packages in future
 * releases. Existing packages may be renamed if the JDI becomes a standard
 * extension.
 */

package com.sun.jdi.request;
