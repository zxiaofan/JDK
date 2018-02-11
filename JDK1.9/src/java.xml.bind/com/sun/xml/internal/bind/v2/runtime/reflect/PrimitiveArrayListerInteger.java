/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime.reflect;

import com.sun.xml.internal.bind.api.AccessorException;
import com.sun.xml.internal.bind.v2.runtime.XMLSerializer;

/**
 * {@link Lister} for primitive type arrays.
 * <p><b>
 *     Auto-generated, do not edit.
 * </b></p>
 * <p>
 *     B y t e ArrayLister is used as the master to generate the rest of the
 *     lister classes. Do not modify the generated copies.
 * </p>
 */
final class PrimitiveArrayListerInteger<BeanT> extends Lister<BeanT,int[],Integer,PrimitiveArrayListerInteger.IntegerArrayPack> {

    private PrimitiveArrayListerInteger() {
    }

    /*package*/ static void register() {
        Lister.primitiveArrayListers.put(Integer.TYPE,new PrimitiveArrayListerInteger());
    }

    public ListIterator<Integer> iterator(final int[] objects, XMLSerializer context) {
        return new ListIterator<Integer>() {
            int idx=0;
            public boolean hasNext() {
                return idx<objects.length;
            }

            public Integer next() {
                return objects[idx++];
            }
        };
    }

    public IntegerArrayPack startPacking(BeanT current, Accessor<BeanT, int[]> acc) {
        return new IntegerArrayPack();
    }

    public void addToPack(IntegerArrayPack objects, Integer o) {
        objects.add(o);
    }

    public void endPacking( IntegerArrayPack pack, BeanT bean, Accessor<BeanT,int[]> acc ) throws AccessorException {
        acc.set(bean,pack.build());
    }

    public void reset(BeanT o,Accessor<BeanT,int[]> acc) throws AccessorException {
        acc.set(o,new int[0]);
    }

    static final class IntegerArrayPack {
        int[] buf = new int[16];
        int size;

        void add(Integer b) {
            if(buf.length==size) {
                // realloc
                int[] nb = new int[buf.length*2];
                System.arraycopy(buf,0,nb,0,buf.length);
                buf = nb;
            }
            if(b!=null)
                buf[size++] = b;
        }

        int[] build() {
            if(buf.length==size)
                // if we are lucky enough
                return buf;

            int[] r = new int[size];
            System.arraycopy(buf,0,r,0,size);
            return r;
        }
    }
}
