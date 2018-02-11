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

package com.sun.javafx.cursor;

public final class ImageCursorFrame extends CursorFrame {
    private final Object platformImage;
    private final double width;
    private final double height;
    private final double hotspotX;
    private final double hotspotY;

    public ImageCursorFrame(final Object platformImage,
                            final double width,
                            final double height,
                            final double hotspotX,
                            final double hotspotY) {
        this.platformImage = platformImage;
        this.width = width;
        this.height = height;
        this.hotspotX = hotspotX;
        this.hotspotY = hotspotY;
    }

    @Override
    public CursorType getCursorType() {
        return CursorType.IMAGE;
    }

    public Object getPlatformImage() {
        return platformImage;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getHotspotX() {
        return hotspotX;
    }

    public double getHotspotY() {
        return hotspotY;
    }
}
