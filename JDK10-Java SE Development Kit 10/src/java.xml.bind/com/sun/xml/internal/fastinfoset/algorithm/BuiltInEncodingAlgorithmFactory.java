/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.algorithm;

import com.sun.xml.internal.fastinfoset.EncodingConstants;
import com.sun.xml.internal.org.jvnet.fastinfoset.EncodingAlgorithmIndexes;

public final class BuiltInEncodingAlgorithmFactory {

    private final static BuiltInEncodingAlgorithm[] table =
            new BuiltInEncodingAlgorithm[EncodingConstants.ENCODING_ALGORITHM_BUILTIN_END + 1];

    public final static HexadecimalEncodingAlgorithm hexadecimalEncodingAlgorithm = new HexadecimalEncodingAlgorithm();

    public final static BASE64EncodingAlgorithm base64EncodingAlgorithm = new BASE64EncodingAlgorithm();

    public final static BooleanEncodingAlgorithm booleanEncodingAlgorithm = new BooleanEncodingAlgorithm();

    public final static ShortEncodingAlgorithm shortEncodingAlgorithm = new ShortEncodingAlgorithm();

    public final static IntEncodingAlgorithm intEncodingAlgorithm = new IntEncodingAlgorithm();

    public final static LongEncodingAlgorithm longEncodingAlgorithm = new LongEncodingAlgorithm();

    public final static FloatEncodingAlgorithm floatEncodingAlgorithm = new FloatEncodingAlgorithm();

    public final static DoubleEncodingAlgorithm doubleEncodingAlgorithm = new DoubleEncodingAlgorithm();

    public final static UUIDEncodingAlgorithm uuidEncodingAlgorithm = new UUIDEncodingAlgorithm();

    static {
        table[EncodingAlgorithmIndexes.HEXADECIMAL] = hexadecimalEncodingAlgorithm;
        table[EncodingAlgorithmIndexes.BASE64] = base64EncodingAlgorithm;
        table[EncodingAlgorithmIndexes.SHORT] = shortEncodingAlgorithm;
        table[EncodingAlgorithmIndexes.INT] = intEncodingAlgorithm;
        table[EncodingAlgorithmIndexes.LONG] = longEncodingAlgorithm;
        table[EncodingAlgorithmIndexes.BOOLEAN] = booleanEncodingAlgorithm;
        table[EncodingAlgorithmIndexes.FLOAT] = floatEncodingAlgorithm;
        table[EncodingAlgorithmIndexes.DOUBLE] = doubleEncodingAlgorithm;
        table[EncodingAlgorithmIndexes.UUID] = uuidEncodingAlgorithm;
    }

    public static BuiltInEncodingAlgorithm getAlgorithm(int index) {
        return table[index];
    }
}
