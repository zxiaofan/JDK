/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt.image;

/**
 * This class extends <code>DataBuffer</code> and stores data internally
 * in <code>double</code> form.
 *
 * @see DataBuffer
 * @since 1.4
 */

public final class DataBufferDouble extends DataBuffer {

    /** The array of data banks. */
    double bankdata[][];

    /** A reference to the default data bank. */
    double data[];

    /**
     * Constructs a <code>double</code>-based <code>DataBuffer</code>
     * with a specified size.
     *
     * @param size The number of elements in the <code>DataBuffer</code>.
     */
    public DataBufferDouble(int size) {
        super(TYPE_DOUBLE, size);
        data = new double[size];
        bankdata = new double[1][];
        bankdata[0] = data;
    }

    /**
     * Constructs a <code>double</code>-based <code>DataBuffer</code>
     * with a specified number of banks, all of which are of a
     * specified size.
     *
     * @param size The number of elements in each bank of the
     *        <code>DataBuffer</code>.
     * @param numBanks The number of banks in the <code>DataBuffer</code>.
     */
    public DataBufferDouble(int size, int numBanks) {
        super(TYPE_DOUBLE, size, numBanks);
        bankdata = new double[numBanks][];
        for (int i= 0; i < numBanks; i++) {
            bankdata[i] = new double[size];
        }
        data = bankdata[0];
    }

    /**
     * Constructs a <code>double</code>-based <code>DataBuffer</code>
     * with the specified data array.  Only the first
     * <code>size</code> elements are available for use by this
     * <code>DataBuffer</code>.  The array must be large enough to
     * hold <code>size</code> elements.
     *
     * @param dataArray An array of <code>double</code>s to be used as the
     *                  first and only bank of this <code>DataBuffer</code>.
     * @param size The number of elements of the array to be used.
     */
    public DataBufferDouble(double dataArray[], int size) {
        super(TYPE_DOUBLE, size);
        data = dataArray;
        bankdata = new double[1][];
        bankdata[0] = data;
    }

    /**
     * Constructs a <code>double</code>-based <code>DataBuffer</code>
     * with the specified data array.  Only the elements between
     * <code>offset</code> and <code>offset + size - 1</code> are
     * available for use by this <code>DataBuffer</code>.  The array
     * must be large enough to hold <code>offset + size</code> elements.
     *
     * @param dataArray An array of <code>double</code>s to be used as the
     *                  first and only bank of this <code>DataBuffer</code>.
     * @param size The number of elements of the array to be used.
     * @param offset The offset of the first element of the array
     *               that will be used.
     */
    public DataBufferDouble(double dataArray[], int size, int offset) {
        super(TYPE_DOUBLE, size, 1, offset);
        data = dataArray;
        bankdata = new double[1][];
        bankdata[0] = data;
    }

    /**
     * Constructs a <code>double</code>-based <code>DataBuffer</code>
     * with the specified data arrays.  Only the first
     * <code>size</code> elements of each array are available for use
     * by this <code>DataBuffer</code>.  The number of banks will be
     * equal <code>to dataArray.length</code>.
     *
     * @param dataArray An array of arrays of <code>double</code>s to be
     *        used as the banks of this <code>DataBuffer</code>.
     * @param size The number of elements of each array to be used.
     */
    public DataBufferDouble(double dataArray[][], int size) {
        super(TYPE_DOUBLE, size, dataArray.length);
        bankdata = (double[][]) dataArray.clone();
        data = bankdata[0];
    }

    /**
     * Constructs a <code>double</code>-based <code>DataBuffer</code>
     * with the specified data arrays, size, and per-bank offsets.
     * The number of banks is equal to dataArray.length.  Each array
     * must be at least as large as <code>size</code> plus the
     * corresponding offset.  There must be an entry in the
     * <code>offsets</code> array for each data array.
     *
     * @param dataArray An array of arrays of <code>double</code>s to be
     *        used as the banks of this <code>DataBuffer</code>.
     * @param size The number of elements of each array to be used.
     * @param offsets An array of integer offsets, one for each bank.
     */
    public DataBufferDouble(double dataArray[][], int size, int offsets[]) {
        super(TYPE_DOUBLE, size, dataArray.length, offsets);
        bankdata = (double[][]) dataArray.clone();
        data = bankdata[0];
    }

    /** 
     * Returns the default (first) <code>double</code> data array. 
     * @return the first double data array.
     */
    public double[] getData() {
        return data;
    }

    /** 
     * Returns the data array for the specified bank. 
     * @param bank the data array
     * @return the data array specified by <code>bank</code>.
     */
    public double[] getData(int bank) {
        return bankdata[bank];
    }

