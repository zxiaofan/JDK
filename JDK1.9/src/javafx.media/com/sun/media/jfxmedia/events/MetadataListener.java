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

import java.util.Map;

/**
 * The listener interface for receiving notifications when a metadata has been
 * encountered in the media stream.
 */
public interface MetadataListener {

    /**
     * The metadata notification indicates a metadata has been
     * reached or metadata value was changed during playback.
     *
     * @param metadata
     */
    public void onMetadata(Map<String, Object> metadata);
}
