/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import com.sun.glass.events.KeyEvent;

/**
 * KeyState is a snapshot of pressed keys
 * KeyState is used both to store the current state of key input and to
 * describe changes to that state.
 */
class KeyState {

    private IntSet keysPressed = new IntSet();
    private MonocleWindow window;
    private int modifiers;

    /** Removes all pressed keys from this state object. */
    void clear() {
        keysPressed.clear();
        modifiers = 0;
    }

    /** Adds a key to the set of pressed keys. */
    void pressKey(int virtualKeyCode) {
        keysPressed.addInt(virtualKeyCode);
        modifiers |= getModifier(virtualKeyCode);
    }

    /** Removes a key from the set of pressed keys. */
    void releaseKey(int virtualKeyCode) {
        keysPressed.removeInt(virtualKeyCode);
        modifiers &= ~getModifier(virtualKeyCode);
    }

    /** Copies the contents of this state object to another.
     *
     * @param target The KeyState to which to copy this state's data.
     */
    void copyTo(KeyState target) {
        keysPressed.copyTo(target.keysPressed);
        target.window = window;
        target.modifiers = modifiers;
    }

    /** Returns the set of pressed key codes
     *
     * @return an IntSet containing the key codes of pressed keys
     */
    IntSet getKeysPressed() {
        return keysPressed;
    }

    /** Returns the Glass window on which this event state is located . */
    MonocleWindow getWindow(boolean recalculateCache) {
        if (window == null || recalculateCache) {
            window = (MonocleWindow)
                    MonocleWindowManager.getInstance().getFocusedWindow();
        }
        return window;
    }

    private static int getModifier(int virtualKeyCode) {
        switch (virtualKeyCode) {
            case KeyEvent.VK_SHIFT: return KeyEvent.MODIFIER_SHIFT;
            case KeyEvent.VK_CONTROL: return KeyEvent.MODIFIER_CONTROL;
            case KeyEvent.VK_ALT: return KeyEvent.MODIFIER_ALT;
            case KeyEvent.VK_COMMAND: return KeyEvent.MODIFIER_COMMAND;
            case KeyEvent.VK_WINDOWS: return KeyEvent.MODIFIER_WINDOWS;
            default: return KeyEvent.MODIFIER_NONE;
        }
    }

    /** Returns a mask of modifiers defined in KeyEvent for the keys pressed
     * in this state.
     *
     * @return a mask of KeyEvent modifiers
     */
    int getModifiers() {
        return modifiers;
    }

    boolean isShiftPressed() {
        return (modifiers & KeyEvent.MODIFIER_SHIFT) != 0;
    }

    boolean isControlPressed() {
        return (modifiers & KeyEvent.MODIFIER_CONTROL) != 0;
    }

    public String toString() {
        return "KeyState[modifiers=" + modifiers + ",keys=" + keysPressed + "]";
    }

}
