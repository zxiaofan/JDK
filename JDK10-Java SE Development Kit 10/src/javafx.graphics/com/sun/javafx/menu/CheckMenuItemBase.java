/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.menu;

import javafx.beans.property.BooleanProperty;

public interface CheckMenuItemBase extends MenuItemBase {


     /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

    public void setSelected(boolean value);
    public boolean isSelected();
    public BooleanProperty selectedProperty();

}
