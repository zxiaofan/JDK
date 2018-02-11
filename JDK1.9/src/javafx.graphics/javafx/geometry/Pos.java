/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.geometry;

import static javafx.geometry.HPos.LEFT;
import static javafx.geometry.HPos.RIGHT;
import static javafx.geometry.VPos.BASELINE;
import static javafx.geometry.VPos.BOTTOM;
import static javafx.geometry.VPos.TOP;

/**
 * A set of values for describing vertical and horizontal positioning and
 * alignment.
 *
 * @since JavaFX 2.0
 */
public enum Pos {

    /**
     * Represents positioning on the top vertically and on the left horizontally.
     */
    TOP_LEFT(TOP, LEFT),

    /**
     * Represents positioning on the top vertically and on the center horizontally.
     */
    TOP_CENTER(TOP, HPos.CENTER),

    /**
     * Represents positioning on the top vertically and on the right horizontally.
     */
    TOP_RIGHT(TOP, RIGHT),

    /**
     * Represents positioning on the center vertically and on the left horizontally.
     */
    CENTER_LEFT(VPos.CENTER, LEFT),

    /**
     * Represents positioning on the center both vertically and horizontally.
     */
    CENTER(VPos.CENTER, HPos.CENTER),

    /**
     * Represents positioning on the center vertically and on the right horizontally.
     */
    CENTER_RIGHT(VPos.CENTER, RIGHT),

    /**
     * Represents positioning on the bottom vertically and on the left horizontally.
     */
    BOTTOM_LEFT(BOTTOM, LEFT),

    /**
     * Represents positioning on the bottom vertically and on the center horizontally.
     */
    BOTTOM_CENTER(BOTTOM, HPos.CENTER),

    /**
     * Represents positioning on the bottom vertically and on the right horizontally.
     */
    BOTTOM_RIGHT(BOTTOM, RIGHT),

    /**
     * Represents positioning on the baseline vertically and on the left horizontally.
     */
    BASELINE_LEFT(BASELINE, LEFT),

    /**
     * Represents positioning on the baseline vertically and on the center horizontally.
     */
    BASELINE_CENTER(BASELINE, HPos.CENTER),

    /**
     * Represents positioning on the baseline vertically and on the right horizontally.
     */
    BASELINE_RIGHT(BASELINE, RIGHT);

    private final VPos vpos;
    private final HPos hpos;

    private Pos(VPos vpos, HPos hpos) {
        this.vpos = vpos;
        this.hpos = hpos;
    }

    /**
     * Returns the vertical positioning/alignment.
     * @return the vertical positioning/alignment.
     */
    public VPos getVpos() {
        return vpos;
    }

    /**
     * Returns the horizontal positioning/alignment.
     * @return the horizontal positioning/alignment.
     */
    public HPos getHpos() {
        return hpos;
    }
}
