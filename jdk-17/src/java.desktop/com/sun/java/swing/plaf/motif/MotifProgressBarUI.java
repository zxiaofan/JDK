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

package com.sun.java.swing.plaf.motif;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 * A Motif ProgressBarUI.
 *
 * @author Michael C. Albers
 */
public class MotifProgressBarUI extends BasicProgressBarUI
{
    /**
     * Creates the ProgressBar's UI
     */
    public static ComponentUI createUI(JComponent x) {
        return new MotifProgressBarUI();
    }

}
