/*
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf.basic;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;


/**
 * BasicViewport implementation
 *
 * @author Rich Schiavi
 */
public class BasicViewportUI extends ViewportUI {

    // Shared UI object
    private static ViewportUI viewportUI;

    /**
     * Constructs a {@code BasicViewportUI}.
     */
    public BasicViewportUI() {}

    /**
     * Returns an instance of {@code BasicViewportUI}.
     *
     * @param c a component
     * @return an instance of {@code BasicViewportUI}
     */
    public static ComponentUI createUI(JComponent c) {
        if(viewportUI == null) {
            viewportUI = new BasicViewportUI();
        }
        return viewportUI;
    }

    public void installUI(JComponent c) {
        super.installUI(c);
        installDefaults(c);
    }

    public void uninstallUI(JComponent c) {
        uninstallDefaults(c);
        super.uninstallUI(c);
    }

    /**
     * Installs view port properties.
     *
     * @param c a component
     */
    protected void installDefaults(JComponent c) {
        LookAndFeel.installColorsAndFont(c,
                                         "Viewport.background",
                                         "Viewport.foreground",
                                         "Viewport.font");
        LookAndFeel.installProperty(c, "opaque", Boolean.TRUE);
    }

    /**
     * Uninstall view port properties.
     *
     * @param c a component
     */
    protected void uninstallDefaults(JComponent c) {
    }
}
