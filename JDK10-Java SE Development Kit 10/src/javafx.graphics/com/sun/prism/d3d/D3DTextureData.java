/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.d3d;

import com.sun.prism.PixelFormat;
import com.sun.prism.impl.PrismTrace;

public class D3DTextureData extends D3DResource.D3DRecord {
    private final long size;
    private final boolean isRTT;
    private final int samples;

    static long estimateSize(int physicalWidth, int physicalHeight,
                             PixelFormat format)
    {
        return ((long) physicalWidth) * ((long) physicalHeight) *
               ((long) format.getBytesPerPixelUnit());
    }

    static long estimateRTSize(int physicalWidth, int physicalHeight,
                               boolean hasDepth)
    {
        return ((long) physicalWidth) * ((long) physicalHeight) * 4L;
    }

    D3DTextureData(D3DContext context,
                   long pResource, boolean isRTT,
                   int physicalWidth, int physicalHeight,
                   PixelFormat format, int numberOfSamples)
    {
        super(context, pResource);
        this.size = isRTT
               ? estimateRTSize(physicalWidth, physicalHeight, false)
               : estimateSize(physicalWidth, physicalHeight, format);
        this.isRTT = isRTT;
        this.samples = numberOfSamples;
        if (isRTT) {
            PrismTrace.rttCreated(pResource, physicalWidth, physicalHeight, size);
        } else {
            PrismTrace.textureCreated(pResource, physicalWidth, physicalHeight, size);
        }
    }

    int getSamples() {
        return samples;
    }

    long getSize() {
        return size;
    }

    @Override
    protected void markDisposed() {
        long pResource = getResource();
        if (pResource != 0L) {
            if (isRTT) {
                PrismTrace.rttDisposed(pResource);
            } else {
                PrismTrace.textureDisposed(pResource);
            }
        }
        super.markDisposed();
    }

    @Override
    public void dispose() {
        long pResource = getResource();
        if (pResource != 0L) {
            if (isRTT) {
                PrismTrace.rttDisposed(pResource);
            } else {
                PrismTrace.textureDisposed(pResource);
            }
        }
        super.dispose();
    }
}
