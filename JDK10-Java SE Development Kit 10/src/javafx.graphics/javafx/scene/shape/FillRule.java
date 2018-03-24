/*
 * Copyright (c) 2008, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.shape;

/**
 * The fill rule for determining the interior of the path.
 * @since JavaFX 2.0
 */
public enum FillRule {

    /**
     * Defines an even-odd filling rule for determining the interior of a path.
     *
     * The even-odd rule specifies that a point lies inside the path if a ray
     * drawn in any direction from that point to infinity is crossed by path
     * segments an odd number of times.
     * <p> <img src="doc-files/fillrule-evenodd.png" alt="A visual illustration
     * of how EVEN_ODD works"> </p>
     */
    EVEN_ODD, //(GeneralPath.WIND_EVEN_ODD),

    /**
     * Defines a non-zero filling rule for determining the interior of a path.
     *
     * The non-zero rule specifies that a point lies inside the path if a ray
     * drawn in any direction from that point to infinity is crossed by path
     * segments a different number of times in the counter-clockwise direction
     * than the clockwise direction.
     * <p> <img src="doc-files/fillrule-nonzero.png" alt="A visual illustration
     * of how NON_ZERO works"> </p>
     */
    NON_ZERO //(GeneralPath.WIND_NON_ZERO)
}
