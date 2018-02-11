/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import com.sun.glass.ui.Size;

/**
 * Abstraction of a native cursor
 */
abstract class NativeCursor {

    /**
     * Is the cursor currently visible?
     */
    protected boolean isVisible = false;

    /**
     * Returns the preferred size of a native cursor.
     */
    abstract Size getBestSize();

    /**
     * Sets whether or not the cursor is visible. The implementation should set
     * the isVisible field. On success the isVisible field is set to the
     * visibility parameter.
     *
     * @param visibility the new setting for the cursor's visibility.
     */
    abstract void setVisibility(boolean visibility);

    /**
     * Queries whether or not the cursor is visible
     *
     * @return trueif the cursor is visible, false otherwise.
     */
    boolean getVisiblity() {
        return isVisible;
    }

    /**
     * Sets the cursor image
     *
     * @param cursorImage the cursor image, in BYTE_BGRA_PRE format
     */
    abstract void setImage(byte[] cursorImage);

    /**
     * Sets the location of the hot spot of the cursor on the screen
     *
     * @param x the new X location on the screen
     * @param y the new Y location on the screen
     */
    abstract void setLocation(int x, int y);

    /**
     * Sets the offset of the cursor's hot spot within the cursor image The hot
     * spot offsets default to 0, 0.
     *
     * @param hotspotX the X offset of the hot spot
     * @param hotspotY the Y offset of the hot spot.
     */
    abstract void setHotSpot(int hotspotX, int hotspotY);

    /**
     * Performs any necessary shutdown of the cursor infrastructure. Called only
     * once.
     */
    abstract void shutdown();
}
