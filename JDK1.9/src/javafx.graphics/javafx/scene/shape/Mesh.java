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

package javafx.scene.shape;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.scene.shape.MeshHelper;
import com.sun.javafx.sg.prism.NGTriangleMesh;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import sun.util.logging.PlatformLogger;

/**
 * Base class for representing a 3D geometric surface.
 *
 * Note that this is a conditional feature. See
 * {@link javafx.application.ConditionalFeature#SCENE3D ConditionalFeature.SCENE3D}
 * for more information.
 *
 * @since JavaFX 8.0
 */
public abstract class Mesh {

    /*
     * Store the singleton instance of the MeshHelper subclass corresponding
     * to the subclass of this instance of Mesh
     */
    private MeshHelper meshHelper = null;

    static {
        // This is used by classes in different packages to get access to
        // private and package private methods.
        MeshHelper.setMeshAccessor(new MeshHelper.MeshAccessor() {
            @Override
            public MeshHelper getHelper(Mesh mesh) {
                return mesh.meshHelper;
            }

            @Override
            public void setHelper(Mesh mesh, MeshHelper meshHelper) {
                mesh.meshHelper = meshHelper;
            }
        });
    }

    protected Mesh() {
        if (!Platform.isSupported(ConditionalFeature.SCENE3D)) {
            String logname = Mesh.class.getName();
            PlatformLogger.getLogger(logname).warning("System can't support "
                                                      + "ConditionalFeature.SCENE3D");
        }
    }

    // Mesh isn't a Node. It can't use the standard dirtyBits pattern that is
    // in Node
    // TODO: 3D - Material and Mesh have similar pattern. We should look into creating
    // a "NodeComponent" class if more non-Node classes are needed.

    // Material isn't a Node. It can't use the standard dirtyBits pattern that is
    // in Node
    private final BooleanProperty dirty = new SimpleBooleanProperty(true);

    final boolean isDirty() {
        return dirty.getValue();
    }

    void setDirty(boolean value) {
        dirty.setValue(value);
    }

    final BooleanProperty dirtyProperty() {
        return dirty;
    }

    // We only support one type of mesh for FX 8.
    abstract NGTriangleMesh getPGMesh();
    abstract void updatePG();

    abstract BaseBounds computeBounds(BaseBounds b);

}
