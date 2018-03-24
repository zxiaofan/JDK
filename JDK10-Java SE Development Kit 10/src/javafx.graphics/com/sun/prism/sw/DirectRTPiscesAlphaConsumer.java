/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.sw;

import com.sun.openpisces.AlphaConsumer;
import com.sun.openpisces.Renderer;
import com.sun.pisces.PiscesRenderer;

final class DirectRTPiscesAlphaConsumer implements AlphaConsumer {

    private byte alpha_map[];
    private int outpix_xmin;
    private int outpix_ymin;
    private int w;
    private int h;
    private int rowNum;

    private PiscesRenderer pr;

    void initConsumer(Renderer renderer, PiscesRenderer pr) {
        outpix_xmin = renderer.getOutpixMinX();
        outpix_ymin = renderer.getOutpixMinY();
        w = renderer.getOutpixMaxX() - outpix_xmin;
        if (w < 0) { w = 0; }
        h = renderer.getOutpixMaxY() - outpix_ymin;
        if (h < 0) { h = 0; }
        rowNum = 0;
        this.pr = pr;
    }

    @Override
    public int getOriginX() {
        return outpix_xmin;
    }

    @Override
    public int getOriginY() {
        return outpix_ymin;
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }

    @Override
    public void setMaxAlpha(int maxalpha) {
        if ((alpha_map == null) || (alpha_map.length != maxalpha+1)) {
            alpha_map = new byte[maxalpha+1];
            for (int i = 0; i <= maxalpha; i++) {
                alpha_map[i] = (byte) ((i*255 + maxalpha/2)/maxalpha);
            }
        }
    }

    @Override
    public void setAndClearRelativeAlphas(int[] alphaDeltas, int pix_y, int firstdelta, int lastdelta) {
        pr.emitAndClearAlphaRow(alpha_map, alphaDeltas, pix_y, firstdelta, lastdelta, rowNum);
        rowNum++;
    }
}
