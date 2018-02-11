/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.text;

/**
 * The {@code FontSmoothingType} enum is used to specify the preferred
 * mechanism used to smooth the edges of fonts for on-screen text.
 * @since JavaFX 2.1
 */

public enum FontSmoothingType {

    /**
     * Specifies the default gray scale smoothing, which is most
     * suitable for graphics and animation uses.
     */
    GRAY,

   /**
     * Specifies sub-pixel LCD text, which utilises characteristics
     * of digital LCD display panels to achieve increased pixel
     * resolution. This mode is generally appropriate where the
     * important factor is legibility of static text, particularly
     * at small sizes.
     * <p>
     * A request for LCD text is a 'hint', since the implementation
     * may need to ignore it under conditions such as compositing modes
     * which do not support it. It follow that where LCD text is important
     * that the application should avoid use of effects, transparency etc.
     */
    LCD

}
