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

package javafx.scene.shape;

/**
 * {@code ArcType} specifies the closure type for {@link Arc} objects.
 * @since JavaFX 2.0
 */
public enum ArcType {

    /**
     * The closure type for an open arc with no path segments connecting
     * the two ends of the arc segment.
     */
    OPEN,

    /**
     * The closure type for an arc closed by drawing a straight line segment
     * from the start of the arc segment to the end of the arc segment.
     */
    CHORD,

    /**
     * The closure type for an arc closed by drawing straight line segments
     * from the start of the arc segment to the center of the full ellipse
     * and from that point to the end of the arc segment.
     */
    ROUND
}
