/*
 * Copyright (c) 2004, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.Window;

public final class PrinterGraphicsDevice extends GraphicsDevice {

    private final String printerID;
    private final GraphicsConfiguration config;

    PrinterGraphicsDevice(GraphicsConfiguration conf, String id) {
        printerID = id;
        config = conf;
    }

    @Override
    public int getType() {
        return TYPE_PRINTER;
    }

    @Override
    public String getIDstring() {
        return printerID;
    }

    @Override
    public GraphicsConfiguration[] getConfigurations() {
        return new GraphicsConfiguration[]{config};
    }

    @Override
    public GraphicsConfiguration getDefaultConfiguration() {
        return config;
    }

    @Override
    public void setFullScreenWindow(Window w) {
        // Do nothing
    }

    @Override
    public Window getFullScreenWindow() {
        return null;
    }
}
