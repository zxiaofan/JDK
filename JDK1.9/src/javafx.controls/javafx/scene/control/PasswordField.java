/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.control;

import javafx.scene.AccessibleAttribute;
import javafx.scene.AccessibleRole;

/**
 * Text field that masks entered characters.
 * @since JavaFX 2.0
 */
public class PasswordField extends TextField {

    /**
     * Creates a default PasswordField instance.
     */
    public PasswordField() {
        getStyleClass().add("password-field");
        setAccessibleRole(AccessibleRole.PASSWORD_FIELD);
    }

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    /**
     * Does nothing for PasswordField.
     */
    @Override public void cut() {
        // No-op
    }

    /**
     * Does nothing for PasswordField.
     */
    @Override public void copy() {
        // No-op
    }


    /***************************************************************************
     *                                                                         *
     * Accessibility handling                                                  *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override
    public Object queryAccessibleAttribute(AccessibleAttribute attribute, Object... parameters) {
        switch (attribute) {
            case TEXT: return null;
            default: return super.queryAccessibleAttribute(attribute, parameters);
        }
    }
}
