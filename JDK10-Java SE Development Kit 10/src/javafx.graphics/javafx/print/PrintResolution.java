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

package javafx.print;

/**
 * Class to represent a supported device resolution of a printer in
 * the feed and crossfeed directionsin dots-per-inch (DPI).
 * When printing in a portrait orientation
 * cross feed direction is usually x/horizontal resolution, and
 * feed direction is usually y/horizontal resolution.
 * On most printers these are the same value, but it is possuble
 * for them to be different.
 * @since JavaFX 8.0
 */

public final class PrintResolution {

    private int cfRes;
    private int fRes;

    /**
     * Represents the dots-per-inch (DPI) resolution of a printer device.
     * When printing in a portrait orientation
     * cross feed direction is usually x/horizontal resolution, and
     * feed direction is usually y/horizontal resolution.
     * On most printers these are the same value, but rarely they may be
     * different.
     * @param crossFeedResolution - resolution across the paper feed direction.
     * @param feedResolution - resolution in the paper feed direction.
     * @throws IllegalArgumentException if the values are not greater
     * than zero.
     */
     PrintResolution(int crossFeedResolution, int feedResolution)
        throws IllegalArgumentException
    {
        if (crossFeedResolution <= 0 || feedResolution <= 0) {
            throw new IllegalArgumentException("Values must be positive");
        }
        cfRes = crossFeedResolution;
        fRes  = feedResolution;
    }

    /**
     * Returns the resolution in dpi. across the paper feed direction.
     * @return cross feed resolution.
     */
    public int getCrossFeedResolution() {
        return cfRes;
    }

    /**
     * Returns the resolution in dpi. in the paper feed direction.
     * @return feed resolution.
     */
    public int getFeedResolution() {
        return fRes;
    }

    @Override
    public boolean equals(Object o) {
        try {
            PrintResolution other = (PrintResolution)o;
            return this.cfRes == other.cfRes && this.fRes == other.fRes;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return cfRes << 16 | fRes;
    }

    @Override
    public String toString() {
        return "Feed res=" + fRes + "dpi. Cross Feed res=" + cfRes + "dpi.";
    }

}
