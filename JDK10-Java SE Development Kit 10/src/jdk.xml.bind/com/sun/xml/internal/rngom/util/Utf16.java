/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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
/*
 * Copyright (C) 2004-2011
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sun.xml.internal.rngom.util;

public abstract class Utf16 {
  // 110110XX XXXXXX 110111XX XXXXXX
  static public boolean isSurrogate(char c) {
    return (c & 0xF800) == 0xD800;
  }
  static public boolean isSurrogate1(char c) {
    return (c & 0xFC00) == 0xD800;
  }
  static public boolean isSurrogate2(char c) {
    return (c & 0xFC00) == 0xDC00;
  }
  static public int scalarValue(char c1, char c2) {
    return (((c1 & 0x3FF) << 10) | (c2 & 0x3FF)) + 0x10000;
  }
  static public char surrogate1(int c) {
    return (char)(((c - 0x10000) >> 10) | 0xD800);
  }
  static public char surrogate2(int c) {
    return (char)(((c - 0x10000) & 0x3FF) | 0xDC00);
  }
}
