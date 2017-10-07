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
final class PrimitiveArrayListerShort<BeanT> extends Lister<BeanT,short[],Short,PrimitiveArrayListerShort.ShortArrayPack> {

    private PrimitiveArrayListerShort() {
    }

    /*package*/ static void register() {
        Lister.primitiveArrayListers.put(Short.TYPE,new PrimitiveArrayListerShort());
    }

    public ListIterator<Short> iterator(final short[] objects, XMLSerializer context) {
        return new ListIterator<Short>() {
            int idx=0;
            public boolean hasNext() {
                return idx<objects.length;
            }

            public Short next() {
                return objects[idx++];
            }
        };
    }

    public ShortArrayPack startPacking(BeanT current, Accessor<BeanT, short[]> acc) {
        return new ShortArrayPack();
    }

    public void addToPack(ShortArrayPack objects, Short o) {
        objects.add(o);
    }

    public void endPacking( ShortArrayPack pack, BeanT bean, Accessor<BeanT,short[]> acc ) throws AccessorException {
        acc.set(bean,pack.build());
    }

    public void reset(BeanT o,Accessor<BeanT,short[]> acc) throws AccessorException {
        acc.set(o,new short[0]);
    }

    static final class ShortArrayPack {
        short[] buf = new short[16];
        int size;

        void add(Short b) {
            if(buf.length==size) {
                // realloc
                short[] nb = new short[buf.length*2];
                System.arraycopy(buf,0,nb,0,buf.length);
                buf = nb;
            }
            if(b!=null)
                buf[size++] = b;
        }

        short[] build() {
            if(buf.length==size)
                // if we are lucky enough
                return buf;

            short[] r = new short[size];
            System.arraycopy(buf,0,r,0,size);
            return r;
        }
    }
}
