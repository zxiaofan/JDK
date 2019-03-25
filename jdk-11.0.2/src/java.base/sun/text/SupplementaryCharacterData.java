/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.text;

/**
 * SupplementaryCharacterData is an SMI-private class which was written for
 * RuleBasedBreakIterator and BreakDictionary.
 */
public final class SupplementaryCharacterData implements Cloneable {

    /**
     * A token used as a character-category value to identify ignore characters
     */
    private static final byte IGNORE = -1;

    /**
     * An array for supplementary characters and values.
     * Lower one byte is used to keep a byte-value.
     * Upper three bytes are used to keep the first supplementary character
     * which has the value. The value is also valid for the following
     * supplementary characters until the next supplementary character in
     * the array <code>dataTable</code>.
     * For example, if the value of <code>dataTable[2]</code> is
     * <code>0x01000123</code> and the value of <code>dataTable[3]</code> is
     * <code>0x01000567</code>, supplementary characters from
     * <code>0x10001</code> to <code>0x10004</code> has the value
     * <code>0x23</code>. And, <code>getValue(0x10003)</code> returns the value.
     */
    private int[] dataTable;


    /**
     * Creates a new SupplementaryCharacterData object with the given table.
     */
    public SupplementaryCharacterData(int[] table) {
        dataTable = table;
    }

    /**
     * Returns a corresponding value for the given supplementary code-point.
     */
    public int getValue(int index) {
        // Index should be a valid supplementary character.
        assert index >= Character.MIN_SUPPLEMENTARY_CODE_POINT &&
               index <= Character.MAX_CODE_POINT :
               "Invalid code point:" + Integer.toHexString(index);

        int i = 0;
        int j = dataTable.length - 1;
        int k;

        for (;;) {
            k = (i + j) / 2;

            int start = dataTable[k] >> 8;
            int end   = dataTable[k+1] >> 8;

            if (index < start) {
                j = k;
            } else if (index > (end-1)) {
                i = k;
            } else {
                int v = dataTable[k] & 0xFF;
                return (v == 0xFF) ? IGNORE : v;
            }
        }
    }

    /**
     * Returns the data array.
     */
    public int[] getArray() {
        return dataTable;
    }

}
