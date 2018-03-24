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
final class PrimitiveArrayListerBoolean<BeanT> extends Lister<BeanT,boolean[],Boolean,PrimitiveArrayListerBoolean.BooleanArrayPack> {

    private PrimitiveArrayListerBoolean() {
    }

    /*package*/ static void register() {
        Lister.primitiveArrayListers.put(Boolean.TYPE,new PrimitiveArrayListerBoolean());
    }

    public ListIterator<Boolean> iterator(final boolean[] objects, XMLSerializer context) {
        return new ListIterator<Boolean>() {
            int idx=0;
            public boolean hasNext() {
                return idx<objects.length;
            }

            public Boolean next() {
                return objects[idx++];
            }
        };
    }

    public BooleanArrayPack startPacking(BeanT current, Accessor<BeanT, boolean[]> acc) {
        return new BooleanArrayPack();
    }

    public void addToPack(BooleanArrayPack objects, Boolean o) {
        objects.add(o);
    }

    public void endPacking( BooleanArrayPack pack, BeanT bean, Accessor<BeanT,boolean[]> acc ) throws AccessorException {
        acc.set(bean,pack.build());
    }

    public void reset(BeanT o,Accessor<BeanT,boolean[]> acc) throws AccessorException {
        acc.set(o,new boolean[0]);
    }

    static final class BooleanArrayPack {
        boolean[] buf = new boolean[16];
        int size;

        void add(Boolean b) {
            if(buf.length==size) {
                // realloc
                boolean[] nb = new boolean[buf.length*2];
                System.arraycopy(buf,0,nb,0,buf.length);
                buf = nb;
            }
            if(b!=null)
                buf[size++] = b;
        }

        boolean[] build() {
            if(buf.length==size)
                // if we are lucky enough
                return buf;

            boolean[] r = new boolean[size];
            System.arraycopy(buf,0,r,0,size);
            return r;
        }
    }
}
