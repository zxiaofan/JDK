/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

/**
 * LinuxKeyBits defines sets of keys that are used to identify classes of key input
 * devices
 */
class LinuxKeyBits extends LinuxInput {

    static final short KEYBITS_ARROWS[] = {
        KEY_UP, KEY_DOWN, KEY_LEFT, KEY_RIGHT
    };

    static final short KEYBITS_SELECT[] = {
        KEY_ENTER, KEY_SELECT
    };

    /** Keybits for PC keyboard */
    static final short KEYBITS_PC[] = {
        KEY_A, KEY_B, KEY_C, KEY_D, KEY_E, KEY_F, KEY_G, KEY_H, KEY_I, KEY_J,
        KEY_K, KEY_L, KEY_M, KEY_N, KEY_O, KEY_P, KEY_Q, KEY_R, KEY_S, KEY_T,
        KEY_U, KEY_V, KEY_W, KEY_X, KEY_Y, KEY_Z,
        KEY_1, KEY_2, KEY_3, KEY_4, KEY_5, KEY_6, KEY_7, KEY_8, KEY_9, KEY_0,
        KEY_SPACE, KEY_LEFTSHIFT, KEY_TAB
    };

}
