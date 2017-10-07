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

public class BuiltInEncodingAlgorithmState {

    public static final int INITIAL_LENGTH = 8;

    public boolean[] booleanArray = new boolean[INITIAL_LENGTH];

    public short[] shortArray = new short[INITIAL_LENGTH];

    public int[] intArray = new int[INITIAL_LENGTH];

    public long[] longArray = new long[INITIAL_LENGTH];

    public float[] floatArray = new float[INITIAL_LENGTH];

    public double[] doubleArray = new double[INITIAL_LENGTH];
}
