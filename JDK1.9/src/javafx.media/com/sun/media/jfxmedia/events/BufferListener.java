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
 * BufferListener is listener for all kinds of buffering events. It receives
 * notifications from the MediaPlayer.
 * 1) Any application that needs information about the progress of downloading
 * remote content to the local cache listens to the BufferProgressEvent.
 *
 * @see BufferProgressEvent
 */
public interface BufferListener {

    /**
     * Notification about buffer progress.
     *
     * @param evt CacheStateEvent object.
     */
    public void onBufferProgress(BufferProgressEvent evt);

}
