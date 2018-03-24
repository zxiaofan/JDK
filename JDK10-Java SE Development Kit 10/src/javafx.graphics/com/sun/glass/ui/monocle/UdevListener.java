/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import java.util.Map;

/**
 * A UdevListener is registered with a Udev when the Udev
 * is created. The listener is then called on the event thread when udev
 * events are avaialable.
 */
interface UdevListener {

    /**
     * Called when a udev event is available.
     * Called on the runnable processor provided to the Udev.
     *
     * @param action The udev action, usually "add", "remove", "change",
     *               "online" or "offline.
     * @param event a map of key/value pairs describing the event. These are
     *              the key/value pairs received from udev.
     */
    void udevEvent(String action, Map<String, String> event);
}
