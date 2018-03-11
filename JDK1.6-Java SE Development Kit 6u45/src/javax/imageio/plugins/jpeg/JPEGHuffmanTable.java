/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**********************************************************************
 **********************************************************************
 **********************************************************************
 *** COPYRIGHT (c) 1997-1998 Eastman Kodak Company.                 ***
 *** As  an unpublished  work pursuant to Title 17 of the United    ***
 *** States Code.  All rights reserved.                             ***
 **********************************************************************
 **********************************************************************
 **********************************************************************/

package javax.imageio.plugins.jpeg;

/**
 * A class encapsulating a single JPEG Huffman table.  Fields are
 * provided for the "standard" tables from taken from Annex K of the
 * JPEG specification.  These are the tables used as defaults.
 * This class differs from the old unsupported 
 * com.sun.image.codec.jpeg.JPEGHuffmanTable in two ways: 
 * <ol>
 * <li>The lengths arrays for this class do not contain an ignored 0th
 * entry.  The lengths array in a JPEG stream does not contain an extra
 * entry, and this class is used to represent the contents of a JPEG
 * stream.
 * </li>
 * <li>The old class incorrectly referred to Huffman "symbols", while
 * expecting an array of values to be encoded.  This class has a
 * <code>getValues</code> method instead of a <code>getSymbols</code>
 * method.
 * </li>
 * </ol>
 *
 * <p>
 * For more information about the operation of the built-in JPEG plug-ins,
 * see the <A HREF="../../metadata/doc-files/jpeg_metadata.html">JPEG
 * metadata format specification and usage notes</A>.
 *
 * @version 0.5
 */
public class JPEGHuffmanTable {

    /** 
     * The maximum number of symbol lengths
     * (max symbol length in bits = 16).
     */
    private static final int HUFF_MAX_LEN = 16;
	
    /** The maximum number of values. */
    private static final int HUFF_MAX_VALS = 256;
	
    /** lengths[k-1] = number of symbols with length k bits.	*/
    private short lengths[] = null;
    
    /** Values in order of increasing length of the corresponding symbols. */
    private short values[] = null;
    
