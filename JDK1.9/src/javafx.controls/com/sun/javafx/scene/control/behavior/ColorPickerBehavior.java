/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.control.behavior;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.PopupControl;

import javafx.scene.paint.Color;

public class ColorPickerBehavior extends ComboBoxBaseBehavior<Color> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     *
     */
    public ColorPickerBehavior(final ColorPicker colorPicker) {
        super(colorPicker);
    }

     /**************************************************************************
     *                                                                        *
     * Mouse Events                                                           *
     *                                                                        *
     *************************************************************************/

    @Override public void onAutoHide(PopupControl popup) {
        // when we click on some non  interactive part of the
        // Color Palette - we do not want to hide.
        if (!popup.isShowing() && getNode().isShowing()) {
            // Popup was dismissed. Maybe user clicked outside or typed ESCAPE.
            // Make sure DatePicker button is in sync.
            getNode().hide();
        }
        // if the ColorPicker is no longer showing, then invoke the super method
        // to keep its show/hide state in sync.
        if (!getNode().isShowing()) {
            super.onAutoHide(popup);
        }
    }

}
