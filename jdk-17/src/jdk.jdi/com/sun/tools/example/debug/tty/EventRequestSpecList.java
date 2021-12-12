/*
 * Copyright (c) 1998, 2019, Oracle and/or its affiliates. All rights reserved.
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

/*
 * This source code is provided to illustrate the usage of a given feature
 * or technique and has been deliberately simplified. Additional steps
 * required for a production-quality application, such as security checks,
 * input validation and proper error handling, might not be present in
 * this sample code.
 */


package com.sun.tools.example.debug.tty;

import com.sun.jdi.request.EventRequest;
import com.sun.jdi.event.ClassPrepareEvent;
import com.sun.jdi.ThreadReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EventRequestSpecList {

    private static final int statusResolved = 1;
    private static final int statusUnresolved = 2;
    private static final int statusError = 3;

    // all specs
    private List<EventRequestSpec> eventRequestSpecs = Collections.synchronizedList(
                                                  new ArrayList<EventRequestSpec>());

    EventRequestSpecList() {
    }

    /**
     * Resolve all deferred eventRequests waiting for 'refType'.
     * @return true if it completes successfully, false on error.
     */
    boolean resolve(ClassPrepareEvent event) {
        boolean failure = false;
        synchronized(eventRequestSpecs) {
            for (EventRequestSpec spec : eventRequestSpecs) {
                if (!spec.isResolved()) {
                    try {
                        EventRequest eventRequest = spec.resolve(event);
                        if (eventRequest != null) {
                            MessageOutput.println("Set deferred", spec.toString());
                        }
                    } catch (Exception e) {
                        MessageOutput.println("Unable to set deferred",
                                              new Object [] {spec.toString(),
                                                             spec.errorMessageFor(e)});
                        failure = true;
                    }
                }
            }
        }
        return !failure;
    }

    void resolveAll() {
        for (EventRequestSpec spec : eventRequestSpecs) {
            try {
                EventRequest eventRequest = spec.resolveEagerly();
                if (eventRequest != null) {
                    MessageOutput.println("Set deferred", spec.toString());
                }
            } catch (Exception e) {
            }
        }
    }

    boolean addEagerlyResolve(EventRequestSpec spec) {
        try {
            eventRequestSpecs.add(spec);
            EventRequest eventRequest = spec.resolveEagerly();
            if (eventRequest != null) {
                MessageOutput.println("Set", spec.toString());
            }
            return true;
        } catch (Exception exc) {
            MessageOutput.println("Unable to set",
                                  new Object [] {spec.toString(),
                                                 spec.errorMessageFor(exc)});
            return false;
        }
    }

    BreakpointSpec createBreakpoint(String classPattern, int line, ThreadReference threadFilter)
        throws ClassNotFoundException {
        ReferenceTypeSpec refSpec =
            new PatternReferenceTypeSpec(classPattern);
        return new BreakpointSpec(refSpec, line, threadFilter);
    }

    BreakpointSpec createBreakpoint(String classPattern,
                                    String methodId, ThreadReference threadFilter,
                                    List<String> methodArgs)
                                throws MalformedMemberNameException,
                                       ClassNotFoundException {
        ReferenceTypeSpec refSpec =
            new PatternReferenceTypeSpec(classPattern);
        return new BreakpointSpec(refSpec, methodId, threadFilter, methodArgs);
    }

    EventRequestSpec createExceptionCatch(String classPattern,
                                          boolean notifyCaught,
                                          boolean notifyUncaught)
                                            throws ClassNotFoundException {
        ReferenceTypeSpec refSpec =
            new PatternReferenceTypeSpec(classPattern);
        return new ExceptionSpec(refSpec, notifyCaught, notifyUncaught);
    }

    WatchpointSpec createAccessWatchpoint(String classPattern,
                                       String fieldId)
                                      throws MalformedMemberNameException,
                                             ClassNotFoundException {
        ReferenceTypeSpec refSpec =
            new PatternReferenceTypeSpec(classPattern);
        return new AccessWatchpointSpec(refSpec, fieldId);
    }

    WatchpointSpec createModificationWatchpoint(String classPattern,
                                       String fieldId)
                                      throws MalformedMemberNameException,
                                             ClassNotFoundException {
        ReferenceTypeSpec refSpec =
            new PatternReferenceTypeSpec(classPattern);
        return new ModificationWatchpointSpec(refSpec, fieldId);
    }

    boolean delete(EventRequestSpec proto) {
        synchronized (eventRequestSpecs) {
            int inx = eventRequestSpecs.indexOf(proto);
            if (inx != -1) {
                EventRequestSpec spec = eventRequestSpecs.get(inx);
                spec.remove();
                eventRequestSpecs.remove(inx);
                return true;
            } else {
                return false;
            }
        }
    }

    List<EventRequestSpec> eventRequestSpecs() {
       // We need to make a copy to avoid synchronization problems
        synchronized (eventRequestSpecs) {
            return new ArrayList<EventRequestSpec>(eventRequestSpecs);
        }
    }
}
