/*
 * InternalFrameInternalFrameTitlePaneWindowFocusedState.java %E%
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.java.swing.plaf.nimbus;

import java.awt.*;
import javax.swing.*;

/**
 */
class InternalFrameInternalFrameTitlePaneWindowFocusedState extends State {
    InternalFrameInternalFrameTitlePaneWindowFocusedState() {
        super("WindowFocused");
    }

    @Override protected boolean isInState(JComponent c) {

                         return c instanceof JInternalFrame && ((JInternalFrame)c).isSelected();
    }
}

