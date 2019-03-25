/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.xr;

/**
 * Class to efficiently store rectangles.
 *
 * @author Clemens Eisserer
 */
public class GrowablePointArray extends GrowableIntArray
{

        private static final int POINT_SIZE = 2;

        public GrowablePointArray(int initialSize)
        {
                super(POINT_SIZE, initialSize);
        }

        public final int getX(int index)
        {
                return array[getCellIndex(index)];
        }

        public final int getY(int index)
        {
                return array[getCellIndex(index) + 1];
        }

        public final void setX(int index, int x)
        {
                array[getCellIndex(index)] = x;
        }

        public final void setY(int index, int y)
        {
                array[getCellIndex(index) + 1] = y;
        }
}
