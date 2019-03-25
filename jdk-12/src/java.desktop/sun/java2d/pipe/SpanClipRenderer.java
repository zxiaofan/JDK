/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.pipe;

import java.awt.Rectangle;
import java.awt.Shape;
import sun.java2d.SunGraphics2D;

/**
 * This class uses a Region iterator to modify the extents of alpha
 * tiles created during Shape rendering based upon a non-rectangular
 * clipping path.
 */
public class SpanClipRenderer implements CompositePipe
{
    CompositePipe outpipe;

    static Class<?> RegionClass = Region.class;
    static Class<?> RegionIteratorClass = RegionIterator.class;

    static {
        initIDs(RegionClass, RegionIteratorClass);
    }

    static native void initIDs(Class<?> rc, Class<?> ric);

    public SpanClipRenderer(CompositePipe pipe) {
        outpipe = pipe;
    }

    class SCRcontext {
        RegionIterator iterator;
        Object outcontext;
        int[] band;
        byte[] tile;

        public SCRcontext(RegionIterator ri, Object outctx) {
            iterator = ri;
            outcontext = outctx;
            band = new int[4];
        }
    }

    public Object startSequence(SunGraphics2D sg, Shape s, Rectangle devR,
                                int[] abox) {
        RegionIterator ri = sg.clipRegion.getIterator();

        return new SCRcontext(ri, outpipe.startSequence(sg, s, devR, abox));
    }

    public boolean needTile(Object ctx, int x, int y, int w, int h) {
        SCRcontext context = (SCRcontext) ctx;
        return (outpipe.needTile(context.outcontext, x, y, w, h));
    }

    public void renderPathTile(Object ctx,
                               byte[] atile, int offset, int tsize,
                               int x, int y, int w, int h,
                               ShapeSpanIterator sr) {
        renderPathTile(ctx, atile, offset, tsize, x, y, w, h);
    }

    public void renderPathTile(Object ctx,
                               byte[] atile, int offset, int tsize,
                               int x, int y, int w, int h) {
        SCRcontext context = (SCRcontext) ctx;
        RegionIterator ri = context.iterator.createCopy();
        int[] band = context.band;
        band[0] = x;
        band[1] = y;
        band[2] = x + w;
        band[3] = y + h;
        if (atile == null) {
            int size = w * h;
            atile = context.tile;
            if (atile != null && atile.length < size) {
                atile = null;
            }
            if (atile == null) {
                atile = new byte[size];
                context.tile = atile;
            }
            offset = 0;
            tsize = w;
            fillTile(ri, atile, offset, tsize, band);
        } else {
            eraseTile(ri, atile, offset, tsize, band);
        }

        if (band[2] > band[0] && band[3] > band[1]) {
            offset += (band[1] - y) * tsize + (band[0] - x);
            outpipe.renderPathTile(context.outcontext,
                                   atile, offset, tsize,
                                   band[0], band[1],
                                   band[2] - band[0],
                                   band[3] - band[1]);
        }
    }

    public native void fillTile(RegionIterator ri,
                                byte[] alpha, int offset, int tsize,
                                int[] band);

    public native void eraseTile(RegionIterator ri,
                                 byte[] alpha, int offset, int tsize,
                                 int[] band);

    public void skipTile(Object ctx, int x, int y) {
        SCRcontext context = (SCRcontext) ctx;
        outpipe.skipTile(context.outcontext, x, y);
    }

    public void endSequence(Object ctx) {
        SCRcontext context = (SCRcontext) ctx;
        outpipe.endSequence(context.outcontext);
    }
}
