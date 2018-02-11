/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.j2d;

import com.sun.glass.ui.Screen;
import com.sun.javafx.font.FontFactory;
import com.sun.prism.GraphicsPipeline;
import com.sun.prism.ResourceFactory;

import java.util.List;
import java.util.HashMap;

public class J2DPipeline extends GraphicsPipeline {
    @Override
    public boolean init() {
        return true;
    }

    private static J2DPipeline theInstance;

    private J2DPipeline() {
    }

    public static J2DPipeline getInstance() {
        if (theInstance == null) {
            theInstance = new J2DPipeline();
        }
        return theInstance;
    }

    private final HashMap<Integer, J2DResourceFactory> factories =
            new HashMap<Integer, J2DResourceFactory>(1);

    @Override
    public int getAdapterOrdinal(Screen screen) {
        return Screen.getScreens().indexOf(screen);
    }

    @Override
    public ResourceFactory getResourceFactory(Screen screen) {
        Integer index = new Integer(screen.getAdapterOrdinal());
        J2DResourceFactory factory = factories.get(index);
        if (factory == null) {
            factory = new J2DResourceFactory(screen);
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
        return false;
    }

    @Override
    public boolean isVsyncSupported() {
        return false;
    }

    @Override
    public boolean supportsShaderType(ShaderType type) {
        return false;
    }

    @Override
    public boolean supportsShaderModel(ShaderModel model) {
        return false;
    }

    @Override
    public void dispose() {
        // TODO: implement (RT-27375)
        super.dispose();
    }

    /*
     * The J2DFontFactory is mostly just a delegate, but as a
     * consequence it gets to listen in on all the requests and
     * intercept them as it needs.
     */
    private FontFactory j2DFontFactory;

    public FontFactory getFontFactory() {
        if (j2DFontFactory == null) {
            FontFactory fontFactory = super.getFontFactory();
            j2DFontFactory = new J2DFontFactory(fontFactory);
        }
        return j2DFontFactory;
    }

    @Override
    public boolean isUploading() {
        return true;
    }
}
