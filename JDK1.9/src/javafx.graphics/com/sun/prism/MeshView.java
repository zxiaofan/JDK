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

package com.sun.prism;

import javafx.scene.shape.CullFace;

/**
 * TODO: 3D - Need documentation
 * This class represents new retained mode rendering object
 * it has a { mesh, material, position, lights and other common rendering properties
 */
public interface MeshView {

    public final static int CULL_NONE = CullFace.NONE.ordinal();
    public final static int CULL_BACK = CullFace.BACK.ordinal();
    public final static int CULL_FRONT = CullFace.FRONT.ordinal();

    public void setCullingMode(int mode);

    public void setMaterial(Material material);

    public void setWireframe(boolean wireframe);

    public void setAmbientLight(float r, float g, float b);

    public void setPointLight(int index,
            float x, float y, float z,
            float r, float g, float b, float w);

    public void render(Graphics g);
}
