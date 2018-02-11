/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.input;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.input.KeyCode;

/**
 * Map from int codes to KeyCode.
 * Should be removed once RT-20448 is fixed.
 */
public final class KeyCodeMap {

    KeyCodeMap() {
    }

    private static final Map<Integer, KeyCode> charMap;

    static {
        charMap = new HashMap<Integer, KeyCode>(KeyCode.values().length);

        for (KeyCode c : KeyCode.values()) {
            charMap.put(c.getCode(), c);
        }
    }

    public static KeyCode valueOf(int code) {
        return charMap.get(code);
    }
}
