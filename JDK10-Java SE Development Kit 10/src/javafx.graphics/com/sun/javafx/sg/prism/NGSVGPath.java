/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.geom.Shape;

/**
 *
 */
public class NGSVGPath extends NGShape {

    private Shape path;

    public void setContent(Object content) {
        path = (Shape)content;
        geometryChanged();
    }

    public Object getGeometry() {
        return path;
    }

    @Override
    public Shape getShape() {
        return path;
    }

    public boolean acceptsPath2dOnUpdate() {
        return true;
    }

}
