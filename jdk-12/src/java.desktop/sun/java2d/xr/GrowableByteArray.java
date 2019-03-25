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

import java.util.*;

/**
 * Growable int array, designed to allow subclasses to emulate
 * the behaviour of value types.
 *
 * @author Clemens Eisserer
 */

public class GrowableByteArray
{

        byte[] array;
        int size;
        int cellSize;

        public GrowableByteArray(int cellSize, int initialSize)
        {
                array = new byte[initialSize];
                size = 0;
                this.cellSize = cellSize;
        }

        private int getNextCellIndex()
        {
                int oldSize = size;
                size += cellSize;

                if (size >= array.length)
                {
                        growArray();
                }

                return oldSize;
        }

        /**
         * @return a direct reference to the backing array.
         */
        public byte[] getArray()
        {
                return array;
        }

        /**
         * @return a copy of the backing array.
         */
        public byte[] getSizedArray()
        {
                return Arrays.copyOf(array, getSize());
        }

        public final int getByte(int index)
        {
                return array[getCellIndex(index)];
        }

        /**
         * Returns the index of the next free cell,
         * and grows the backing arrays if required.
         */
        public final int getNextIndex()
        {
                return getNextCellIndex() / cellSize;
        }

        protected final int getCellIndex(int cellIndex)
        {
                return cellSize * cellIndex;
        }

        public final void addByte(byte i)
        {
            int nextIndex = getNextIndex();
            array[nextIndex] = i;
        }

        /**
         * @return The number of stored cells.
         */
        public final int getSize()
        {
                return size / cellSize;
        }

        public void clear()
        {
                size = 0;
        }

        protected void growArray()
        {
                int newSize = Math.max(array.length * 2, 10);
                byte[] oldArray = array;
                array = new byte[newSize];

                System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        }

}
