/*
 * Copyright (c) 2008, 2015, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.scene.control.inputmap.InputMap;
import com.sun.javafx.scene.control.inputmap.KeyBinding;
import javafx.scene.control.ToolBar;

import static javafx.scene.input.KeyCode.*;
import static com.sun.javafx.scene.control.inputmap.InputMap.KeyMapping;

/**
 * A Behavior implementation for ToolBars.
 */
public class ToolBarBehavior extends BehaviorBase<ToolBar> {
    private final InputMap<ToolBar> toolBarInputMap;

    public ToolBarBehavior(ToolBar toolbar) {
        super(toolbar);

        // create a map for toolbar-specific mappings (this reuses the default
        // InputMap installed on the control, if it is non-null, allowing us to pick up any user-specified mappings)
        toolBarInputMap = createInputMap();

        // toolbar-specific mappings for key and mouse input
        addDefaultMapping(toolBarInputMap,
            new KeyMapping(new KeyBinding(F5).ctrl(), e -> {
                if (!toolbar.getItems().isEmpty()) {
                    toolbar.getItems().get(0).requestFocus();
                }
            })
        );
    }

    @Override public InputMap<ToolBar> getInputMap() {
        return toolBarInputMap;
    }
}

