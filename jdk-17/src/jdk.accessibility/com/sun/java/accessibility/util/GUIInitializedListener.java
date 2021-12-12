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
 * The {@code GUIInitializedListener} interface is used by the {@link EventQueueMonitor}
 * class to notify an interested party when the GUI subsystem has been
 * initialized.  This is necessary because assistive technologies can
 * be loaded before the GUI subsystem is initialized.  As a result,
 * assistive technologies should check the
 * {@link EventQueueMonitor#isGUIInitialized isGUIInitialized} method
 * of {@code EventQueueMonitor} before creating any GUI components.  If the
 * return value is true, assistive technologies can create GUI components
 * following the same thread restrictions as any other application.  If
 * the return value is false, the assistive technology should register
 * a {@code GUIInitializedListener} with the {@code EventQueueMonitor} to be notified
 * when the GUI subsystem is initialized.
 *
 * @see EventQueueMonitor
 * @see EventQueueMonitor#isGUIInitialized
 * @see EventQueueMonitor#addGUIInitializedListener
 * @see EventQueueMonitor#removeGUIInitializedListener
 *
 */
public interface GUIInitializedListener extends EventListener {

    /**
     * Invoked when the GUI subsystem is initialized and it's OK for
     * the assisitive technology to create instances of GUI objects.
     */
    public void guiInitialized();

}
