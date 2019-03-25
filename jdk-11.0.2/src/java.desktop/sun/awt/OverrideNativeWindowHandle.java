/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

/**
 * Used for replacing window owner with another non-Swing window.
 * It is useful in case of JavaFX-Swing interop:
 * it helps to keep Swing dialogs above its owner(JavaFX stage).
 */

public interface OverrideNativeWindowHandle {

    /**
     * Replaces an owner window with a window with provided handle.
     * @param handle native window handle
     */
    void overrideWindowHandle(final long handle);
}
