/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdi;

import com.sun.jdi.*;
import java.util.EventListener;

interface ThreadListener extends EventListener {
    boolean threadResumable(ThreadAction action);
    /*
     * Not needed for current implementation, and hard to implement
     * correctly. (See TargetVM.handleEventCmdSet)
     *   void threadSuspended(ThreadAction action);
     */
}
