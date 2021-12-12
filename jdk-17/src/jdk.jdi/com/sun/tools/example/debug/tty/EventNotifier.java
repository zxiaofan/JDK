/*
 * Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.jdi.event.*;

interface EventNotifier {
    void vmStartEvent(VMStartEvent e);
    void vmDeathEvent(VMDeathEvent e);
    void vmDisconnectEvent(VMDisconnectEvent e);

    void threadStartEvent(ThreadStartEvent e);
    void threadDeathEvent(ThreadDeathEvent e);

    void classPrepareEvent(ClassPrepareEvent e);
    void classUnloadEvent(ClassUnloadEvent e);

    void breakpointEvent(BreakpointEvent e);
    void fieldWatchEvent(WatchpointEvent e);
    void stepEvent(StepEvent e);
    void exceptionEvent(ExceptionEvent e);
    void methodEntryEvent(MethodEntryEvent e);
    boolean methodExitEvent(MethodExitEvent e);

    void vmInterrupted();
    void receivedEvent(Event event);
}
