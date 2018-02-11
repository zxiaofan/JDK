/*
 * Copyright (c) 2008, 2016, Oracle and/or its affiliates. All rights reserved.
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

package javafx.stage;

/**
 * This enum defines the possible styles for a {@code Stage}.
 * @since JavaFX 2.0
 */
public enum StageStyle {

    /**
     * Defines a normal {@code Stage} style with a solid white background and platform decorations.
     */
    DECORATED,

    /**
     * Defines a {@code Stage} style with a solid white background and no decorations.
     */
    UNDECORATED,

    /**
     * Defines a {@code Stage} style with a transparent background and no decorations.
     * This is a conditional feature; to check if it is supported use
     * {@link javafx.application.Platform#isSupported(javafx.application.ConditionalFeature)}.
     * If the feature is not supported by the platform, this style downgrades
     * to {@code StageStyle.UNDECORATED}
     */
    TRANSPARENT,

    /**
     * Defines a {@code Stage} style with a solid white background and minimal
     * platform decorations used for a utility window.
     */
    UTILITY,

    /**
     * Defines a {@code Stage} style with platform decorations and eliminates the border between
     * client area and decorations. The client area background is unified with the decorations.
     * This is a conditional feature, to check if it is supported see
     * {@link javafx.application.Platform#isSupported(javafx.application.ConditionalFeature)}.
     * If the feature is not supported by the platform, this style downgrades to {@code StageStyle.DECORATED}
     * <p>                                                   `
     * NOTE: To see the effect the {@code Scene} covering the {@code Stage} should have {@code Color.TRANSPARENT}
     * @since JavaFX 8.0
     */
    UNIFIED
}
