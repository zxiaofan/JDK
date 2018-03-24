/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.animation;

import com.sun.javafx.util.Utils;
import javafx.animation.KeyValue;

/**
 * Used to access internal methods of KeyValue.
 */
public class KeyValueHelper {

    private static KeyValueAccessor keyValueAccessor;

    static {
        Utils.forceInit(KeyValue.class);
    }

    private KeyValueHelper() {
    }

    public static KeyValueType getType(KeyValue keyValue) {
        return keyValueAccessor.getType(keyValue);
    }

    public static void setKeyValueAccessor(final KeyValueAccessor newAccessor) {
        if (keyValueAccessor != null) {
            throw new IllegalStateException();
        }

        keyValueAccessor = newAccessor;
    }

    public interface KeyValueAccessor {
        KeyValueType getType(KeyValue keyValue);
    }

}
