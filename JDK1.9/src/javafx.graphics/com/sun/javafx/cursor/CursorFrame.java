/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.cursor;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a frame of an animated cursor (ImageCursor created from an
 * animated image), non animated cursors and standard cursors have only a single
 * CursorFrame.
 */
public abstract class CursorFrame {
    public abstract CursorType getCursorType();

    private Class<?> firstPlatformCursorClass;
    private Object firstPlatformCursor;

    private Map<Class<?>, Object> otherPlatformCursors;

    public <T> T getPlatformCursor(final Class<T> platformCursorClass) {
        if (firstPlatformCursorClass == platformCursorClass) {
            return (T) firstPlatformCursor;
        }

        if (otherPlatformCursors != null) {
            return (T) otherPlatformCursors.get(platformCursorClass);
        }

        return null;
    }

    public <T> void setPlatforCursor(final Class<T> platformCursorClass,
                                     final T platformCursor) {

        if ((firstPlatformCursorClass == null)
                || (firstPlatformCursorClass == platformCursorClass)) {
            // most common case
            firstPlatformCursorClass = platformCursorClass;
            firstPlatformCursor = platformCursor;
            return;
        }

        if (otherPlatformCursors == null) {
            otherPlatformCursors = new HashMap<Class<?>, Object>();
        }

        otherPlatformCursors.put(platformCursorClass, platformCursor);
    }
}
