/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime.reflect.opt;

import com.sun.xml.internal.bind.v2.runtime.reflect.TransducedAccessor;

/**
 * Used by {@link TransducedAccessor} templates.
 *
 * <p>
 * Fields needs to have a distinctive name.
 *
 * @author Kohsuke Kawaguchi
 */
final class Bean {
    public boolean f_boolean;
    public char f_char;
    public byte f_byte;
    public short f_short;
    int f_int;
    public long f_long;
    public float f_float;
    public double f_double;
    /**
     * Field of a reference type.
     * We need a distinctive type so that it can be easily replaced.
     */
    public Ref f_ref;

    public boolean get_boolean() { throw new UnsupportedOperationException(); }
    public void set_boolean(boolean b) { throw new UnsupportedOperationException(); }

    public char get_char() { throw new UnsupportedOperationException(); }
    public void set_char(char b) { throw new UnsupportedOperationException(); }

    public byte get_byte() { throw new UnsupportedOperationException(); }
    public void set_byte(byte b) { throw new UnsupportedOperationException(); }

    public short get_short() { throw new UnsupportedOperationException(); }
    public void set_short(short b) { throw new UnsupportedOperationException(); }

    public int get_int() { throw new UnsupportedOperationException(); }
    public void set_int(int b) { throw new UnsupportedOperationException(); }

    public long get_long() { throw new UnsupportedOperationException(); }
    public void set_long(long b) { throw new UnsupportedOperationException(); }

    public float get_float() { throw new UnsupportedOperationException(); }
    public void set_float(float b) { throw new UnsupportedOperationException(); }

    public double get_double() { throw new UnsupportedOperationException(); }
    public void set_double(double b) { throw new UnsupportedOperationException(); }

    public Ref get_ref() { throw new UnsupportedOperationException(); }
    public void set_ref(Ref r) { throw new UnsupportedOperationException(); }
}
