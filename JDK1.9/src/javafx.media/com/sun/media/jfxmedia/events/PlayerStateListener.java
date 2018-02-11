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

/**
 * Notifications related to playing media are sent to PlayerStateListener.
 */
public interface PlayerStateListener
{
    /**
     * The ready state indicates the media is loaded.
     * For best results, developers should wait on OnReady() before playing a media.
     *
     * @param evt
     */
    public void onReady(PlayerStateEvent evt);

    /**
     * The play state indicates the media is beginning to play.
     *
     * @param evt
     */
    public void onPlaying(PlayerStateEvent evt);

    /**
     * The pause state indicates playback has paused.
     *
     * @param evt
     */
    public void onPause(PlayerStateEvent evt);

    /**
     * The stop state indicates playback has paused and presentation time has been reset back to 0.
     * If the player is asked to play() again, playback begins from the beginning.
     *
     * @param evt
     */
    public void onStop(PlayerStateEvent evt);

    public void onStall(PlayerStateEvent evt);


    /**
     * The finish state indicates playback has completed playback to the end.
     *
     * @param evt
     */
    public void onFinish(PlayerStateEvent evt);

    /**
     * The error notification provides information on any error during playback.
     *
     * @param evt
     */
    public void onHalt(PlayerStateEvent evt);
}
