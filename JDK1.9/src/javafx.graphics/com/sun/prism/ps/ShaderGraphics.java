/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.ps;

import com.sun.javafx.geom.transform.Affine3D;
import com.sun.prism.Graphics;
import com.sun.prism.Texture;

public interface ShaderGraphics extends Graphics {

    public void getPaintShaderTransform(Affine3D ret);

    public void setExternalShader(Shader shader);

    public void drawTextureRaw2(Texture src1, Texture src2,
                                float dx1, float dy1, float dx2, float dy2,
                                float t1x1, float t1y1, float t1x2, float t1y2,
                                float t2x1, float t2y1, float t2x2, float t2y2);

    public void drawMappedTextureRaw2(Texture src1, Texture src2,
                                      float dx1, float dy1, float dx2, float dy2,
                                      float t1x11, float t1y11, float t1x21, float t1y21,
                                      float t1x12, float t1y12, float t1x22, float t1y22,
                                      float t2x11, float t2y11, float t2x21, float t2y21,
                                      float t2x12, float t2y12, float t2x22, float t2y22);
}
