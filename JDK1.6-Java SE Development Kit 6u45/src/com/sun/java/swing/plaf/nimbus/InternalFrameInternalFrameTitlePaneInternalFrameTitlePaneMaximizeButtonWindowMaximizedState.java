/*
 * InternalFrameInternalFrameTitlePaneInternalFrameTitlePaneMaximizeButtonWindowMaximizedState.java %E%
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.java.swing.plaf.nimbus;

import java.awt.*;
import javax.swing.*;

/**
 */
class InternalFrameInternalFrameTitlePaneInternalFrameTitlePaneMaximizeButtonWindowMaximizedState extends State {
    InternalFrameInternalFrameTitlePaneInternalFrameTitlePaneMaximizeButtonWindowMaximizedState() {
        super("WindowMaximized");
    }

    @Override protected boolean isInState(JComponent c) {

                               Component parent = c;
                               while (parent.getParent() != null) {
                                   if (parent instanceof JInternalFrame) {
                                       break;
                                   }
                                   parent = parent.getParent();
                               }
                               if (parent instanceof JInternalFrame) {
                                   return ((JInternalFrame)parent).isMaximum();
                               }
                               return false;
    }
}

