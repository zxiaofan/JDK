/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.glass.ui.Screen;
import com.sun.javafx.PlatformUtil;
import com.sun.prism.GraphicsPipeline;
import com.sun.prism.ResourceFactory;
import com.sun.prism.impl.PrismSettings;

import java.util.List;
import java.util.HashMap;

public class NULL3DPipeline extends GraphicsPipeline {

    static {
        if (PrismSettings.verbose) {
            System.out.println("NULL3DPipeline enabled !");
        }
    }

    static NULL3DPipeline theInstance;

    public static NULL3DPipeline getInstance() {
        if (theInstance == null) {
            theInstance = new NULL3DPipeline();
        }
        return theInstance;
    }

    public boolean init() {
        return true;
    }


    public void dispose() {
    }

    private final HashMap<Integer, DummyResourceFactory> factories =
            new HashMap<Integer, DummyResourceFactory>(1);

    @Override
    public int getAdapterOrdinal(Screen screen) {
        return Screen.getScreens().indexOf(screen);
    }

    @Override
    public ResourceFactory getResourceFactory(Screen screen) {
        Integer index = new Integer(screen.getAdapterOrdinal());
        DummyResourceFactory factory = factories.get(index);
        if (factory == null) {
            factory = new DummyResourceFactory(screen);
            factories.put(index, factory);
        }
        return factory;
    }

    @Override
    public ResourceFactory getDefaultResourceFactory(List<Screen> screens) {
        return getResourceFactory(Screen.getMainScreen());
    }

    @Override
    public boolean is3DSupported() {
        return true;
    }

    @Override
    public boolean isMSAASupported() {
        return true;
    }

    @Override
    public boolean isVsyncSupported() {
        return false;
    }

    @Override
    public boolean supportsShaderType(ShaderType type) {
        switch (type) {
            case HLSL: return PlatformUtil.isWindows();
            case GLSL: return !PlatformUtil.isWindows();
            default: return false;
        }
    }

    @Override
    public boolean supportsShaderModel(ShaderModel model) {
        switch (model) {
            case SM3: return true;
            default: return false;
        }
    }
}
