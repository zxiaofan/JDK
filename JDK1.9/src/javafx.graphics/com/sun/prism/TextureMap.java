/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism;

/**
 * A wrapper class to hold map related information for the PhongMaterial
 */
public class TextureMap {

    private final PhongMaterial.MapType type;
    private Image image;
    private Texture texture;
    private boolean dirty;

    public TextureMap(PhongMaterial.MapType type) {
        this.type = type;
    }

    public PhongMaterial.MapType getType() {
        return type;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
}
