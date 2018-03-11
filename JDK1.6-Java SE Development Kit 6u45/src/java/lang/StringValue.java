/*
 * %W% %E%
 *
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

import java.util.Arrays;

/**
 * This class consists exclusively of static methods that operate on
 * character arrays used by Strings for storing the value.
 */

class StringValue {
    private StringValue() { }

    /**
     * Returns a char array that is a copy of the given char array.
     */
    static char[] from(char[] value) {
        return Arrays.copyOf(value, value.length);
    }   
}
