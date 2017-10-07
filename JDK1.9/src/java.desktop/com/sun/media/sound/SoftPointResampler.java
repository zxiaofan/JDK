/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * A resampler that uses 0-order (nearest-neighbor) interpolation.
 *
 * @author Karl Helgason
 */
public final class SoftPointResampler extends SoftAbstractResampler {

    @Override
    public int getPadding() {
        return 100;
    }

    @Override
    public void interpolate(float[] in, float[] in_offset, float in_end,
                            float[] startpitch, float pitchstep, float[] out, int[] out_offset,
                            int out_end) {
        float pitch = startpitch[0];
        float ix = in_offset[0];
        int ox = out_offset[0];
        float ix_end = in_end;
        float ox_end = out_end;
        if (pitchstep == 0) {
            while (ix < ix_end && ox < ox_end) {
                out[ox++] = in[(int) ix];
                ix += pitch;
            }
        } else {
            while (ix < ix_end && ox < ox_end) {
                out[ox++] = in[(int) ix];
                ix += pitch;
                pitch += pitchstep;
            }
        }
        in_offset[0] = ix;
        out_offset[0] = ox;
        startpitch[0] = pitch;
    }
}
