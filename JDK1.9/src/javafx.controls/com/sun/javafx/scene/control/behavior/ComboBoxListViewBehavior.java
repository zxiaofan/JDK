/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
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

import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.SelectionModel;
import com.sun.javafx.scene.control.inputmap.InputMap;

import static javafx.scene.input.KeyCode.DOWN;
import static javafx.scene.input.KeyCode.UP;

public class ComboBoxListViewBehavior<T> extends ComboBoxBaseBehavior<T> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     *
     */
    public ComboBoxListViewBehavior(final ComboBox<T> comboBox) {
        super(comboBox);

        // Add these bindings as a child input map, so they take precedence
        InputMap<ComboBoxBase<T>> comboBoxListViewInputMap = new InputMap<>(comboBox);
        comboBoxListViewInputMap.getMappings().addAll(
            new InputMap.KeyMapping(UP, e -> selectPrevious()),
            new InputMap.KeyMapping(DOWN, e -> selectNext())
        );
        addDefaultChildMap(getInputMap(), comboBoxListViewInputMap);
    }

    /***************************************************************************
     *                                                                         *
     * Key event handling                                                      *
     *                                                                         *
     **************************************************************************/

    private ComboBox<T> getComboBox() {
        return (ComboBox<T>) getNode();
    }

    private void selectPrevious() {
        SelectionModel<T> sm = getComboBox().getSelectionModel();
        if (sm == null) return;
        sm.selectPrevious();
    }

    private void selectNext() {
        SelectionModel<T> sm = getComboBox().getSelectionModel();
        if (sm == null) return;
        sm.selectNext();
    }
}
