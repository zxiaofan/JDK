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
 * A resampler that uses first-order (linear) interpolation.
 *
 * This one doesn't perform float to int casting inside the processing loop.
 *
 * @author Karl Helgason
 */
public final class SoftLinearResampler2 extends SoftAbstractResampler {

    @Override
    public int getPadding() {
        return 2;
    }

    @Override
    public void interpolate(float[] in, float[] in_offset, float in_end,
                            float[] startpitch, float pitchstep, float[] out, int[] out_offset,
                            int out_end) {

        float pitch = startpitch[0];
        float ix = in_offset[0];
        int ox = out_offset[0];
        float ix_end = in_end;
        int ox_end = out_end;

        // Check if we have do anything
        if (!(ix < ix_end && ox < ox_end))
            return;

        // 15 bit shift was choosed because
        // it resulted in no drift between p_ix and ix.
        int p_ix = (int) (ix * (1 << 15));
        int p_ix_end = (int) (ix_end * (1 << 15));
        int p_pitch = (int) (pitch * (1 << 15));
        // Pitch needs to recalculated
        // to ensure no drift between p_ix and ix.
        pitch = p_pitch * (1f / (1 << 15));

        if (pitchstep == 0f) {

            // To reduce
            //    while (p_ix < p_ix_end && ox < ox_end)
            // into
            //    while  (ox < ox_end)
            // We need to calculate new ox_end value.
            int p_ix_len = p_ix_end - p_ix;
            int p_mod = p_ix_len % p_pitch;
            if (p_mod != 0)
                p_ix_len += p_pitch - p_mod;
            int ox_end2 = ox + p_ix_len / p_pitch;
            if (ox_end2 < ox_end)
                ox_end = ox_end2;

            while (ox < ox_end) {
                int iix = p_ix >> 15;
                float fix = ix - iix;
                float i = in[iix];
                out[ox++] = i + (in[iix + 1] - i) * fix;
                p_ix += p_pitch;
                ix += pitch;
            }

        } else {

            int p_pitchstep = (int) (pitchstep * (1 << 15));
            pitchstep = p_pitchstep * (1f / (1 << 15));

            while (p_ix < p_ix_end && ox < ox_end) {
                int iix = p_ix >> 15;
                float fix = ix - iix;
                float i = in[iix];
                out[ox++] = i + (in[iix + 1] - i) * fix;
                ix += pitch;
                p_ix += p_pitch;
                pitch += pitchstep;
                p_pitch += p_pitchstep;
            }
        }
        in_offset[0] = ix;
        out_offset[0] = ox;
        startpitch[0] = pitch;

    }
}