    /** 
     * Returns the data array for all banks. 
     * @return all data arrays from this data buffer.
     */
    public double[][] getBankData() {
        return (double[][]) bankdata.clone();
    }
    
    /**
     * Returns the requested data array element from the first
     * (default) bank as an <code>int</code>.
     *
     * @param i The desired data array element.
     * @return The data entry as an <code>int</code>.
     * @see #setElem(int, int)
     * @see #setElem(int, int, int)
     */
    public int getElem(int i) {
        return (int)(data[i+offset]);
    }

    /**
     * Returns the requested data array element from the specified
     * bank as an <code>int</code>.
     *
     * @param bank The bank number.
     * @param i The desired data array element.
     *
     * @return The data entry as an <code>int</code>.
     * @see #setElem(int, int)
     * @see #setElem(int, int, int)
     */
    public int getElem(int bank, int i) {
        return (int)(bankdata[bank][i+offsets[bank]]);
    }

    /**
     * Sets the requested data array element in the first (default)
     * bank to the given <code>int</code>.
     *
     * @param i The desired data array element.
     * @param val The value to be set.
     * @see #getElem(int)
     * @see #getElem(int, int)
     */
    public void setElem(int i, int val) {
        data[i+offset] = (double)val;
    }

    /**
     * Sets the requested data array element in the specified bank
     * to the given <code>int</code>.
     *
     * @param bank The bank number.
     * @param i The desired data array element.
     * @param val The value to be set.
     * @see #getElem(int)
     * @see #getElem(int, int)
     */
    public void setElem(int bank, int i, int val) {
        bankdata[bank][i+offsets[bank]] = (double)val;
    }

    /**
     * Returns the requested data array element from the first
     * (default) bank as a <code>float</code>.
     *
     * @param i The desired data array element.
     *
     * @return The data entry as a <code>float</code>.
     * @see #setElemFloat(int, float)
     * @see #setElemFloat(int, int, float)
     */
    public float getElemFloat(int i) {
        return (float)data[i+offset];
    }
 
    /**
     * Returns the requested data array element from the specified
     * bank as a <code>float</code>.
     *
     * @param bank The bank number.
     * @param i The desired data array element.
     *
     * @return The data entry as a <code>float</code>.
     * @see #setElemFloat(int, float)
     * @see #setElemFloat(int, int, float)
     */
    public float getElemFloat(int bank, int i) {
        return (float)bankdata[bank][i+offsets[bank]];
    }
 
    /**
     * Sets the requested data array element in the first (default)
     * bank to the given <code>float</code>.
     *
     * @param i The desired data array element.
     * @param val The value to be set.
     * @see #getElemFloat(int)
     * @see #getElemFloat(int, int)
     */
    public void setElemFloat(int i, float val) {
        data[i+offset] = (double)val;
    }
 
    /**
     * Sets the requested data array element in the specified bank to
     * the given <code>float</code>.
     *
     * @param bank The bank number.
     * @param i The desired data array element.
     * @param val The value to be set.
     * @see #getElemFloat(int)       
     * @see #getElemFloat(int, int)
     */
    public void setElemFloat(int bank, int i, float val) {
        bankdata[bank][i+offsets[bank]] = (double)val;
    }

    /**
     * Returns the requested data array element from the first
     * (default) bank as a <code>double</code>.
     *
     * @param i The desired data array element.
     *
     * @return The data entry as a <code>double</code>.
     * @see #setElemDouble(int, double)  
     * @see #setElemDouble(int, int, double)
     */
    public double getElemDouble(int i) {
        return data[i+offset];
    }
 
    /**
     * Returns the requested data array element from the specified
     * bank as a <code>double</code>.
     *
     * @param bank The bank number.
     * @param i The desired data array element.
     *
     * @return The data entry as a <code>double</code>.
     * @see #setElemDouble(int, double)
     * @see #setElemDouble(int, int, double)
     */
    public double getElemDouble(int bank, int i) {
        return bankdata[bank][i+offsets[bank]];
    }
 
    /**
     * Sets the requested data array element in the first (default)
     * bank to the given <code>double</code>.
     *
     * @param i The desired data array element.
     * @param val The value to be set.
     * @see #getElemDouble(int)
     * @see #getElemDouble(int, int)
     */
    public void setElemDouble(int i, double val) {
        data[i+offset] = val;
    }
 
    /**
     * Sets the requested data array element in the specified bank to
     * the given <code>double</code>.
     *
     * @param bank The bank number.
     * @param i The desired data array element.
     * @param val The value to be set.
     * @see #getElemDouble(int)        
     * @see #getElemDouble(int, int)
     */
    public void setElemDouble(int bank, int i, double val) {
        bankdata[bank][i+offsets[bank]] = val;
    }
}
