/*
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
 *
 */

/*
 *
 * (C) Copyright IBM Corp. 2003, All Rights Reserved
 *
 */

package sun.font;

import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

/**
 * Metrics from a font for layout of characters along a line
 * and layout of set of lines.
 * This and CoreMetrics replace what was previously a private internal class of Font
 */
public final class FontLineMetrics extends LineMetrics implements Cloneable {
    public int numchars; // mutated by Font
    public final CoreMetrics cm;
    public final FontRenderContext frc;

    public FontLineMetrics(int numchars, CoreMetrics cm, FontRenderContext frc) {
        this.numchars = numchars;
        this.cm = cm;
        this.frc = frc;
    }

    public int getNumChars() {
        return numchars;
    }

    public float getAscent() {
        return cm.ascent;
    }

    public float getDescent() {
        return cm.descent;
    }

    public float getLeading() {
        return cm.leading;
    }

    public float getHeight() {
        return cm.height;
    }

    public int getBaselineIndex() {
        return cm.baselineIndex;
    }

    public float[] getBaselineOffsets() {
        return cm.baselineOffsets.clone();
    }

    public float getStrikethroughOffset() {
        return cm.strikethroughOffset;
    }

    public float getStrikethroughThickness() {
        return cm.strikethroughThickness;
    }

    public float getUnderlineOffset() {
        return cm.underlineOffset;
    }

    public float getUnderlineThickness() {
        return cm.underlineThickness;
    }

    public int hashCode() {
        return cm.hashCode();
    }

    public boolean equals(Object rhs) {
        try {
            return cm.equals(((FontLineMetrics)rhs).cm);
        }
        catch (ClassCastException e) {
            return false;
        }
    }

    public Object clone() {
        // frc, cm do not need deep clone
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
