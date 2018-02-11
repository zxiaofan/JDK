/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene;

import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.scene.NodeHelper;
import com.sun.javafx.scene.PointLightHelper;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javafx.sg.prism.NGPointLight;
import javafx.scene.paint.Color;

/**
 * Defines a point light source object. A light source that has a
 * fixed point in space and radiates light equally in all directions
 * away from itself.
 *
 * @since JavaFX 8.0
 */
public class PointLight extends LightBase {
    static {
        PointLightHelper.setPointLightAccessor(new PointLightHelper.PointLightAccessor() {
            @Override
            public NGNode doCreatePeer(Node node) {
                return ((PointLight) node).doCreatePeer();
            }
        });
    }

    {
        // To initialize the class helper at the begining each constructor of this class
        PointLightHelper.initHelper(this);
    }

    /**
     * Creates a new instance of {@code PointLight} class with a default Color.WHITE light source.
     */
    public PointLight() {
        super();
    }

    /**
     * Creates a new instance of {@code PointLight} class using the specified color.
     *
     * @param color the color of the light source
     */
    public PointLight(Color color) {
        super(color);
    }

    /*
     * Note: This method MUST only be called via its accessor method.
     */
    private NGNode doCreatePeer() {
        return new NGPointLight();
    }
}
