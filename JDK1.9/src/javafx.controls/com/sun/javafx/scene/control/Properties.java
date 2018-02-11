/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.scene.control.skin.resources.ControlResources;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;

public class Properties {

    /***************************************************************************
     *
     * SkinBase
     *
     **************************************************************************/

    /**
     * A static final reference to whether the platform we are on supports touch.
     */
    public final static boolean IS_TOUCH_SUPPORTED = Platform.isSupported(ConditionalFeature.INPUT_TOUCH);




    /***************************************************************************
     *
     * ButtonBar
     *
     **************************************************************************/

    // represented as a ButtonData
    public static final String BUTTON_DATA_PROPERTY  = "javafx.scene.control.ButtonBar.ButtonData"; //$NON-NLS-1$

    // allows to exclude button from uniform resizing
    public static final String BUTTON_SIZE_INDEPENDENCE = "javafx.scene.control.ButtonBar.independentSize"; //$NON-NLS-1$



    /***************************************************************************
     *
     * ComboBox
     *
     **************************************************************************/

    public static final String COMBO_BOX_STYLE_CLASS = "combo-box-popup";



    /***************************************************************************
     *
     * ColorPicker
     *
     **************************************************************************/

    public static String getColorPickerString(String key) {
        return ControlResources.getString("ColorPicker." + key);
    }



    /***************************************************************************
     *
     * ListView, TableView
     *
     **************************************************************************/

    public static final String REFRESH = "refreshKey";
    public static final String RECREATE = "recreateKey";



    /***************************************************************************
     *
     * ScrollBar
     *
     **************************************************************************/

    public final static int DEFAULT_LENGTH = 100;
    public final static int DEFAULT_WIDTH = 20;
    public static final double DEFAULT_EMBEDDED_SB_BREADTH = 8.0;



    /***************************************************************************
     *
     * TableCell
     *
     **************************************************************************/
    // This property is set on the cell when we want to know its actual
    // preferred width, not the width of the associated TableColumn.
    // This is primarily used in NestedTableColumnHeader such that user double
    // clicks result in the column being resized to fit the widest content in
    // the column
    // FIXME make package-protected before merging into main repo
    public static final String DEFER_TO_PARENT_PREF_WIDTH = "deferToParentPrefWidth";
}
