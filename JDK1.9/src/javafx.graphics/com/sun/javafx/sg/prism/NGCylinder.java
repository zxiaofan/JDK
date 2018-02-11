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

package com.sun.javafx.sg.prism;

/**
 * TODO: 3D - Need documentation
 */
public class NGCylinder extends NGShape3D {

    public void updateMesh(NGTriangleMesh mesh) {
        this.mesh = mesh;
        invalidate();
    }
}
