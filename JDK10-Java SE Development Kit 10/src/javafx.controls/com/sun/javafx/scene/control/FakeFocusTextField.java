/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.javafx.scene.control;

import javafx.scene.AccessibleAttribute;
import javafx.scene.control.TextField;

public final class FakeFocusTextField extends TextField {

    @Override public void requestFocus() {
        if (getParent() != null) {
            getParent().requestFocus();
        }
    }

    public void setFakeFocus(boolean b) {
        setFocused(b);
    }

    /** {@inheritDoc} */
    @Override
    public Object queryAccessibleAttribute(AccessibleAttribute attribute, Object... parameters) {
        switch (attribute) {
            case FOCUS_ITEM:
                /* Internally comboBox reassign its focus the text field.
                 * For the accessibility perspective it is more meaningful
                 * if the focus stays with the comboBox control.
                 */
                return getParent();
            default: return super.queryAccessibleAttribute(attribute, parameters);
        }
    }
}
