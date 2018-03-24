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
 * Lanczos interpolation resampler.
 *
 * @author Karl Helgason
 */
public final class SoftLanczosResampler extends SoftAbstractResampler {

    float[][] sinc_table;
    int sinc_table_fsize = 2000;
    int sinc_table_size = 5;
    int sinc_table_center = sinc_table_size / 2;

    public SoftLanczosResampler() {
        super();
        sinc_table = new float[sinc_table_fsize][];
        for (int i = 0; i < sinc_table_fsize; i++) {
            sinc_table[i] = sincTable(sinc_table_size, -i
                            / ((float) sinc_table_fsize));
        }
    }

    // Normalized sinc function
    public static double sinc(double x) {
        return (x == 0.0) ? 1.0 : Math.sin(Math.PI * x) / (Math.PI * x);
    }

    // Generate sinc table
    public static float[] sincTable(int size, float offset) {
        int center = size / 2;
        float[] w = new float[size];
        for (int k = 0; k < size; k++) {
            float x = (-center + k + offset);
            if (x < -2 || x > 2)
                w[k] = 0;
            else if (x == 0)
                w[k] = 1;
            else {
                w[k] = (float)(2.0 * Math.sin(Math.PI * x)
                                * Math.sin(Math.PI * x / 2.0)
                                / ((Math.PI * x) * (Math.PI * x)));
            }
        }
        return w;
    }

    @Override
    public int getPadding() // must be at least half of sinc_table_size
    {
        return sinc_table_size / 2 + 2;
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

        if (pitchstep == 0) {
            while (ix < ix_end && ox < ox_end) {
                int iix = (int) ix;
                float[] sinc_table
                        = this.sinc_table[(int) ((ix - iix) * sinc_table_fsize)];
                int xx = iix - sinc_table_center;
                float y = 0;
                for (int i = 0; i < sinc_table_size; i++, xx++)
                    y += in[xx] * sinc_table[i];
                out[ox++] = y;
                ix += pitch;
            }
        } else {
            while (ix < ix_end && ox < ox_end) {
                int iix = (int) ix;
                float[] sinc_table
                        = this.sinc_table[(int) ((ix - iix) * sinc_table_fsize)];
                int xx = iix - sinc_table_center;
                float y = 0;
                for (int i = 0; i < sinc_table_size; i++, xx++)
                    y += in[xx] * sinc_table[i];
                out[ox++] = y;

                ix += pitch;
                pitch += pitchstep;
            }
        }
        in_offset[0] = ix;
        out_offset[0] = ox;
        startpitch[0] = pitch;

    }
}
