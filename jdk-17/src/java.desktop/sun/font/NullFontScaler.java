/*
 * Copyright (c) 2007, 2011, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

class NullFontScaler extends FontScaler {
    NullFontScaler() {}

    public NullFontScaler(Font2D font, int indexInCollection,
        boolean supportsCJK, int filesize) {}

    StrikeMetrics getFontMetrics(long pScalerContext) {
        return new StrikeMetrics(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f,
                                 0.0f, 0.0f, 0.0f, 0.0f);
    }

    float getGlyphAdvance(long pScalerContext, int glyphCode) {
        return 0.0f;
    }

    void getGlyphMetrics(long pScalerContext, int glyphCode,
        Point2D.Float metrics) {
        metrics.x = 0;
        metrics.y = 0;
    }

    Rectangle2D.Float getGlyphOutlineBounds(long pContext, int glyphCode) {
        return new Rectangle2D.Float(0, 0, 0, 0);
    }

    GeneralPath getGlyphOutline(long pScalerContext, int glyphCode,
        float x, float y) {
        return new GeneralPath();
    }

    GeneralPath getGlyphVectorOutline(long pScalerContext, int[] glyphs,
        int numGlyphs, float x, float y) {
        return new GeneralPath();
    }

    long createScalerContext(double[] matrix, int aa,
        int fm, float boldness, float italic) {
        return getNullScalerContext();
    }

    void invalidateScalerContext(long pScalerContext) {
        //nothing to do
    }

    int getNumGlyphs() throws FontScalerException {
        return 1;
    }

    int getMissingGlyphCode() throws FontScalerException {
        return 0;
    }

    int getGlyphCode(char charCode) throws FontScalerException {
        return 0;
    }

    long getUnitsPerEm() {
        return 2048;
    }

    Point2D.Float getGlyphPoint(long pScalerContext,
                                int glyphCode, int ptNumber) {
        return null;
    }

    /* Ideally NullFontScaler should not have native code.
       However, at this moment we need these methods to be native because:
         - glyph cache code assumes null pointers to GlyphInfo structures
         - FileFontStrike needs native context
    */
    static native long getNullScalerContext();
    native long getGlyphImage(long pScalerContext, int glyphCode);
}
