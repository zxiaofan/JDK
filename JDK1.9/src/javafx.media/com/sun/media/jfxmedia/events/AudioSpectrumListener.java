/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmedia.events;

public interface AudioSpectrumListener {

    /**
     * Notification when there is a new AudioSpectrumEvent.
     *
     * @param evt AudioSpectrumEvent object.
     */
    void onAudioSpectrumEvent(AudioSpectrumEvent evt);
}
