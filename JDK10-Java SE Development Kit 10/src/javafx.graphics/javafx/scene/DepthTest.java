/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene;

/**
 * This enum defines the possible states for the depthTest flag in node.
 *
 * Note that this is a conditional feature. See
 * {@link javafx.application.ConditionalFeature#SCENE3D ConditionalFeature.SCENE3D}
 * for more information.
 * @since JavaFX 2.0
 */
public enum DepthTest {
    /**
     * Specifies that depth testing is disabled.
     */
    DISABLE,

    /**
     * Specifies that depth testing is enabled.
     */
    ENABLE,

    /**
     * Specifies that the depth testing state is inherited from the parent.
     */
    INHERIT
}
