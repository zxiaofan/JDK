/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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
package javafx.beans.property.adapter;

import java.lang.ref.WeakReference;

import com.sun.javafx.property.adapter.ReadOnlyPropertyDescriptor;

class DescriptorListenerCleaner implements Runnable{

    private final ReadOnlyPropertyDescriptor pd;
    private final WeakReference<ReadOnlyPropertyDescriptor.ReadOnlyListener<?>> lRef;

    DescriptorListenerCleaner(ReadOnlyPropertyDescriptor pd, ReadOnlyPropertyDescriptor.ReadOnlyListener<?> l) {
        this.pd = pd;
        this.lRef = new WeakReference<ReadOnlyPropertyDescriptor.ReadOnlyListener<?>>(l);
    }

    @Override
    public void run() {
        ReadOnlyPropertyDescriptor.ReadOnlyListener<?> l = lRef.get();
        if (l != null) {
            pd.removeListener(l);
        }
    }
}
