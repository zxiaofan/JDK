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

public abstract class IntegerEncodingAlgorithm extends BuiltInEncodingAlgorithm {
    public final static int SHORT_SIZE  = 2;
    public final static int INT_SIZE    = 4;
    public final static int LONG_SIZE   = 8;

    public final static int SHORT_MAX_CHARACTER_SIZE    = 6;
    public final static int INT_MAX_CHARACTER_SIZE      = 11;
    public final static int LONG_MAX_CHARACTER_SIZE     = 20;

}
