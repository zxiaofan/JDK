/*
 * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.java.swing.plaf.windows;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

/**
 * Windows rendition of the component.
 */
public class WindowsSplitPaneUI extends BasicSplitPaneUI
{

    public WindowsSplitPaneUI() {
        super();
    }

    /**
      * Creates a new WindowsSplitPaneUI instance
      */
    public static ComponentUI createUI(JComponent x) {
        return new WindowsSplitPaneUI();
    }

    /**
      * Creates the default divider.
      */
    public BasicSplitPaneDivider createDefaultDivider() {
        return new WindowsSplitPaneDivider(this);
    }

}
