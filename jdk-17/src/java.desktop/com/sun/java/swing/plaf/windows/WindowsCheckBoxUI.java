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

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

import sun.awt.AppContext;

/**
 * Windows check box.
 *
 * @author Jeff Dinkins
 */
public class WindowsCheckBoxUI extends WindowsRadioButtonUI
{
    // NOTE: MetalCheckBoxUI inherts from MetalRadioButtonUI instead
    // of BasicCheckBoxUI because we want to pick up all the
    // painting changes made in MetalRadioButtonUI.

    private static final Object WINDOWS_CHECK_BOX_UI_KEY = new Object();

    private static final String propertyPrefix = "CheckBox" + ".";

    private boolean defaults_initialized = false;

    // ********************************
    //          Create PLAF
    // ********************************
    public static ComponentUI createUI(JComponent c) {
        AppContext appContext = AppContext.getAppContext();
        WindowsCheckBoxUI windowsCheckBoxUI =
                (WindowsCheckBoxUI) appContext.get(WINDOWS_CHECK_BOX_UI_KEY);
        if (windowsCheckBoxUI == null) {
            windowsCheckBoxUI = new WindowsCheckBoxUI();
            appContext.put(WINDOWS_CHECK_BOX_UI_KEY, windowsCheckBoxUI);
        }
        return windowsCheckBoxUI;
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

    public void uninstallDefaults(AbstractButton b) {
        super.uninstallDefaults(b);
        defaults_initialized = false;
    }

}
