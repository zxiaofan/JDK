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

package com.sun.prism.es2;

import com.sun.prism.impl.BaseMesh;
import com.sun.prism.impl.Disposer;

/**
 * TODO: 3D - Need documentation
 */
class ES2Mesh extends BaseMesh {
    static int count = 0;

    private final ES2Context context;
    private final long nativeHandle;

    private ES2Mesh(ES2Context context, long nativeHandle, Disposer.Record disposerRecord) {
        super(disposerRecord);
        this.context = context;
        this.nativeHandle = nativeHandle;
        count++;
    }

    static ES2Mesh create(ES2Context context) {
        long nativeHandle = context.createES2Mesh();
        return new ES2Mesh(context, nativeHandle, new ES2MeshDisposerRecord(context, nativeHandle));
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

    static class ES2MeshDisposerRecord implements Disposer.Record {

        private final ES2Context context;
        private long nativeHandle;

        ES2MeshDisposerRecord(ES2Context context, long nativeHandle) {
            this.context = context;
            this.nativeHandle = nativeHandle;
        }

        void traceDispose() {
        }

        public void dispose() {
            if (nativeHandle != 0L) {
                traceDispose();
                context.releaseES2Mesh(nativeHandle);
                nativeHandle = 0L;
            }
        }
    }
}
