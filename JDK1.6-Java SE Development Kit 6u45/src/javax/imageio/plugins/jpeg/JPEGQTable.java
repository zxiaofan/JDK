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
 * A class encapsulating a single JPEG quantization table.  The
 * elements appear in natural order (as opposed to zig-zag order).
 * Static variables are provided for the "standard" tables taken from
 * Annex K of the JPEG spec, as well as the default tables
 * conventionally used for visually lossless encoding.
 *
 * <p>
 * For more information about the operation of the built-in JPEG plug-ins,
 * see the <A HREF="../../metadata/doc-files/jpeg_metadata.html">JPEG
 * metadata format specification and usage notes</A>.
 *
 * @version 0.5
 */
public class JPEGQTable {

    /** Table */
    private int[] table;

    /** The number of coefficients in a quantization table. */
    private static final byte QTABLESIZE = 64;
	
    /** 
     * The sample luminance quantization table given in the JPEG
     * specification, table K.1.  According to the specification,
     * these values produce "good" quality output.
     *
     * @see #K1Div2Luminance
     */
    public static final JPEGQTable K1Luminance = new JPEGQTable();
    static {
        int [] lumVals = {
            16,  11,  10,  16,  24,  40,  51,  61,
            12,  12,  14,  19,  26,  58,  60,  55,
            14,  13,  16,  24,  40,  57,  69,  56,
            14,  17,  22,  29,  51,  87,  80,  62,
            18,  22,  37,  56,  68, 109, 103,  77,
            24,  35,  55,  64,  81, 104, 113,  92,
            49,  64,  78,  87, 103, 121, 120, 101,
            72,  92,  95,  98, 112, 100, 103,  99
        };
        
        K1Luminance.table = lumVals;
    }

    /**
     * The sample luminance quantization table given in the JPEG
     * specification, table K.1, with all elements divided by 2.
     * According to the specification, these values produce "very
     * good" quality output.  This is the table usually used for
     * "visually lossless" encoding, and is the default luminance
     * table used if the default tables and quality settings are used.
     *
     * @see #K1Luminance
     */
    public static final JPEGQTable K1Div2Luminance = 
        K1Luminance.getScaledInstance(0.5f, true);

    /** 
     * The sample chrominance quantization table given in the JPEG
     * specification, table K.2.  According to the specification,
     * these values produce "good" quality output.
     *
     * @see #K2Div2Chrominance
     */
    public static final JPEGQTable K2Chrominance = new JPEGQTable();
    static {
        int [] chromVals = {
            17,  18,  24,  47,  99,  99,  99,  99,
            18,  21,  26,  66,  99,  99,  99,  99,
            24,  26,  56,  99,  99,  99,  99,  99,
            47,  66,  99,  99,  99,  99,  99,  99,
            99,  99,  99,  99,  99,  99,  99,  99,
            99,  99,  99,  99,  99,  99,  99,  99,
            99,  99,  99,  99,  99,  99,  99,  99,
            99,  99,  99,  99,  99,  99,  99,  99
        };
        K2Chrominance.table = chromVals;
    }
    
    /**
     * The sample chrominance quantization table given in the JPEG
     * specification, table K.2, with all elements divided by 2.
     * According to the specification, these values produce "very
     * good" quality output.  This is the table usually used for
     * "visually lossless" encoding, and is the default chrominance
     * table used if the default tables and quality settings are used.
     *
     * @see #K2Chrominance
     */
    public static final JPEGQTable K2Div2Chrominance = 
        K2Chrominance.getScaledInstance(0.5f, true);
    
    /** 
     * Constructs an empty quantization table. This is used to create
     * the standard tables.
     */
    private JPEGQTable() {}
		
    /** 
     * Constructs a quantization table from the argument, which must
     * contain 64 elements in natural order (not zig-zag order).
     * A copy is made of the the input array.
     *
     * @param table the quantization table, as an <code>int</code>
     * array.
     *
     * @exception IllegalArgumentException if <code>table</code> is
     * <code>null</code> or <code>table.length</code> is not equal to
     * 64.
     */
    public JPEGQTable(int[] table) {
        if (table == null) {
            throw new IllegalArgumentException("table == null!");
        }
        if (table.length != QTABLESIZE) {
            throw new IllegalArgumentException
                ("Quantization table is the wrong size.");
        }

        this.table = (int[])table.clone();
    }
    
    /** 
     * Returns a copy of the current quantization table as an array of
     * ints in natural (not zig-zag) order.
     *
     * @return A copy of the current quantization table.
     */
    public int[] getTable() { 
        return (int[])table.clone();
    }

    /** 
     * Returns a new quantization table where the values are
     * multiplied by <code>scaleFactor</code> and then clamped to the
     * range 1..32767 (or to 1..255 if <code>forceBaseline</code> is
     * <code>true</code>).
     *
     * <p> Values of <code>scaleFactorless</code> than 1 tend to
     * improve the quality level of the table, and values greater than
     * <code>1.0</code> degrade the quality level of the table.
     
     * @param scaleFactor the multiplicative factor for the table.
     * @param forceBaseline if <code>true</code>, the values will be
     * clamped to the range 1..255.
     *
     * @return a new quantization table that is a linear multiple of
     * the current table.
     */
    public JPEGQTable getScaledInstance(float scaleFactor, 
                                        boolean forceBaseline) {
        int max = (forceBaseline) ? 255 : 32767;
        int[] ret = new int[QTABLESIZE];

        for (int i = 0; i < QTABLESIZE; i++) {
            float scaledValue = (float)Math.round(table[i]*scaleFactor);
            int holder;
            
            // limit to valid range
            if (scaledValue <= 1.0F) {
                holder = 1;
            } else if (scaledValue >= max) {
                holder = max;
            } else {
                holder = (int)scaledValue;
            }
            ret[i] = holder;
        }

        return new JPEGQTable(ret);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("JPEGQTable:\n");
        for (int i = 0; i< 8; i++) {
            sb.append('\t');
            for (int j = 0; j < 8; j++) {
                sb.append(table[(i*8)+j]).append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
