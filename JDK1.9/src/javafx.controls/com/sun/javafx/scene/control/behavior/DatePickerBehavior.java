/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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

import javafx.scene.control.DatePicker;
import javafx.scene.control.PopupControl;

import java.time.LocalDate;


public class DatePickerBehavior extends ComboBoxBaseBehavior<LocalDate> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     *
     */
    public DatePickerBehavior(final DatePicker datePicker) {
        super(datePicker);
    }

    /***************************************************************************
     *                                                                         *
     * Key event handling                                                      *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override public void onAutoHide(PopupControl popup) {
        // when we click on some non-interactive part of the
        // calendar - we do not want to hide.
        if (!popup.isShowing() && getNode().isShowing()) {
            // Popup was dismissed. Maybe user clicked outside or typed ESCAPE.
            // Make sure DatePicker button is in sync.
            getNode().hide();
        }
        // if the DatePicker is no longer showing, then invoke the super method
        // to keep its show/hide state in sync.
        if (!getNode().isShowing()) {
            super.onAutoHide(popup);
        }
    }

}
