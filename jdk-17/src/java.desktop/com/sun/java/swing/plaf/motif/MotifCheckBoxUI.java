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

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

import sun.awt.AppContext;

/**
 * MotifCheckBox implementation
 *
 * @author Rich Schiavi
 */
public class MotifCheckBoxUI extends MotifRadioButtonUI {

    private static final Object MOTIF_CHECK_BOX_UI_KEY = new Object();

    private static final String propertyPrefix = "CheckBox" + ".";

    private boolean defaults_initialized = false;


    // ********************************
    //         Create PLAF
    // ********************************
    public static ComponentUI createUI(JComponent c) {
        AppContext appContext = AppContext.getAppContext();
        MotifCheckBoxUI motifCheckBoxUI =
                (MotifCheckBoxUI) appContext.get(MOTIF_CHECK_BOX_UI_KEY);
        if (motifCheckBoxUI == null) {
            motifCheckBoxUI = new MotifCheckBoxUI();
            appContext.put(MOTIF_CHECK_BOX_UI_KEY, motifCheckBoxUI);
        }
        return motifCheckBoxUI;
    }

    public String getPropertyPrefix() {
        return propertyPrefix;
    }

    // ********************************
    //          Defaults
    // ********************************
    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        if(!defaults_initialized) {
            icon = UIManager.getIcon(getPropertyPrefix() + "icon");
            defaults_initialized = true;
        }
    }

    protected void uninstallDefaults(AbstractButton b) {
        super.uninstallDefaults(b);
        defaults_initialized = false;
    }
}
