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

public class CharArray implements CharSequence {
    public char[] ch;
    public int start;
    public int length;

    protected int _hash;

    protected CharArray() {
    }

    public CharArray(char[] _ch, int _start, int _length, boolean copy) {
        set(_ch, _start, _length, copy);
    }

    public final void set(char[] _ch, int _start, int _length, boolean copy) {
        if (copy) {
            ch = new char[_length];
            start = 0;
            length = _length;
            System.arraycopy(_ch, _start, ch, 0, _length);
        } else {
            ch = _ch;
            start = _start;
            length = _length;
        }
        _hash = 0;
    }

    public final void cloneArray() {
        char[] _ch = new char[length];
        System.arraycopy(ch, start, _ch, 0, length);
        ch = _ch;
        start = 0;
    }

    public String toString() {
        return new String(ch, start, length);
    }

    public int hashCode() {
        if (_hash == 0) {
            // Same hash code algorithm as used for String
            // s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
            for (int i = start; i < start + length; i++) {
                _hash = 31*_hash + ch[i];
            }
        }
        return _hash;
    }

    public static final int hashCode(char[] ch, int start, int length) {
        // Same hash code algorithm as used for String
        // s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
        int hash = 0;
        for (int i = start; i < start + length; i++) {
            hash = 31*hash + ch[i];
        }

        return hash;
    }

    public final boolean equalsCharArray(CharArray cha) {
        if (this == cha) {
            return true;
        }

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

        return false;
    }

    public final boolean equalsCharArray(char[] ch, int start, int length) {
        if (this.length == length) {
            int n = this.length;
            int i = this.start;
            int j = start;
            while (n-- != 0) {
                if (this.ch[i++] != ch[j++])
                    return false;
            }
            return true;
        }

        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CharArray) {
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

    // CharSequence interface

    public final int length() {
        return length;
    }

    public final char charAt(int index) {
        return ch[start + index];
    }

    public final CharSequence subSequence(int start, int end) {
        return new CharArray(ch, this.start + start, end - start, false);
    }
}
