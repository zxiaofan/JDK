/*
 * Copyright (c) 2002, 2007, Oracle and/or its affiliates. All rights reserved.
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

import javax.sound.sampled.Clip;

/**
 * Interface for Clip objects that close themselves automatically.
 *
 * @author Florian Bomers
 */
interface AutoClosingClip extends Clip {

    /**
     * Indicates whether this clip instance is auto closing.
     * When the clip is auto closing, it calls the close()
     * method automatically after a short period of inactivity.<br>
     * <br>
     *
     * @return true if this clip is auto closing
     */
    boolean isAutoClosing();

    /**
     * Sets whether this Clip instance is auto closing or not.
     * If true, the close() method will be called automatically
     * after a short period of inactivity.
     *
     * @param value - true to set this clip to auto closing
     */
    void setAutoClosing(boolean value);
}
