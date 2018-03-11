/*
 * ToolBarNorthState.java %E%
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.java.swing.plaf.nimbus;

import java.awt.*;
import javax.swing.*;

/**
 */
class ToolBarNorthState extends State {
    ToolBarNorthState() {
        super("North");
    }

    @Override protected boolean isInState(JComponent c) {

        JToolBar toolbar = (JToolBar)c;
        return NimbusLookAndFeel.resolveToolbarConstraint(toolbar) == BorderLayout.NORTH;
               
    }
}

