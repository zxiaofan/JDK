/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf;

import java.awt.Color;
import java.beans.ConstructorProperties;

/**
 * A subclass of Color that implements UIResource.  UI
 * classes that create colors should use this class.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @see javax.swing.plaf.UIResource
 * @author Hans Muller
 *
 */
@SuppressWarnings("serial") // Same-version serialization only
public class ColorUIResource extends Color implements UIResource
{
    /**
     * Constructs a {@code ColorUIResource}.
     * @param r the red component
     * @param g the green component
     * @param b the blue component
     */
    @ConstructorProperties({"red", "green", "blue"})
    public ColorUIResource(int r, int g, int b) {
        super(r, g, b);
    }

    /**
     * Constructs a {@code ColorUIResource}.
     * @param rgb the combined RGB components
     */
    public ColorUIResource(int rgb) {
        super(rgb);
    }

    /**
     * Constructs a {@code ColorUIResource}.
     * @param r the red component
     * @param g the green component
     * @param b the blue component
     */
    public ColorUIResource(float r, float g, float b) {
        super(r, g, b);
    }

    /**
     * Constructs a {@code ColorUIResource}.
     * @param c the color
     */
    public ColorUIResource(Color c) {
        super(c.getRGB(), (c.getRGB() & 0xFF000000) != 0xFF000000);
    }
}
