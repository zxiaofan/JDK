/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/* ****************************************************************
 ******************************************************************
 ******************************************************************
 *** COPYRIGHT (c) Eastman Kodak Company, 1997
 *** As  an unpublished  work pursuant to Title 17 of the United
 *** States Code.  All rights reserved.
 ******************************************************************
 ******************************************************************
 ******************************************************************/

package java.awt.image;

/**
 * This class extends <CODE>DataBuffer</CODE> and stores data internally as
 * shorts.  Values stored in the short array(s) of this <CODE>DataBuffer</CODE>
 * are treated as unsigned values.
 */


public final class DataBufferUShort extends DataBuffer
{
    /** The default data bank. */
    short data[];

    /** All data banks */
    short bankdata[][];

    /**
     * Constructs an unsigned-short based <CODE>DataBuffer</CODE> with a single bank and the
     * specified size.
     *
     * @param size The size of the <CODE>DataBuffer</CODE>.
     */
    public DataBufferUShort(int size) {
        super(TYPE_USHORT,size);
        data = new short[size];
        bankdata = new short[1][];
        bankdata[0] = data;
    }

    /**
     * Constructs an unsigned-short based <CODE>DataBuffer</CODE> with the specified number of
     * banks, all of which are the specified size.
     *
     * @param size The size of the banks in the <CODE>DataBuffer</CODE>.
     * @param numBanks The number of banks in the a<CODE>DataBuffer</CODE>.
    */
    public DataBufferUShort(int size, int numBanks) {
        super(TYPE_USHORT,size,numBanks);
        bankdata = new short[numBanks][];
        for (int i= 0; i < numBanks; i++) {
            bankdata[i] = new short[size];
        }
        data = bankdata[0];
    }

    /**
     * Constructs an unsigned-short based <CODE>DataBuffer</CODE> with a single bank
     * using the specified array.
     * Only the first <CODE>size</CODE> elements should be used by accessors of
     * this <CODE>DataBuffer</CODE>.  <CODE>dataArray</CODE> must be large enough to
     * hold <CODE>size</CODE> elements.
     *
     * @param dataArray The unsigned-short array for the <CODE>DataBuffer</CODE>.
     * @param size The size of the <CODE>DataBuffer</CODE> bank.
     */
    public DataBufferUShort(short dataArray[], int size) {
        super(TYPE_USHORT,size);
        if (dataArray == null) {
            throw new NullPointerException("dataArray is null");
        }
        data = dataArray;
        bankdata = new short[1][];
        bankdata[0] = data;
    }

    /**
     * Constructs an unsigned-short based <CODE>DataBuffer</CODE> with a single bank
     * using the specified array, size, and offset.  <CODE>dataArray</CODE> must have at
     * least <CODE>offset</CODE> + <CODE>size</CODE> elements.  Only elements 
     * <CODE>offset</CODE> through <CODE>offset</CODE> + <CODE>size</CODE> - 1 should 
     * be used by accessors of this <CODE>DataBuffer</CODE>.
     *
     * @param dataArray The unsigned-short array for the <CODE>DataBuffer</CODE>.
     * @param size The size of the <CODE>DataBuffer</CODE> bank.
     * @param offset The offset into the <CODE>dataArray</CODE>.
     */
    public DataBufferUShort(short dataArray[], int size, int offset) {
        super(TYPE_USHORT,size,1,offset);
        if (dataArray == null) {
            throw new NullPointerException("dataArray is null");
        }
        if ((size+offset) > dataArray.length) {
            throw new IllegalArgumentException("Length of dataArray is less "+
                                               " than size+offset.");
        }
        data = dataArray;
        bankdata = new short[1][];
        bankdata[0] = data;
    }

