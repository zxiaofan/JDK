/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.jfxmediaimpl.platform.gstreamer;

import com.sun.media.jfxmedia.Media;
import com.sun.media.jfxmedia.MediaError;
import com.sun.media.jfxmedia.locator.Locator;
import com.sun.media.jfxmediaimpl.MediaUtils;
import com.sun.media.jfxmediaimpl.NativeMedia;
import com.sun.media.jfxmediaimpl.platform.Platform;

/**
 * GStreamer implementation of Media
 */
final class GSTMedia extends NativeMedia {
    /**
     * Synchronization mutex for markers.
     */
    private final Object markerMutex = new Object();

    /**
     * Handle to the native media player.
     */
    protected long refNativeMedia;

    GSTMedia(Locator locator) {
        super(locator);

        init();
    }

    @Override
    public Platform getPlatform() {
        return GSTPlatform.getPlatformInstance();
    }

    private void init() {
        //***** Initialize the native media components
        long[] nativeMediaHandle = new long[1];
        MediaError ret;
        Locator loc = getLocator();
        ret = MediaError.getFromCode(gstInitNativeMedia(loc,
                loc.getContentType(), loc.getContentLength(),
                nativeMediaHandle));
        if (ret != MediaError.ERROR_NONE && ret != MediaError.ERROR_PLATFORM_UNSUPPORTED) {
            MediaUtils.nativeError(this, ret);
        }
        this.refNativeMedia = nativeMediaHandle[0];
    }

    long getNativeMediaRef() {
        return refNativeMedia;
    }

    @Override
    public synchronized void dispose() {
        if (0 != refNativeMedia) {
            gstDispose(refNativeMedia);
            refNativeMedia = 0L;
        }
    }

    /**
     * Initialize the native peer of this {@link Media}.
     *
     * @param locator Media location as a Locator object.
     * @return A handle to the native peer of the media.
     */
    private native int gstInitNativeMedia(Locator locator,
                                               String contentType,
                                               long sizeHint,
                                               long[] nativeMediaHandle);
    private native void gstDispose(long refNativeMedia);
}
