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

package com.sun.xml.internal.bind.v2.runtime.unmarshaller;

import java.io.IOException;

import com.sun.xml.internal.bind.v2.runtime.output.Pcdata;
import com.sun.xml.internal.bind.v2.runtime.output.UTF8XmlOutput;

/**
 * Typed {@link CharSequence} for int[].
 *
 * <p>
 * Fed to unmarshaller when the 'text' data is actually
 * a virtual image of int array.
 *
 * <p>
 * This class holds int[] as a triplet of (data,start,len)
 * where 'start' and 'len' represents the start position of the
 * data and the length.
 *
 * @author Kohsuke Kawaguchi
 */
public final class IntArrayData extends Pcdata {

    private int[] data;
    private int start;
    private int len;

    /**
     * String representation of the data. Lazily computed.
     */
    private StringBuilder literal;


    public IntArrayData(int[] data, int start, int len) {
        set(data, start, len);
    }

    public IntArrayData() {
    }

    /**
     * Sets the int[] data to this object.
     *
     * <p>
     * This method doesn't make a copy for a performance reason.
     * The caller is still free to modify the array it passed to this method,
     * but he should do so with a care. The unmarshalling code isn't expecting
     * the value to be changed while it's being routed.
     */
    public void set(int[] data, int start, int len) {
        this.data = data;
        this.start = start;
        this.len = len;
        this.literal = null;
    }

    public int length() {
        return getLiteral().length();
    }

    public char charAt(int index) {
        return getLiteral().charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return getLiteral().subSequence(start,end);
    }

    /**
     * Computes the literal form from the data.
     */
    private StringBuilder getLiteral() {
        if(literal!=null)   return literal;

        literal = new StringBuilder();
        int p = start;
        for( int i=len; i>0; i-- ) {
            if(literal.length()>0)  literal.append(' ');
            literal.append(data[p++]);
        }

        return literal;
    }

    public String toString() {
        return literal.toString();
    }

    public void writeTo(UTF8XmlOutput output) throws IOException {
        int p = start;
        for( int i=len; i>0; i-- ) {
            if(i!=len)
                output.write(' ');
            output.text(data[p++]);
        }
    }
}
