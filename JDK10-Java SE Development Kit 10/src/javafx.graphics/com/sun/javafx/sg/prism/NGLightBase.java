/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.geom.transform.Affine3D;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.prism.Graphics;
import com.sun.prism.paint.Color;

/**
 * TODO: 3D - Need documentation
 */
public class NGLightBase extends NGNode {

    // The default color is Color.WHITE
    private Color color = Color.WHITE;
    private boolean lightOn = true;
    private Affine3D worldTransform;

    protected NGLightBase() {
    }

    @Override
    public void setTransformMatrix(BaseTransform tx) {
        super.setTransformMatrix(tx);
    }

    @Override
    protected void doRender(Graphics g) {}

    @Override protected void renderContent(Graphics g) {}

    @Override protected boolean hasOverlappingContents() {
        return false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Object value) {
        // Null check is done on the scenegraph side,
        // by design value can never be null.
        if (!this.color.equals(value)) {
            this.color = (Color)value;
            visualsChanged();
        }
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public void setLightOn(boolean value) {
        if (lightOn != value) {
            visualsChanged();
            lightOn = value;
        }
    }

    public Affine3D getWorldTransform() {
        return worldTransform;
    }

    public void setWorldTransform(Affine3D localToSceneTx) {
        // TODO: 3D worldTransform is reference to the FX light transform,
        // which is incorrect. Uncomment below to fix problem. Requires sync
        // to be called at the correct time by FX light
//        if (this.worldTransform == null ||
//                !this.worldTransform.equals(localToSceneTx)) {
//        this.worldTransform.setTransform(localToSceneTx);
//            visualsChanged();
//        }
        this.worldTransform = localToSceneTx;
    }

    Object scopedNodes[] = null;

    public void setScope(Object[] scopedNodes) {
        if (this.scopedNodes != scopedNodes) {
            this.scopedNodes = scopedNodes;
            visualsChanged();
        }
    }

    final boolean affects(NGShape3D n3d) {
        if (!lightOn) {
            return false;
        } else if (scopedNodes == null) {
            return true;
        } else {
            for (int i = 0; i < scopedNodes.length; i++) {
                Object scopedNode = scopedNodes[i];
                if (scopedNode instanceof NGGroup) {
                    NGNode parent = n3d.getParent();
                    while (parent != null) {
                        if (scopedNode == parent) {
                            return true;
                        }
                        parent = parent.getParent();
                    }
                } else if (scopedNode == n3d) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void release() {
        // TODO: 3D - Need to release native resources
    }
}
