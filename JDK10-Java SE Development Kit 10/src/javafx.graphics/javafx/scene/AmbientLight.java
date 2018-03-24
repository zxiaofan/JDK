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

import com.sun.javafx.scene.AmbientLightHelper;
import com.sun.javafx.scene.DirtyBits;
import com.sun.javafx.scene.NodeHelper;
import com.sun.javafx.sg.prism.NGAmbientLight;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.paint.Color;

/**
 * Defines an ambient light source object. Ambient light is a light source
 * that seems to come from all directions.
 *
 * @since JavaFX 8.0
 */
public class AmbientLight extends LightBase {
    static {
        AmbientLightHelper.setAmbientLightAccessor(new AmbientLightHelper.AmbientLightAccessor() {
            @Override
            public NGNode doCreatePeer(Node node) {
                return ((AmbientLight) node).doCreatePeer();
            }
        });
    }

    {
        // To initialize the class helper at the begining each constructor of this class
        AmbientLightHelper.initHelper(this);
    }

    /**
     * Creates a new instance of {@code AmbientLight} class with a default Color.WHITE light source.
     */
    public AmbientLight() {
        super();
    }

    /**
     * Creates a new instance of {@code AmbientLight} class using the specified color.
     *
     * @param color the color of the light source
     */
    public AmbientLight(Color color) {
        super(color);
    }

    /*
     * Note: This method MUST only be called via its accessor method.
     */
    private NGNode doCreatePeer() {
        return new NGAmbientLight();
    }
}
