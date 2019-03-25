/*
 * Copyright (c) 2003, 2007, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

import javax.sound.midi.Receiver;

/**
 * Interface for Sequencers that are able to do the auto-connect
 * as required by MidiSystem.getSequencer()
 *
 * @author Florian Bomers
 */
public interface AutoConnectSequencer {

    /**
     * Set the receiver that this device is
     * auto-connected. If non-null, the device
     * needs to re-connect itself to a suitable
     * device in open().
     */
    void setAutoConnect(Receiver autoConnectReceiver);
}
