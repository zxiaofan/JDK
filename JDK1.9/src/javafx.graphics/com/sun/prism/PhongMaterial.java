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

package com.sun.prism;

/**
 * TODO: 3D - Need documentation
 * This class represents a phong material for retained mode rendering
 */

public interface PhongMaterial extends Material {

    public enum MapType {DIFFUSE, SPECULAR, BUMP, SELF_ILLUM};
    public static final int DIFFUSE = MapType.DIFFUSE.ordinal();
    public static final int SPECULAR = MapType.SPECULAR.ordinal();
    public static final int BUMP = MapType.BUMP.ordinal();
    public static final int SELF_ILLUM = MapType.SELF_ILLUM.ordinal();
    public static final int MAX_MAP_TYPE = MapType.values().length;

    public void setDiffuseColor(float r, float g, float b, float a);
    public void setSpecularColor(boolean set, float r, float g, float b, float a);

    public void setTextureMap(TextureMap map);

    public void lockTextureMaps();

    public void unlockTextureMaps();
}
