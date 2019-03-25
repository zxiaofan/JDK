/*
 * Copyright (c) 2005, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

/**
 * Interface used by Swing to make copies from the Swing back buffer
 * more optimal when using BufferStrategy; no need to copy the entire
 * buffer when only a small sub-region has changed.
 * @see javax.swing.BufferStrategyPaintManager
 *
 */
public interface SubRegionShowable {
    /**
     * Shows the specific subregion.
     */
    public void show(int x1, int y1, int x2, int y2);

    /**
     * Shows the specified region if the buffer is not lost and the dimensions
     * of the back-buffer match those of the component.
     *
     * @return true if successful
     */
    // NOTE: this is invoked by swing on the toolkit thread!
    public boolean showIfNotLost(int x1, int y1, int x2, int y2);
}
