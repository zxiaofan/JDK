/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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
 */
package jdk.vm.ci.meta;

/**
 * Represents a logic value that can be either {@link #TRUE}, {@link #FALSE}, or {@link #UNKNOWN}.
 */
public enum TriState {
    TRUE,
    FALSE,
    UNKNOWN;

    public static TriState get(boolean value) {
        return value ? TRUE : FALSE;
    }

    /**
     * This is optimistic about {@link #UNKNOWN} (it prefers known values over {@link #UNKNOWN}) and
     * pesimistic about known (it perfers {@link #TRUE} over {@link #FALSE}).
     */
    public static TriState merge(TriState a, TriState b) {
        if (a == TRUE || b == TRUE) {
            return TRUE;
        }
        if (a == FALSE || b == FALSE) {
            return FALSE;
        }
        assert a == UNKNOWN && b == UNKNOWN;
        return UNKNOWN;
    }

    public boolean isTrue() {
        return this == TRUE;
    }

    public boolean isFalse() {
        return this == FALSE;
    }

    public boolean isUnknown() {
        return this == UNKNOWN;
    }

    public boolean isKnown() {
        return this != UNKNOWN;
    }

    public boolean toBoolean() {
        if (isTrue()) {
            return true;
        } else if (isFalse()) {
            return false;
        } else {
            throw new IllegalStateException("Cannot convert to boolean, TriState is in an unknown state");
        }
    }
}
