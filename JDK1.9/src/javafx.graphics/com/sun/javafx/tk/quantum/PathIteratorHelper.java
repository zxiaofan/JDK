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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sun.javafx.tk.quantum;

import com.sun.javafx.geom.PathIterator;

class PathIteratorHelper {
    public static final class Struct {
        float f0, f1, f2, f3, f4, f5;
    }

    private PathIterator itr;
    private float[] f = new float[6];

    public PathIteratorHelper(PathIterator itr) {
        this.itr = itr;
    }

    /**
     * Returns the winding rule for determining the interior of the
     * path.
     */
    public int getWindingRule() {
        return itr.getWindingRule();
    }

    /**
     * Tests if the iteration is complete.
     * @return <code>true</code> if all the segments have
     * been read; <code>false</code> otherwise.
     */
    public boolean isDone() {
        return itr.isDone();
    }

    /**
     * Moves the iterator to the next segment of the path forwards
     * along the primary direction of traversal as long as there are
     * more points in that direction.
     */
    public void next() {
        itr.next();
    }

    /**
     * Returns the coordinates and type of the current path segment in
     * the iteration.
     * The return value is the path-segment type:
     * SEG_MOVETO, SEG_LINETO, SEG_QUADTO, SEG_CUBICTO, or SEG_CLOSE.
     * A float array of length 6 must be passed in and can be used to
     * store the coordinates of the point(s).
     * Each point is stored as a pair of float x,y coordinates.
     * SEG_MOVETO and SEG_LINETO types returns one point,
     * SEG_QUADTO returns two points,
     * SEG_CUBICTO returns 3 points
     * and SEG_CLOSE does not return any points.
     * @param coords an array that holds the data returned from
     * this method
     * @return the path-segment type of the current path segment.
     * @see #SEG_MOVETO
     * @see #SEG_LINETO
     * @see #SEG_QUADTO
     * @see #SEG_CUBICTO
     * @see #SEG_CLOSE
     */
    public int currentSegment(Struct struct) {
        int ret = itr.currentSegment(f);
        struct.f0 = f[0];
        struct.f1 = f[1];
        struct.f2 = f[2];
        struct.f3 = f[3];
        struct.f4 = f[4];
        struct.f5 = f[5];
        return ret;
    }
}
