/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.pipe;


/**
 * This class defines the API for iterating through the bands
 * of a region object.
 */
public class RegionIterator {
    Region region;
    int curIndex;
    int numXbands;

    RegionIterator(Region r) {
        region = r;
    }

    /**
     * Returns a new RegionIterator object representing the same
     * iteration state as this object to allow multiple iteration
     * branches from the current position.
     */
    public RegionIterator createCopy() {
        RegionIterator r = new RegionIterator(region);
        r.curIndex = this.curIndex;
        r.numXbands = this.numXbands;
        return r;
    }

    /**
     * Copies the iteration state from this RegionIterator object
     * into another RegionIterator object to allow multiple iteration
     * branches from the current position.
     */
    public void copyStateFrom(RegionIterator ri) {
        if (this.region != ri.region) {
            throw new InternalError("region mismatch");
        }
        this.curIndex = ri.curIndex;
        this.numXbands = ri.numXbands;
    }

    /**
     * Moves the iteration state to the beginning of the next
     * Y range in the region returning true if one is found
     * and recording the low and high Y coordinates of the
     * range in the array at locations 1 and 3 respectively.
     */
    public boolean nextYRange(int[] range) {
        curIndex += numXbands * 2;
        numXbands = 0;
        if (curIndex >= region.endIndex) {
            return false;
        }
        range[1] = region.bands[curIndex++];
        range[3] = region.bands[curIndex++];
        numXbands = region.bands[curIndex++];
        return true;
    }

    /**
     * Moves the iteration state to the beginning of the next
     * X band in the current Y range returning true if one is
     * found and recording the low and high X coordinates of
     * the range in the array at locations 0 and 2 respectively.
     */
    public boolean nextXBand(int[] range) {
        if (numXbands <= 0) {
            return false;
        }
        numXbands--;
        range[0] = region.bands[curIndex++];
        range[2] = region.bands[curIndex++];
        return true;
    }
}