    /**
     * Constructs an unsigned-short based <CODE>DataBuffer</CODE> with the specified arrays.
     * The number of banks will be equal to <CODE>dataArray.length</CODE>.
     * Only the first <CODE>size</CODE> elements of each array should be used by
     * accessors of this <CODE>DataBuffer</CODE>.
	 *
     * @param dataArray The unsigned-short arrays for the <CODE>DataBuffer</CODE>.
     * @param size The size of the banks in the <CODE>DataBuffer</CODE>.
     */
    public DataBufferUShort(short dataArray[][], int size) {
        super(TYPE_USHORT,size,dataArray.length);
        if (dataArray == null) {
            throw new NullPointerException("dataArray is null");
        }
        for (int i=0; i < dataArray.length; i++) {
            if (dataArray[i] == null) {
                throw new NullPointerException("dataArray["+i+"] is null");
            }
        }
                
        bankdata = (short[][]) dataArray.clone();
        data = bankdata[0];
    }

    /**
     * Constructs an unsigned-short based <CODE>DataBuffer</CODE> with specified arrays,
     * size, and offsets.
     * The number of banks is equal to <CODE>dataArray.length</CODE>.  Each array must
     * be at least as large as <CODE>size</CODE> + the corresponding offset.   There must
     * be an entry in the offset array for each <CODE>dataArray</CODE> entry.  For each
     * bank, only elements <CODE>offset</CODE> through 
     * <CODE>offset</CODE> + <CODE>size</CODE> - 1 should be
     * used by accessors of this <CODE>DataBuffer</CODE>.
     *
     * @param dataArray The unsigned-short arrays for the <CODE>DataBuffer</CODE>.
     * @param size The size of the banks in the <CODE>DataBuffer</CODE>.
     * @param offsets The offsets into each array.
     */
    public DataBufferUShort(short dataArray[][], int size, int offsets[]) {
        super(TYPE_USHORT,size,dataArray.length,offsets);
        if (dataArray == null) {
            throw new NullPointerException("dataArray is null");
        }
        for (int i=0; i < dataArray.length; i++) {
            if (dataArray[i] == null) {
                throw new NullPointerException("dataArray["+i+"] is null");
            }
            if ((size+offsets[i]) > dataArray[i].length) {
                throw new IllegalArgumentException("Length of dataArray["+i+
                                                   "] is less than size+"+
                                                   "offsets["+i+"].");
            }
                                                  
        }
        bankdata = (short[][]) dataArray.clone();
        data = bankdata[0];
    }

    /** 
     * Returns the default (first) unsigned-short data array. 
     *    
     * @return The first unsigned-short data array.
     */
    public short[] getData() {
        return data;
    }

    /** 
     * Returns the data array for the specified bank.    
     *   
     * @param bank The bank whose data array you want to get. 
     * @return The data array for the specified bank.
     */
    public short[] getData(int bank) {
        return bankdata[bank];
    }

    /** 
     * Returns the data arrays for all banks. 
     * @return All of the data arrays.
     */
    public short[][] getBankData() {
        return (short[][]) bankdata.clone();
    }

    /**
     * Returns the requested data array element from the first (default) bank.
     * 
     * @param i The data array element you want to get.
     * @return The requested data array element as an integer.
     * @see #setElem(int, int)
     * @see #setElem(int, int, int)
     */
    public int getElem(int i) {
        return (int)(data[i+offset]&0xffff);
    }

    /**
     * Returns the requested data array element from the specified bank.
     * 
     * @param bank The bank from which you want to get a data array element.
     * @param i The data array element you want to get.
     * @return The requested data array element as an integer.
     * @see #setElem(int, int)
     * @see #setElem(int, int, int)
     */
    public int getElem(int bank, int i) {
        return (int)(bankdata[bank][i+offsets[bank]]&0xffff);
    }

    /**
     * Sets the requested data array element in the first (default) bank
     * to the specified value.
     *
     * @param i The data array element you want to set.
     * @param val The integer value to which you want to set the data array element.
     * @see #getElem(int)
     * @see #getElem(int, int)
     */
    public void setElem(int i, int val) {
        data[i+offset] = (short)(val&0xffff);
    }

    /**
     * Sets the requested data array element in the specified bank
     * from the given integer.
     * @param bank The bank in which you want to set the data array element.
     * @param i The data array element you want to set.
     * @param val The integer value to which you want to set the specified data array element.
     * @see #getElem(int)
     * @see #getElem(int, int)
     */
    public void setElem(int bank, int i, int val) {
        bankdata[bank][i+offsets[bank]] = (short)(val&0xffff);
    }
}
