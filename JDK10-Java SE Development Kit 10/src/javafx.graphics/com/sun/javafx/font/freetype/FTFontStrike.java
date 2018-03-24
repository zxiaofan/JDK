/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font.freetype;

import com.sun.javafx.font.DisposerRecord;
import com.sun.javafx.font.FontStrikeDesc;
import com.sun.javafx.font.Glyph;
import com.sun.javafx.font.PrismFontFactory;
import com.sun.javafx.font.PrismFontStrike;
import com.sun.javafx.geom.Path2D;
import com.sun.javafx.geom.transform.BaseTransform;

class FTFontStrike extends PrismFontStrike<FTFontFile> {
    FT_Matrix matrix;

    protected FTFontStrike(FTFontFile fontResource, float size,
                              BaseTransform tx, int aaMode,
                              FontStrikeDesc desc) {
        super(fontResource, size, tx, aaMode, desc);
        float maxDim = PrismFontFactory.getFontSizeLimit();
        if (tx.isTranslateOrIdentity()) {
            drawShapes = size > maxDim;
        } else {
            BaseTransform tx2d = getTransform();
            matrix = new FT_Matrix();
            /* Fixed 16.16 to int */
            matrix.xx = (int)( tx2d.getMxx() * 65536.0f);
            matrix.yx = (int)(-tx2d.getMyx() * 65536.0f); /*Inverted coordinates system */
            matrix.xy = (int)(-tx2d.getMxy() * 65536.0f); /*Inverted coordinates system */
            matrix.yy = (int)( tx2d.getMyy() * 65536.0f);

            if (Math.abs(tx2d.getMxx() * size) > maxDim ||
                Math.abs(tx2d.getMyx() * size) > maxDim ||
                Math.abs(tx2d.getMxy() * size) > maxDim ||
                Math.abs(tx2d.getMyy() * size) > maxDim)
            {
                drawShapes = true;
            }
        }
    }

    @Override
    protected DisposerRecord createDisposer(FontStrikeDesc desc) {
        return null;
    }

    @Override
    protected Glyph createGlyph(int glyphCode) {
        return new FTGlyph(this, glyphCode, drawShapes);
    }

    @Override
    protected Path2D createGlyphOutline(int glyphCode) {
        FTFontFile fontResource = getFontResource();
        return fontResource.createGlyphOutline(glyphCode, getSize());
    }

    void initGlyph(FTGlyph glyph) {
        FTFontFile fontResource = getFontResource();
        fontResource.initGlyph(glyph, this);
    }

}
