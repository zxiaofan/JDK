/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf;

import javax.swing.JComboBox;

/**
 * Pluggable look and feel interface for JComboBox.
 *
 * @author Arnaud Weber
 * @author Tom Santos
 */
public abstract class ComboBoxUI extends ComponentUI {

    /**
     * Constructor for subclasses to call.
     */
    protected ComboBoxUI() {}

    /**
     * Set the visibility of the popup
     *
     * @param c a {@code JComboBox}
     * @param v a {@code boolean} determining the visibilty of the popup
     */
    public abstract void setPopupVisible( JComboBox<?> c, boolean v );

    /**
     * Determine the visibility of the popup
     *
     * @param c a {@code JComboBox}
     * @return true if popup of the {@code JComboBox} is visible
     */
    public abstract boolean isPopupVisible( JComboBox<?> c );

    /**
     * Determine whether or not the combo box itself is traversable
     *
     * @param c a {@code JComboBox}
     * @return true if the given {@code JComboBox} is traversable
     */
    public abstract boolean isFocusTraversable( JComboBox<?> c );
}
