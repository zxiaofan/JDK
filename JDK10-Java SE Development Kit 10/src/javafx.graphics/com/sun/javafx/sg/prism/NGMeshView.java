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
public class NGMeshView extends NGShape3D {

    @Override
    public void setMesh(NGTriangleMesh pgtm) {
        // NOTE: Implementation has been promopted to NGShape3D so as to
        // share NGTriangleMesh between predefined 3D shapes
        super.setMesh(pgtm);
    }
}
