/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.font;

import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;

public abstract class FontStrike {


    protected FontStrikeDisposer disposer;
    protected FontStrikeDesc desc;
    protected StrikeMetrics strikeMetrics;
    protected boolean algoStyle = false;
    protected float boldness = 1f;
    protected float italic = 0f;
    /*
     * lastLookupTime is updated by Font2D.getStrike and can be used to
     * choose strikes that have not been newly referenced for purging when
     * memory usage gets too high. Active strikes will never be purged
     * because purging is via GC of WeakReferences.
     */
    //protected long lastlookupTime/* = System.currentTimeMillis()*/;

    public abstract int getNumGlyphs();

    abstract StrikeMetrics getFontMetrics();

    abstract void getGlyphImagePtrs(int[] glyphCodes, long[] images,int  len);

    abstract long getGlyphImagePtr(int glyphcode);

    // pt, result in device space
    abstract void getGlyphImageBounds(int glyphcode,
                                      Point2D.Float pt,
                                      Rectangle result);

    abstract Point2D.Float getGlyphMetrics(int glyphcode);

    abstract Point2D.Float getCharMetrics(char ch);

    abstract float getGlyphAdvance(int glyphCode);

    abstract float getCodePointAdvance(int cp);

    abstract Rectangle2D.Float getGlyphOutlineBounds(int glyphCode);

    abstract GeneralPath
        getGlyphOutline(int glyphCode, float x, float y);

    abstract GeneralPath
        getGlyphVectorOutline(int[] glyphs, float x, float y);


}
