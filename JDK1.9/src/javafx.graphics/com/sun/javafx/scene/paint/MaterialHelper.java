/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.paint;

import com.sun.javafx.sg.prism.NGPhongMaterial;
import com.sun.javafx.util.Utils;
import javafx.beans.property.BooleanProperty;
import javafx.scene.paint.Material;


/**
 * Used to access internal methods of Material.
 */
public class MaterialHelper {

    private static MaterialAccessor materialAccessor;

    static {
        Utils.forceInit(Material.class);
    }

    private MaterialHelper() {
    }

    public static BooleanProperty dirtyProperty(Material material) {
        return materialAccessor.dirtyProperty(material);
    }

    public static void updatePG(Material material) {
        materialAccessor.updatePG(material);
    }

    public static NGPhongMaterial getNGMaterial(Material material) {
        return materialAccessor.getNGMaterial(material);
    }

    public static void setMaterialAccessor(final MaterialAccessor newAccessor) {
        if (materialAccessor != null) {
            throw new IllegalStateException();
        }

        materialAccessor = newAccessor;
    }

    public interface MaterialAccessor {
        BooleanProperty dirtyProperty(Material material);
        void updatePG(Material material);
        NGPhongMaterial getNGMaterial(Material material);
    }

}
