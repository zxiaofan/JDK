/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.win;

final class WinVariant {
    static final int VT_EMPTY = 0;
    static final int VT_NULL  = 1;
    static final int VT_I2    = 2;
    static final int VT_I4    = 3;
    static final int VT_R4    = 4;
    static final int VT_R8    = 5;
    static final int VT_BOOL  = 11;
    static final int VT_BSTR  = 8;
    static final int VT_ARRAY = 0x2000;
    static final int VT_UNKNOWN = 13;

    short vt;

    short iVal;
    int lVal;
    float fltVal;
    double dblVal;
    boolean boolVal;
    String bstrVal;

    double[] pDblVal;
    long punkVal;
}
