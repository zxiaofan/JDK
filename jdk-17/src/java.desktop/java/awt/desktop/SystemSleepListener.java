/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.desktop;

/**
 * Implementors receive notification as the system is entering sleep, and after
 * the system wakes.
 * <p>
 * This notification is useful for disconnecting from network services prior to
 * sleep, or re-establishing a connection if the network configuration has
 * changed during sleep.
 *
 * @since 9
 */
public interface SystemSleepListener extends SystemEventListener {

    /**
     * Called when the system is about to sleep. Note: This message may not be
     * delivered prior to the actual system sleep, and may be processed after
     * the corresponding wake has occurred.
     *
     * @param  e the system sleep event
     */
    public void systemAboutToSleep(SystemSleepEvent e);

    /**
     * Called after the system has awoken from sleeping.
     *
     * @param  e the system sleep event
     */
    public void systemAwoke(SystemSleepEvent e);
}
