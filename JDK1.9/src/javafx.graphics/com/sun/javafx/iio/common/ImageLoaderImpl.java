/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.iio.common;

import com.sun.javafx.iio.ImageFormatDescription;
import com.sun.javafx.iio.ImageLoadListener;
import com.sun.javafx.iio.ImageLoader;
import com.sun.javafx.iio.ImageMetadata;
import java.util.HashSet;
import java.util.Iterator;

public abstract class ImageLoaderImpl implements ImageLoader {

    protected ImageFormatDescription formatDescription;
    protected HashSet<ImageLoadListener> listeners;
    protected int lastPercentDone = -1;

    protected ImageLoaderImpl(ImageFormatDescription formatDescription) {
        if (formatDescription == null) {
            throw new IllegalArgumentException("formatDescription == null!");
        }

        this.formatDescription = formatDescription;
    }

    public final ImageFormatDescription getFormatDescription() {
        return formatDescription;
    }

    public final void addListener(ImageLoadListener listener) {
        if (listeners == null) {
            listeners = new HashSet<ImageLoadListener>();
        }
        listeners.add(listener);
    }

    public final void removeListener(ImageLoadListener listener) {
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    protected void emitWarning(String warning) {
        if(listeners != null && !listeners.isEmpty()) {
            Iterator<ImageLoadListener> iter = listeners.iterator();
            while(iter.hasNext()) {
                ImageLoadListener l = iter.next();
                l.imageLoadWarning(this, warning);
            }
        }
    }

    protected void updateImageProgress(float percentageDone) {
        if (listeners != null && !listeners.isEmpty()) {
            int percentDone = (int) percentageDone;
            int delta = ImageTools.PROGRESS_INTERVAL;
            if ((delta * percentDone / delta) % delta == 0 && percentDone != lastPercentDone) {
                lastPercentDone = percentDone;
                Iterator<ImageLoadListener> iter = listeners.iterator();
                while (iter.hasNext()) {
                    ImageLoadListener listener = iter.next();
                    listener.imageLoadProgress(this, percentDone);
                }
            }
        }
    }

    protected void updateImageMetadata(ImageMetadata metadata) {
        if(listeners != null && !listeners.isEmpty()) {
            Iterator<ImageLoadListener> iter = listeners.iterator();
            while(iter.hasNext()) {
                ImageLoadListener l = iter.next();
                l.imageLoadMetaData(this, metadata);
            }
        }
    }
}
