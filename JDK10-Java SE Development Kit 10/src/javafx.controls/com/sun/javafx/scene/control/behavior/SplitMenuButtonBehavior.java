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

import javafx.scene.control.SplitMenuButton;
import com.sun.javafx.scene.control.inputmap.InputMap;

import static javafx.scene.input.KeyCode.ENTER;
import static javafx.scene.input.KeyCode.SPACE;
import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import static javafx.scene.input.KeyEvent.KEY_RELEASED;

/**
 * Behavior for SplitMenuButton.
 */
public class SplitMenuButtonBehavior extends MenuButtonBehaviorBase<SplitMenuButton> {

    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a new SplitMenuButtonBehavior for the given SplitMenuButton.
     *
     * @param splitMenuButton the SplitMenuButton
     */
    public SplitMenuButtonBehavior(final SplitMenuButton splitMenuButton) {
        super(splitMenuButton);

        /**
         * The key bindings for the SplitMenuButton. Sets the Enter key as the means
         * to open the menu and the space key as the means to activate the action.
         */
        addDefaultMapping(new InputMap.KeyMapping(SPACE, KEY_PRESSED, this::keyPressed));
        addDefaultMapping(new InputMap.KeyMapping(SPACE, KEY_RELEASED, this::keyReleased));
        addDefaultMapping(new InputMap.KeyMapping(ENTER, KEY_PRESSED, this::keyPressed));
        addDefaultMapping(new InputMap.KeyMapping(ENTER, KEY_RELEASED, this::keyReleased));
    }

    /***************************************************************************
     *                                                                         *
     * Key event handling                                                      *
     *                                                                         *
     **************************************************************************/

//    /**
//     * The key bindings for the SplitMenuButton. Sets the Enter key as the means
//     * to open the menu and the space key as the means to activate the action.
//     */
//    protected static final List<KeyBinding> SPLIT_MENU_BUTTON_BINDINGS = new ArrayList<KeyBinding>();
//    static {
//        SPLIT_MENU_BUTTON_BINDINGS.addAll(BASE_MENU_BUTTON_BINDINGS);
//
//        SPLIT_MENU_BUTTON_BINDINGS.add(new KeyBinding(SPACE, KEY_PRESSED, "Press"));
//        SPLIT_MENU_BUTTON_BINDINGS.add(new KeyBinding(SPACE, KEY_RELEASED, "Release"));
//
//        SPLIT_MENU_BUTTON_BINDINGS.add(new KeyBinding(ENTER, KEY_PRESSED,  "Press"));
//        SPLIT_MENU_BUTTON_BINDINGS.add(new KeyBinding(ENTER, KEY_RELEASED, "Release"));
//    }
}
