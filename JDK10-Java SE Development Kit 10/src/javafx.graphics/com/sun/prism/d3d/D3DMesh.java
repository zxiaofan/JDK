/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.d3d;

import com.sun.prism.impl.BaseMesh;
import com.sun.prism.impl.Disposer;

/**
 * TODO: 3D - Need documentation
 */
class D3DMesh extends BaseMesh {
    static int count = 0;

    private final D3DContext context;
    private final long nativeHandle;

    private D3DMesh(D3DContext context, long nativeHandle, Disposer.Record disposerRecord) {
        super(disposerRecord);
        this.context = context;
        this.nativeHandle = nativeHandle;
        count++;
    }

    static D3DMesh create(D3DContext context) {
        long nativeHandle = context.createD3DMesh();
        return new D3DMesh(context, nativeHandle, new D3DMeshDisposerRecord(context, nativeHandle));
    }

    long getNativeHandle() {
        return nativeHandle;
    }

    @Override
    public void dispose() {
        disposerRecord.dispose();
        count--;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean buildNativeGeometry(float[] vertexBuffer, int vertexBufferLength,
            int[] indexBufferInt, int indexBufferLength) {
        return context.buildNativeGeometry(nativeHandle, vertexBuffer,
                vertexBufferLength, indexBufferInt, indexBufferLength);
    }

    @Override
    public boolean buildNativeGeometry(float[] vertexBuffer, int vertexBufferLength,
            short[] indexBufferShort, int indexBufferLength) {
        return context.buildNativeGeometry(nativeHandle, vertexBuffer,
                vertexBufferLength, indexBufferShort, indexBufferLength);
    }

    static class D3DMeshDisposerRecord implements Disposer.Record {

        private final D3DContext context;
        private long nativeHandle;

        D3DMeshDisposerRecord(D3DContext context, long nativeHandle) {
            this.context = context;
            this.nativeHandle = nativeHandle;
        }

         void traceDispose() {
        }

        public void dispose() {
            if (nativeHandle != 0L) {
                traceDispose();
                context.releaseD3DMesh(nativeHandle);
                nativeHandle = 0L;
            }
        }
    }
}

