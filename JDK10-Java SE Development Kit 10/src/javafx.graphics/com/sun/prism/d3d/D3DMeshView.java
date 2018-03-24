/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.prism.Graphics;
import com.sun.prism.Material;
import com.sun.prism.impl.BaseMeshView;
import com.sun.prism.impl.Disposer;

/**
 * TODO: 3D - Need documentation
 */
class D3DMeshView extends BaseMeshView {

    static int count = 0;
    private final D3DContext context;
    private final long nativeHandle;

    // TODO: 3D - Need a mechanism to "decRefCount" Mesh and Material
    //            if we need to do eager clean up
    final private D3DMesh mesh;
    private D3DPhongMaterial material;

    private D3DMeshView(D3DContext context, long nativeHandle, D3DMesh mesh,
            Disposer.Record disposerRecord) {
        super(disposerRecord);
        this.context = context;
        this.mesh = mesh;
        this.nativeHandle = nativeHandle;
        count++;
    }

    static D3DMeshView create(D3DContext context, D3DMesh mesh) {
        long nativeHandle = context.createD3DMeshView(mesh.getNativeHandle());
        return new D3DMeshView(context, nativeHandle, mesh, new D3DMeshViewDisposerRecord(context, nativeHandle));
    }

    @Override
    public void setCullingMode(int cullingMode) {
        context.setCullingMode(nativeHandle, cullingMode);
    }

    @Override
    public void setMaterial(Material material) {
        context.setMaterial(nativeHandle,
                ((D3DPhongMaterial) material).getNativeHandle());
        this.material = (D3DPhongMaterial) material;
    }

    @Override
    public void setWireframe(boolean wireframe) {
        context.setWireframe(nativeHandle, wireframe);
    }

    @Override
    public void setAmbientLight(float r, float g, float b) {
        context.setAmbientLight(nativeHandle, r, g, b);
    }

    @Override
    public void setPointLight(int index, float x, float y, float z, float r, float g, float b, float w) {
        // NOTE: We only support up to 3 point lights at the present
        if (index >= 0 && index <= 2) {
            context.setPointLight(nativeHandle, index, x, y, z, r, g, b, w);
        }
    }

    @Override
    public void render(Graphics g) {
        material.lockTextureMaps();
        context.renderMeshView(nativeHandle, g);
        material.unlockTextureMaps();
    }

    @Override
    public void dispose() {
        // TODO: 3D - Need a mechanism to "decRefCount" Mesh and Material
        material = null;
        disposerRecord.dispose();
        count--;
    }

    public int getCount() {
        return count;
    }

    static class D3DMeshViewDisposerRecord implements Disposer.Record {

        private final D3DContext context;
        private long nativeHandle;

        D3DMeshViewDisposerRecord(D3DContext context, long nativeHandle) {
            this.context = context;
            this.nativeHandle = nativeHandle;
        }

        void traceDispose() {
        }

        public void dispose() {
            if (nativeHandle != 0L) {
                traceDispose();
                context.releaseD3DMeshView(nativeHandle);
                nativeHandle = 0L;
            }
        }
    }
}
