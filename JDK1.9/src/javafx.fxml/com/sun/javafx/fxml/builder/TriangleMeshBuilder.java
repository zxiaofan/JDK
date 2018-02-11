/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.fxml.builder;

import javafx.scene.shape.TriangleMesh;
import javafx.scene.shape.VertexFormat;
import javafx.util.Builder;

import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TriangleMeshBuilder extends TreeMap<String, Object> implements Builder<TriangleMesh> {

    private static final String VALUE_SEPARATOR_REGEX = "[,\\s]+";

    private float[] points;
    private float[] texCoords;
    private float[] normals;
    private int[] faces;
    private int[] faceSmoothingGroups;
    private VertexFormat vertexFormat;

    @Override
    public TriangleMesh build() {
        TriangleMesh mesh = new TriangleMesh();
        if (points != null) {
            mesh.getPoints().setAll(points);
        }
        if (texCoords != null) {
            mesh.getTexCoords().setAll(texCoords);
        }
        if (faces != null) {
            mesh.getFaces().setAll(faces);
        }
        if (faceSmoothingGroups != null) {
            mesh.getFaceSmoothingGroups().setAll(faceSmoothingGroups);
        }
        if (normals != null) {
            mesh.getNormals().setAll(normals);
        }
        if (vertexFormat != null) {
            mesh.setVertexFormat(vertexFormat);
        }
        return mesh;
    }

    @Override
    public Object put(String key, Object value) {

        if ("points".equalsIgnoreCase(key)) {
            String[] split = ((String) value).split(VALUE_SEPARATOR_REGEX);
            points = new float[split.length];
            for (int i = 0; i < split.length; ++i) {
                points[i] = Float.parseFloat(split[i]);
            }
        } else if ("texcoords".equalsIgnoreCase(key)) {
            String[] split = ((String) value).split(VALUE_SEPARATOR_REGEX);
            texCoords = new float[split.length];
            for (int i = 0; i < split.length; ++i) {
                texCoords[i] = Float.parseFloat(split[i]);
            }
        } else if ("faces".equalsIgnoreCase(key)) {
            String[] split = ((String) value).split(VALUE_SEPARATOR_REGEX);
            faces = new int[split.length];
            for (int i = 0; i < split.length; ++i) {
                faces[i] = Integer.parseInt(split[i]);
            }
        } else if ("facesmoothinggroups".equalsIgnoreCase(key)) {
            String[] split = ((String) value).split(VALUE_SEPARATOR_REGEX);
            faceSmoothingGroups = new int[split.length];
            for (int i = 0; i < split.length; ++i) {
                faceSmoothingGroups[i] = Integer.parseInt(split[i]);
            }
        } else if ("normals".equalsIgnoreCase(key)) {
            String[] split = ((String) value).split(VALUE_SEPARATOR_REGEX);
            normals = new float[split.length];
            for (int i = 0; i < split.length; ++i) {
                normals[i] = Float.parseFloat(split[i]);
            }
        } else if ("vertexformat".equalsIgnoreCase(key)) {
            if (value instanceof VertexFormat) {
                vertexFormat = (VertexFormat) value;
            } else if ("point_texcoord".equalsIgnoreCase((String)value)) {
                vertexFormat = VertexFormat.POINT_TEXCOORD;
            } else if ("point_normal_texcoord".equalsIgnoreCase((String)value)) {
                vertexFormat = VertexFormat.POINT_NORMAL_TEXCOORD;
            }
        }

        return super.put(key.toLowerCase(Locale.ROOT), value);
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return super.entrySet();
    }

}
