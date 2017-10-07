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

import com.sun.prism.Image;
import com.sun.prism.ResourceFactory;
import com.sun.prism.Texture;

/*
 * This class represents Compound Image with Cached textures
 */

public class CachingCompoundImage extends CompoundImage {

    public CachingCompoundImage(Image image, int maxSize) {
        super(image, maxSize);
    }

    @Override
    public Texture getTile(int x, int y, ResourceFactory factory) {
        return factory.getCachedTexture(tiles[x + y*uSections],
                                        Texture.WrapMode.CLAMP_TO_EDGE);
    }
}
