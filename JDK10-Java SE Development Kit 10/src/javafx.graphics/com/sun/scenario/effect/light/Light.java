/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.light;

import com.sun.scenario.effect.Color4f;

/**
 * The abstract base class for all light implementations.
 */
public abstract class Light {

    /**
     * The light type.
     */
    public enum Type {
        /** Light is a {@code DistantLight}. */
        DISTANT,
        /** Light is a {@code PointLight}. */
        POINT,
        /** Light is a {@code SpotLight}. */
        SPOT
    }

    private final Type type;
    private Color4f color;

    /**
     * Package-private constructor.
     *
     * @param type the type of the light
     * @throws IllegalArgumentException if {@code color} is null
     */
    Light(Type type) {
        this(type, Color4f.WHITE);
    }

    /**
     * Package-private constructor.
     *
     * @param type the type of the light
     * @param color the color of the light
     * @throws IllegalArgumentException if {@code color} is null
     */
    Light(Type type, Color4f color) {
        if (type == null) {
            throw new InternalError("Light type must be non-null");
        }
        this.type = type;
        setColor(color);
    }

    /**
     * Returns the light {@code Type}, either {@code DISTANT}, {@code POINT},
     * or {@code SPOT}.
     *
     * @return the light type
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the light color.
     *
     * @return the light color
     */
    public Color4f getColor() {
        return color;
    }

    /**
     * Sets the light color.
     * <pre>
     *       Min: n/a
     *       Max: n/a
     *   Default: Color4f.WHITE
     *  Identity: n/a
     * </pre>
     *
     * @param color the light color
     * @throws IllegalArgumentException if {@code color} is null
     */
    public void setColor(Color4f color) {
        if (color == null) {
            throw new IllegalArgumentException("Color must be non-null");
        }
        this.color = color;
    }

    /**
     * Returns a float array containing the normalized {@code (x,y,z)}
     * position of this light source.
     *
     * @return the normalized position of this light source
     */
    public abstract float[] getNormalizedLightPosition();
}
