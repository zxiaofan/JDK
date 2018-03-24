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

package com.sun.prism.image;

import com.sun.prism.*;

public class CompoundTexture extends CompoundImage implements GraphicsResource {

    protected Texture texTiles[];

    public CompoundTexture(Image image, int maxSize) {
        super(image, maxSize);
        texTiles = new Texture[tiles.length];
    }

    @Override
    public Texture getTile(int x, int y, ResourceFactory factory) {
        int idx = x + y*uSections;
        Texture tex = texTiles[idx];
        if (tex != null) {
            tex.lock();
            if (tex.isSurfaceLost()) {
                texTiles[idx] = tex = null;
            }
        }
        if (tex == null) {
            tex = factory.createTexture(tiles[idx],
                                        Texture.Usage.STATIC,
                                        Texture.WrapMode.CLAMP_TO_EDGE);
            texTiles[idx] = tex;
        }
        return tex;
    }

    @Override
    public void dispose() {
        for (int i = 0; i != texTiles.length; ++i) {
            if (texTiles[i] != null) {
                texTiles[i].dispose();
                texTiles[i] = null;
            }
        }
    }

}
