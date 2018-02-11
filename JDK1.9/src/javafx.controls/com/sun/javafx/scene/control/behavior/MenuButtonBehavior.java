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

import javafx.scene.control.MenuButton;

import static com.sun.javafx.scene.control.inputmap.InputMap.KeyMapping;
import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.SPACE;

/**
 * Behavior for MenuButton.
 */
public class MenuButtonBehavior extends MenuButtonBehaviorBase<MenuButton> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a new MenuButtonBehavior for the given MenuButton.
     *
     * @param menuButton the MenuButton
     */
    public MenuButtonBehavior(final MenuButton menuButton) {
        super(menuButton);

        /**
         * The key bindings for the MenuButton. Sets up the keys to open the menu.
         */
        addDefaultMapping(new KeyMapping(SPACE, e -> openAction()));
        addDefaultMapping(new KeyMapping(ENTER, e -> openAction()));
    }
}
