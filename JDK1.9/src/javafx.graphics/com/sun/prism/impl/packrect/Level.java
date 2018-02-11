/*
 * Copyright (c) 2006, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.impl.packrect;

import com.sun.javafx.geom.Rectangle;

class Level {
    int length;
    int size;
    private int sizeOffset;
    private int lengthOffset;

    Level(int length, int size, int sizeOffset) {
        this.length = length;
        this.size = size;
        this.sizeOffset = sizeOffset;
    }

    /**
     * Tries to add the given rectangle to this level.
     */
    boolean add(Rectangle rect, int x, int y, int requestedLength, int requestedSize, boolean vertical) {
        // See whether we can add at the end
        if (lengthOffset + requestedLength <= length && requestedSize <= size) {
            if (vertical) {
                rect.x = sizeOffset;
                rect.y = lengthOffset;
            } else {
                rect.x = lengthOffset;
                rect.y = sizeOffset;
            }
            lengthOffset += requestedLength;

            // this x,y location are external offsets and should not be flipped
            rect.x += x;
            rect.y += y;
            return true;
        }
        return false;
    }
}
