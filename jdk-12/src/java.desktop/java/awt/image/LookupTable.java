/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.image;


/**
 * This abstract class defines a lookup table object.  ByteLookupTable
 * and ShortLookupTable are subclasses, which
 * contain byte and short data, respectively.  A lookup table
 * contains data arrays for one or more bands (or components) of an image
 * (for example, separate arrays for R, G, and B),
 * and it contains an offset which will be subtracted from the
 * input values before indexing into the arrays.  This allows an array
 * smaller than the native data size to be provided for a
 * constrained input.  If there is only one array in the lookup
 * table, it will be applied to all bands.  All arrays must be the
 * same size.
 *
 * @see ByteLookupTable
 * @see ShortLookupTable
 * @see LookupOp
 */
public abstract class LookupTable {

    /**
     * Constants
     */

    int  numComponents;
    int  offset;
    int  numEntries;

    /**
     * Constructs a new LookupTable from the number of components and an offset
     * into the lookup table.
     * @param offset the offset to subtract from input values before indexing
     *        into the data arrays for this {@code LookupTable}
     * @param numComponents the number of data arrays in this
     *        {@code LookupTable}
     * @throws IllegalArgumentException if {@code offset} is less than 0
     *         or if {@code numComponents} is less than 1
     */
    protected LookupTable(int offset, int numComponents) {
        if (offset < 0) {
            throw new
                IllegalArgumentException("Offset must be greater than 0");
        }
        if (numComponents < 1) {
            throw new IllegalArgumentException("Number of components must "+
                                               " be at least 1");
        }
        this.numComponents = numComponents;
        this.offset = offset;
    }

    /**
     * Returns the number of components in the lookup table.
     * @return the number of components in this {@code LookupTable}.
     */
    public int getNumComponents() {
        return numComponents;
    }

    /**
     * Returns the offset.
     * @return the offset of this {@code LookupTable}.
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Returns an {@code int} array of components for
     * one pixel.  The {@code dest} array contains the
     * result of the lookup and is returned.  If dest is
     * {@code null}, a new array is allocated.  The
     * source and destination can be equal.
     * @param src the source array of components of one pixel
     * @param dest the destination array of components for one pixel,
     *        translated with this {@code LookupTable}
     * @return an {@code int} array of components for one
     *         pixel.
     */
    public abstract int[] lookupPixel(int[] src, int[] dest);

}
