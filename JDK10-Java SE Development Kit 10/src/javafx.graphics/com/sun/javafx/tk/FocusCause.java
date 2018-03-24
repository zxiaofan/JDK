/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk;

/**
 * Enum to distinguish how the stage peer received or lost focus.
 *
 * @see TKStageListener#changedFocused
 *
 */
public enum FocusCause {

    /**
     * An (embedded) stage is activated as a result of forward focus
     * traversal. The first focusable node should gain input focus.
     */
    TRAVERSED_FORWARD,
    /**
     * An (embedded) stage is activated as a result of backward focus
     * traversal. The last focusable node should gain input focus.
     */
    TRAVERSED_BACKWARD,
    /**
     * A (top-level or embedded) stage is activated for some other reason.
     */
    ACTIVATED,
    /**
     * A (top-level or embedded) stage is deactivated.
     */
    DEACTIVATED,
}
