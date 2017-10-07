/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.collections.FloatArraySyncer;
import com.sun.javafx.collections.IntegerArraySyncer;
import com.sun.prism.Mesh;
import com.sun.prism.ResourceFactory;

/**
 * TODO: 3D - Need documentation
 */
public class NGTriangleMesh {
    private boolean meshDirty = true;
    private Mesh mesh;
    private boolean userDefinedNormals = false;

    // points is an array of x,y,z interleaved
    private float[] points;
    private int[] pointsFromAndLengthIndices = new int[2];

    // normals is an array of nx,ny,nz interleaved
    private float[] normals;
    private int[] normalsFromAndLengthIndices = new int[2];

    // texCoords is an array of u,v interleaved
    private float[] texCoords;
    private int[] texCoordsFromAndLengthIndices = new int[2];

    // faces is an array of v1,v2,v3 interleaved (where v = {point, texCoord})
    private int[] faces;
    private int[] facesFromAndLengthIndices = new int[2];

    // faceSmoothingGroups is an array of face smoothing group values
    private int[] faceSmoothingGroups;
    private int[] faceSmoothingGroupsFromAndLengthIndices = new int[2];

    Mesh createMesh(ResourceFactory rf) {
        if (mesh == null) {
            mesh = rf.createMesh();
            meshDirty = true;
        }
        return mesh;
    }

    boolean validate() {
        if (points == null || texCoords == null || faces == null || faceSmoothingGroups == null
                || (userDefinedNormals && (normals == null))) {
            return false;
        }
        if (meshDirty) {
            if (!mesh.buildGeometry(userDefinedNormals,
                    points, pointsFromAndLengthIndices,
                    normals, normalsFromAndLengthIndices,
                    texCoords, texCoordsFromAndLengthIndices,
                    faces, facesFromAndLengthIndices,
                    faceSmoothingGroups, faceSmoothingGroupsFromAndLengthIndices)) {
                throw new RuntimeException("NGTriangleMesh: buildGeometry failed");
            }
            meshDirty = false;
        }
        return true;
    }

    // Note: This method is intentionally made package scope for security
    // reason. It is created for internal use only.
    // Do not make it a public method without careful consideration.
    void setPointsByRef(float[] points) {
        meshDirty = true;
        this.points = points;
    }

    // Note: This method is intentionally made package scope for security
    // reason. It is created for internal use only.
    // Do not make it a public method without careful consideration.
    void setNormalsByRef(float[] normals) {
        meshDirty = true;
        this.normals = normals;
    }

    // Note: This method is intentionally made package scope for security
    // reason. It is created for internal use only.
    // Do not make it a public method without careful consideration.
    void setTexCoordsByRef(float[] texCoords) {
        meshDirty = true;
        this.texCoords = texCoords;
    }

    // Note: This method is intentionally made package scope for security
    // reason. It is created for internal use only.
    // Do not make it a public method without careful consideration.
    void setFacesByRef(int[] faces) {
        meshDirty = true;
        this.faces = faces;
    }

    // Note: This method is intentionally made package scope for security
    // reason. It is created for internal use only.
    // Do not make it a public method without careful consideration.
    void setFaceSmoothingGroupsByRef(int[] faceSmoothingGroups) {
        meshDirty = true;
        this.faceSmoothingGroups = faceSmoothingGroups;
    }

    public void setUserDefinedNormals(boolean userDefinedNormals) {
        this.userDefinedNormals = userDefinedNormals;
    }

    public boolean isUserDefinedNormals() {
        return userDefinedNormals;
    }

    public void syncPoints(FloatArraySyncer array) {
        meshDirty = true;
        points = array != null ? array.syncTo(points, pointsFromAndLengthIndices) : null;
    }

    public void syncNormals(FloatArraySyncer array) {
        meshDirty = true;
        normals = array != null ? array.syncTo(normals, normalsFromAndLengthIndices) : null;
    }

    public void syncTexCoords(FloatArraySyncer array) {
        meshDirty = true;
        texCoords = array != null ? array.syncTo(texCoords, texCoordsFromAndLengthIndices) : null;
    }

    public void syncFaces(IntegerArraySyncer array) {
        meshDirty = true;
        faces = array != null ? array.syncTo(faces, facesFromAndLengthIndices) : null;
    }

    public void syncFaceSmoothingGroups(IntegerArraySyncer array) {
        meshDirty = true;
        faceSmoothingGroups = array != null ? array.syncTo(faceSmoothingGroups, faceSmoothingGroupsFromAndLengthIndices) : null;
    }

    // NOTE: This method is used for unit test purpose only.
    int[] test_getFaceSmoothingGroups() {
        return this.faceSmoothingGroups;
    }
    // NOTE: This method is used for unit test purpose only.
    int[] test_getFaces() {
        return this.faces;
    }
    // NOTE: This method is used for unit test purpose only.
    float[] test_getPoints() {
        return this.points;
    }
    // NOTE: This method is used for unit test purpose only.
    float[] test_getNormals() {
        return this.normals;
    }
    // NOTE: This method is used for unit test purpose only.
    float[] test_getTexCoords() {
        return this.texCoords;
    }
    // NOTE: This method is used for unit test purpose only.
    Mesh test_getMesh() {
        return this.mesh;
    }
}
