/*
 * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.web.behavior;

import com.sun.javafx.scene.ParentHelper;
import com.sun.javafx.scene.control.behavior.BehaviorBase;
import com.sun.javafx.scene.control.inputmap.InputMap;
import com.sun.javafx.scene.control.inputmap.KeyBinding;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.HTMLEditorSkin;
import com.sun.javafx.scene.control.behavior.FocusTraversalInputMap;

import static javafx.scene.input.KeyCode.*;
import static com.sun.javafx.scene.control.inputmap.InputMap.KeyMapping;

/**
 * HTML editor behavior.
 */
public class HTMLEditorBehavior extends BehaviorBase<HTMLEditor> {
    private final InputMap<HTMLEditor> inputMap;

    public HTMLEditorBehavior(HTMLEditor htmlEditor) {
        super(htmlEditor);

        this.inputMap = createInputMap();
        addDefaultMapping(inputMap,
            new KeyMapping(new KeyBinding(B).shortcut(), e -> keyboardShortcuts(HTMLEditorSkin.Command.BOLD)),
            new KeyMapping(new KeyBinding(I).shortcut(), e -> keyboardShortcuts(HTMLEditorSkin.Command.ITALIC)),
            new KeyMapping(new KeyBinding(U).shortcut(), e -> keyboardShortcuts(HTMLEditorSkin.Command.UNDERLINE)),

            new KeyMapping(new KeyBinding(F12), e -> ParentHelper.getTraversalEngine(getNode()).selectFirst().requestFocus()),
            new KeyMapping(new KeyBinding(TAB).ctrl(), FocusTraversalInputMap::traverseNext),
            new KeyMapping(new KeyBinding(TAB).ctrl().shift(), FocusTraversalInputMap::traversePrevious)
        );
    }

    @Override public InputMap<HTMLEditor> getInputMap() {
        return inputMap;
    }

    private void keyboardShortcuts(HTMLEditorSkin.Command command) {
        HTMLEditor editor = getNode();
        HTMLEditorSkin editorSkin = (HTMLEditorSkin)editor.getSkin();
        editorSkin.performCommand(command);
    }
}
