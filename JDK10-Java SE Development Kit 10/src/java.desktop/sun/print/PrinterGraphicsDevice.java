/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

    String printerID;
    GraphicsConfiguration graphicsConf;

    protected PrinterGraphicsDevice(GraphicsConfiguration conf, String id) {
        printerID = id;
        graphicsConf = conf;
    }

    public int getType() {
        return TYPE_PRINTER;
    }

    public String getIDstring() {
        return printerID;
    }

    public GraphicsConfiguration[] getConfigurations() {
        GraphicsConfiguration[] confs = new GraphicsConfiguration[1];
        confs[0] = graphicsConf;
        return confs;
    }

    public GraphicsConfiguration getDefaultConfiguration() {
        return graphicsConf;
    }

    public void setFullScreenWindow(Window w) {
        // Do nothing
    }

    public Window getFullScreenWindow() {
        return null;
    }
}
