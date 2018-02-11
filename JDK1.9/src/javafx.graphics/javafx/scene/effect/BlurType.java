/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.effect;

/**
 * Represents the type of blur algorithm that is used to soften
 * a {@code Shadow} effect.
 * @since JavaFX 2.0
 */
public enum BlurType {

    /**
     * A single pass of a box filter is used to blur the shadow.
     */
    ONE_PASS_BOX,

    /**
     * Two passes of a box filter are used to blur the shadow for a slightly
     * smoother effect.
     */
    TWO_PASS_BOX,

    /**
     * Three passes of a box filter are used to blur the shadow for an
     * effect that is almost as smooth as a Gaussian filter.
     */
    THREE_PASS_BOX,

    /**
     * A Gaussian blur kernel is used to blur the shadow with very high
     * quality.
     */
    GAUSSIAN,

}
