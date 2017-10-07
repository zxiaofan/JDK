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

package com.sun.xml.internal.fastinfoset.util;

public class CharArrayString extends CharArray {
    protected String _s;

    public CharArrayString(String s) {
        this(s, true);
    }

    public CharArrayString(String s, boolean createArray) {
        _s = s;
        if (createArray) {
            ch = _s.toCharArray();
            start = 0;
            length = ch.length;
        }
    }

    public String toString() {
        return _s;
    }

    public int hashCode() {
        return _s.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CharArrayString) {
            CharArrayString chas = (CharArrayString)obj;
            return _s.equals(chas._s);
        } else if (obj instanceof CharArray) {
            CharArray cha = (CharArray)obj;
            if (length == cha.length) {
                int n = length;
                int i = start;
                int j = cha.start;
                while (n-- != 0) {
                    if (ch[i++] != cha.ch[j++])
                        return false;
                }
                return true;
            }
        }
        return false;
    }

}
