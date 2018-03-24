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

package javafx.scene.shape;

import java.util.HashMap;

final class PredefinedMeshManager {

    private static final PredefinedMeshManager INSTANCE = new PredefinedMeshManager();
    private static final int INITAL_CAPACITY = 17; // TODO
    private static final float LOAD_FACTOR = 0.75f;

    private HashMap<Integer, TriangleMesh> boxCache = null;
    private HashMap<Integer, TriangleMesh> sphereCache = null;
    private HashMap<Integer, TriangleMesh> cylinderCache = null;

    private PredefinedMeshManager() {}

    static PredefinedMeshManager getInstance() {
        return INSTANCE;
    }

    synchronized TriangleMesh getBoxMesh(float w, float h, float d, int key) {
        if (boxCache == null) {
            boxCache = BoxCacheLoader.INSTANCE;
        }

        TriangleMesh mesh = boxCache.get(key);
        if (mesh == null) {
            mesh = Box.createMesh(w, h, d);
            boxCache.put(key, mesh);
        } else {
            mesh.incRef();
        }
        return mesh;
    }

    synchronized TriangleMesh getSphereMesh(float r, int div, int key) {
        if (sphereCache == null) {
            sphereCache = SphereCacheLoader.INSTANCE;
        }

        TriangleMesh mesh = sphereCache.get(key);
        if (mesh == null) {
            mesh = Sphere.createMesh(div, r);
            sphereCache.put(key, mesh);
        } else {
            mesh.incRef();
        }
        return mesh;
    }

    synchronized TriangleMesh getCylinderMesh(float h, float r, int div, int key) {
        if (cylinderCache == null) {
            cylinderCache = CylinderCacheLoader.INSTANCE;
        }

        TriangleMesh mesh = cylinderCache.get(key);
        if (mesh == null) {
            mesh = Cylinder.createMesh(div, h, r);
            cylinderCache.put(key, mesh);
        } else {
            mesh.incRef();
        }
        return mesh;
    }

    synchronized void invalidateBoxMesh(int key) {
        if (boxCache != null) {
            TriangleMesh mesh = boxCache.get(key);
            if (mesh != null) {
                mesh.decRef();
                int count = mesh.getRefCount();
                if (count == 0) {
                    boxCache.remove(key);
                }
            }
        }
    }

    synchronized void invalidateSphereMesh(int key) {
        if (sphereCache != null) {
            TriangleMesh mesh = sphereCache.get(key);
            if (mesh != null) {
                mesh.decRef();
                int count = mesh.getRefCount();
                if (count == 0) {
                    sphereCache.remove(key);
                }
            }
        }
    }

    synchronized void invalidateCylinderMesh(int key) {
        if (cylinderCache != null) {
            TriangleMesh mesh = cylinderCache.get(key);
            if (mesh != null) {
                mesh.decRef();
                int count = mesh.getRefCount();
                if (count == 0) {
                    cylinderCache.remove(key);
                }
            }
        }
    }

    synchronized void dispose() {
        // just clearing references to them
        if (boxCache != null) {
            boxCache.clear();
        }
        if (sphereCache != null) {
            sphereCache.clear();
        }
        if (cylinderCache != null) {
            cylinderCache.clear();
        }
    }

    // for testing purpose
    synchronized void printStats() {
        if (boxCache != null) {
            System.out.println("BoxCache size:  " +  boxCache.size());
        }

        if (sphereCache != null) {
            System.out.println("SphereCache size:    " + sphereCache.size());
        }

        if (cylinderCache != null) {
            System.out.println("CylinderCache size:    " + cylinderCache.size());
        }
    }

    private final static class BoxCacheLoader {

        // lazy & thread-safe instantiation
        private static final HashMap<Integer, TriangleMesh>
                INSTANCE = new HashMap<Integer, TriangleMesh>(INITAL_CAPACITY, LOAD_FACTOR);
    }

    private final static class SphereCacheLoader {

        // lazy & thread-safe instantiation
        private static final HashMap<Integer, TriangleMesh>
                INSTANCE = new HashMap<Integer, TriangleMesh>(INITAL_CAPACITY, LOAD_FACTOR);
    }

    private final static class CylinderCacheLoader {

        // lazy & thread-safe instantiation
        private static final HashMap<Integer, TriangleMesh>
                INSTANCE = new HashMap<Integer, TriangleMesh>(INITAL_CAPACITY, LOAD_FACTOR);
    }

};