    /** The standard DC luminance Huffman table. */
    public static final JPEGHuffmanTable StdDCLuminance = 
        new JPEGHuffmanTable();
    static {
        short lengths[] = {
            0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
        short values[] = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        
        StdDCLuminance.lengths = lengths;
        StdDCLuminance.values = values;
        StdDCLuminance.checkTable();
    }
    
	
    /** The standard DC chrominance Huffman table. */
    public static final JPEGHuffmanTable StdDCChrominance = 
        new JPEGHuffmanTable();
    static {
        short lengths[] = {
            0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 };
        short values[] = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        
        StdDCChrominance.lengths = lengths;
        StdDCChrominance.values = values;
        StdDCChrominance.checkTable();
    }
    
    /** The standard AC luminance Huffman table. */
    public static final JPEGHuffmanTable StdACLuminance = 
        new JPEGHuffmanTable();
    static {
        short lengths[] = {
            0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 0x7d };
        short values[] = { 
            0x01, 0x02, 0x03, 0x00, 0x04, 0x11, 0x05, 0x12,
            0x21, 0x31, 0x41, 0x06, 0x13, 0x51, 0x61, 0x07,
            0x22, 0x71, 0x14, 0x32, 0x81, 0x91, 0xa1, 0x08,
            0x23, 0x42, 0xb1, 0xc1, 0x15, 0x52, 0xd1, 0xf0,
            0x24, 0x33, 0x62, 0x72, 0x82, 0x09, 0x0a, 0x16,
            0x17, 0x18, 0x19, 0x1a, 0x25, 0x26, 0x27, 0x28,
            0x29, 0x2a, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39,
            0x3a, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48, 0x49,
            0x4a, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58, 0x59,
            0x5a, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69,
            0x6a, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79,
            0x7a, 0x83, 0x84, 0x85, 0x86, 0x87, 0x88, 0x89,
            0x8a, 0x92, 0x93, 0x94, 0x95, 0x96, 0x97, 0x98,
            0x99, 0x9a, 0xa2, 0xa3, 0xa4, 0xa5, 0xa6, 0xa7,
            0xa8, 0xa9, 0xaa, 0xb2, 0xb3, 0xb4, 0xb5, 0xb6,
            0xb7, 0xb8, 0xb9, 0xba, 0xc2, 0xc3, 0xc4, 0xc5,
            0xc6, 0xc7, 0xc8, 0xc9, 0xca, 0xd2, 0xd3, 0xd4,
            0xd5, 0xd6, 0xd7, 0xd8, 0xd9, 0xda, 0xe1, 0xe2,
            0xe3, 0xe4, 0xe5, 0xe6, 0xe7, 0xe8, 0xe9, 0xea,
            0xf1, 0xf2, 0xf3, 0xf4, 0xf5, 0xf6, 0xf7, 0xf8,
            0xf9, 0xfa };
        
        StdACLuminance.lengths = lengths;
        StdACLuminance.values = values;
        StdACLuminance.checkTable();
    }
    
    /** The standard AC chrominance Huffman table. */
    public static final JPEGHuffmanTable StdACChrominance = 
        new JPEGHuffmanTable();
    static {
        short lengths[] =  {
            0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 0x77 };
        short values[] = { 
            0x00, 0x01, 0x02, 0x03, 0x11, 0x04, 0x05, 0x21,
            0x31, 0x06, 0x12, 0x41, 0x51, 0x07, 0x61, 0x71,
            0x13, 0x22, 0x32, 0x81, 0x08, 0x14, 0x42, 0x91,
            0xa1, 0xb1, 0xc1, 0x09, 0x23, 0x33, 0x52, 0xf0,
            0x15, 0x62, 0x72, 0xd1, 0x0a, 0x16, 0x24, 0x34,
            0xe1, 0x25, 0xf1, 0x17, 0x18, 0x19, 0x1a, 0x26,
            0x27, 0x28, 0x29, 0x2a, 0x35, 0x36, 0x37, 0x38,
            0x39, 0x3a, 0x43, 0x44, 0x45, 0x46, 0x47, 0x48,
            0x49, 0x4a, 0x53, 0x54, 0x55, 0x56, 0x57, 0x58,
            0x59, 0x5a, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68,
            0x69, 0x6a, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78,
            0x79, 0x7a, 0x82, 0x83, 0x84, 0x85, 0x86, 0x87,
            0x88, 0x89, 0x8a, 0x92, 0x93, 0x94, 0x95, 0x96,
            0x97, 0x98, 0x99, 0x9a, 0xa2, 0xa3, 0xa4, 0xa5,
            0xa6, 0xa7, 0xa8, 0xa9, 0xaa, 0xb2, 0xb3, 0xb4,
            0xb5, 0xb6, 0xb7, 0xb8, 0xb9, 0xba, 0xc2, 0xc3,
            0xc4, 0xc5, 0xc6, 0xc7, 0xc8, 0xc9, 0xca, 0xd2,
            0xd3, 0xd4, 0xd5, 0xd6, 0xd7, 0xd8, 0xd9, 0xda,
            0xe2, 0xe3, 0xe4, 0xe5, 0xe6, 0xe7, 0xe8, 0xe9,
            0xea, 0xf2, 0xf3, 0xf4, 0xf5, 0xf6, 0xf7, 0xf8,
            0xf9, 0xfa };
        
        StdACChrominance.lengths = lengths;
        StdACChrominance.values = values;
        StdACChrominance.checkTable();
    }
    
    /**
     * Private constructor used to construct the Standard Huffman tables
     */
    private JPEGHuffmanTable() {}
    
    /** 
     * Creates a Huffman table and initializes it.  The input arrays
     * are copied.  The arrays must describe a possible Huffman table.
     * For example, 3 codes cannot be expressed with a single bit.
     *
     * @param lengths an array of <code>short</code>s where
     * <code>lengths[k]</code> is equal to the number of values with
     * corresponding codes of length <code>k + 1</code> bits.
     * @param values an array of <code>short</code>s containing the
     * values in order of increasing code length.
     *
     * @exception IllegalArgumentException if <code>lengths</code> or
     * <code>values</code> are <code>null</code>, the length of
     * <code>lengths</code> is greater than 16, the length of
     * <code>values</code> is greater than 256, if any value in
     * <code>lengths</code> or <code>values</code> is less than zero,
     * or if the arrays do not describe a valid Huffman table.
     */
    public JPEGHuffmanTable(short[] lengths, short[] values) {
        if (lengths == null) {
            throw new IllegalArgumentException("lengths array is null!");
        }
        if (values == null) {
            throw new IllegalArgumentException("values array is null!");
        }
        if (lengths.length > HUFF_MAX_LEN) {
            throw new IllegalArgumentException("lengths array is too long!");
        }
        if (values.length > HUFF_MAX_VALS) {
            throw new IllegalArgumentException("values array is too long");
        }
        for (int i = 1; i < lengths.length; i++) {
            if (lengths[i] < 0) {
                throw new IllegalArgumentException
                    ("Values in lengths array must be non-negative.");
            }
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i] < 0) {
                throw new IllegalArgumentException
                    ("Values in values array must be non-negative.");
            }
        }
        
        this.lengths = (short[])lengths.clone();
        this.values = (short[])values.clone();

        checkTable();
    }
    
    /**
     * This checks that the table they gave us isn't 'illegal' It
     * checks that the symbol length counts are possible, and that
     * they gave us at least enough values for the symbol length
     * counts. Eventually this might check that there aren't duplicate
     * values.
     */
    private void checkTable() {
        int numVals = 2;
        int sum = 0;

        for (int i = 0; i < lengths.length; i++) {
            sum     += lengths[i];
            numVals -= lengths[i];
            numVals *= 2;
        }
        
        if (numVals < 0) {
            throw new IllegalArgumentException
                ("Invalid Huffman table provided, lengths are incorrect.");
        }
        
        if (sum != values.length) {
            throw new IllegalArgumentException
                ("Invalid Huffman table provided, sum of lengths != values.");
        }
    }
    
    /** 
     * Return an array of <code>short</code>s containing the number of
     * values for each length in the Huffman table.  The returned
     * array is a copy.
     *
     * @return a <code>short</code> array where <code>array[k-1]</code>
     * is equal to the number of values in the table of length
     * <code>k</code>.
     *
     * @see #getValues
     */
    public short[] getLengths() {
        return (short[])lengths.clone();
    }
    
    /** 
     * Return an array of <code>short</code>s containing the
     * values arranged by increasing length of their corresponding
     * codes.  The interpretation of
     * the array is dependent on the values returned from
     * <code>getLengths</code>.  The returned array is a copy.
     *
     * @return a <code>short</code> array of values.
     *
     * @see #getLengths
     */
    public short[] getValues() {
        return (short[])values.clone();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("JPEGHuffmanTable:\nlengths:");
        for (int i = 0; i< lengths.length; i++) {
            sb.append(' ').append(lengths[i]);
        }
        sb.append("\nvalues:");
        for (int i = 0; i< values.length; i++) {
            sb.append(' ').append(values[i]);
        }
        return sb.toString();
    }
}
