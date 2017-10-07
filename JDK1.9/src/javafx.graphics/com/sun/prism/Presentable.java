/*
 * Copyright (c) 2009, 2016, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.geom.Rectangle;

public interface Presentable extends RenderTarget {
    /**
     * Locks any underlying resources needed for a createGraphics/prepare/present
     * sequence and returns a boolean indicating if the presentable needs to be
     * recreated.
     * If the method returns true and the Presentable implements
     * {@link GraphicsResource} then its {@code dispose()} method will be
     * called prior to recreating a new {@code Presentable} object and
     * so no resource should need to be locked in that case.
     * The resources will be unlocked in either {@link #prepare()} or
     * {@link #present()}.
     *
     * @param pState The presentation state for the upcoming pulse
     * @return true if the caller should recreate the Presentable
     */
    public boolean lockResources(PresentableState pState);

    /**
     * display the indicated region to the user.
     * @param dirtyregion display region or null for full area
     * @return true if the provided region was successfully displayed,
     * false otherwise
     */
    public boolean prepare(Rectangle dirtyregion);

    /**
     * present the prepared region to the user.
     */
    public boolean present();

    public float getPixelScaleFactorX();
    public float getPixelScaleFactorY();
}
