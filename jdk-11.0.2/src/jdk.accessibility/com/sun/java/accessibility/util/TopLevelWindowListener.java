/*
 * Copyright (c) 2002, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.java.accessibility.util;

import java.awt.*;
import java.util.*;
import javax.accessibility.*;

/**
 * The {@code TopLevelWindowListener} interface is used by the {@link EventQueueMonitor}
 * class to notify an interested party when a top level window is created
 * or destroyed in the Java Virtual Machine.  Classes wishing to express
 * an interest in top level window events should implement this interface
 * and register themselves with the {@code EventQueueMonitor} by calling the
 * {@link EventQueueMonitor#addTopLevelWindowListener EventQueueMonitor.addTopLevelWindowListener}
 * class method.
 *
 * @see EventQueueMonitor
 * @see EventQueueMonitor#addTopLevelWindowListener
 * @see EventQueueMonitor#removeTopLevelWindowListener
 *
 */
public interface TopLevelWindowListener extends EventListener {

    /**
     * Invoked when a new top level window has been created.
     *
     * @param w the Window that was created
     */
    public void topLevelWindowCreated(Window w);

    /**
     * Invoked when a top level window has been destroyed.
     *
     * @param w the Window that was destroyed
     */
    public void topLevelWindowDestroyed(Window w);
}
