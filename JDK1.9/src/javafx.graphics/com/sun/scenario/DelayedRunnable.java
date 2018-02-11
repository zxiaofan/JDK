/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario;

public interface DelayedRunnable extends Runnable {
    /**
     * Gets the delay <strong>in milliseconds</strong>.
     * @return delay in millis
     */
    public long getDelay();
}
