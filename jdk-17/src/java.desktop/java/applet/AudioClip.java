/*
 * Copyright (c) 1995, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.applet;

/**
 * The {@code AudioClip} interface is a simple abstraction for playing a sound
 * clip. Multiple {@code AudioClip} items can be playing at the same time, and
 * the resulting sound is mixed together to produce a composite.
 *
 * @author Arthur van Hoff
 * @since 1.0
 * @deprecated The Applet API is deprecated, no replacement.
 */
@Deprecated(since = "9", forRemoval = true)
public interface AudioClip {

    /**
     * Starts playing this audio clip. Each time this method is called, the clip
     * is restarted from the beginning.
     */
    void play();

    /**
     * Starts playing this audio clip in a loop.
     */
    void loop();

    /**
     * Stops playing this audio clip.
     */
    void stop();
}
