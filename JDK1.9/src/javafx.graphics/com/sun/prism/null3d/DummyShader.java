/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.null3d;

import com.sun.prism.ps.Shader;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Map;

public class DummyShader extends DummyResource implements Shader {

    final Map<String, Integer> registers;
    final String name;

    public DummyShader(DummyContext context, String name)
    {
        super(context);
        this.registers = null;
        this.name = name;
    }

    public DummyShader(DummyContext context, Map<String, Integer> registers)
    {
        super(context);
        this.registers = registers;
        this.name = "null";
    }


    public void enable() {
    }

    public void disable() {
    }


    public void setConstant(String name, int i0) {
    }

    public void setConstant(String name, int i0, int i1) {
    }

    public void setConstant(String name, int i0, int i1, int i2) {
    }

    public void setConstant(String name, int i0, int i1, int i2, int i3) {
    }

    public void setConstants(String name, IntBuffer buf, int off, int count) {
    }

    public void setConstant(String name, float f0) {
    }

    public void setConstant(String name, float f0, float f1) {
    }

    public void setConstant(String name, float f0, float f1, float f2) {
    }

    public void setConstant(String name, float f0, float f1, float f2, float f3) {
    }

    public void setConstants(String name, FloatBuffer buf, int off, int count) {
    }


    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void dispose() {
    }
}
