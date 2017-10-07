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

package com.sun.scenario.animation.shared;

/**
 * A PulseReceiver can receive regular pulses from the MasterTimer. Removing
 * receivers from the MasterTimer needs to be in-sync with the
 * timePulse-iteration. The receiver is removed if timePulse returns true.
 * The reason we do not use Callback or some other pre-existing interface
 * is that we want an interface that takes a primitive long, whereas Callback
 * would require a wrapped Long and would have some impact on performance.
 */
public interface PulseReceiver {
    /**
     * Callback triggered to send regular pulses to the PulseReceiver
     *
     * @param now
     *            Timestamp of the pulse.
     * @return true if PulseReceiver should be removed from the MasterTimer.
     */
    void timePulse(long now);
}
