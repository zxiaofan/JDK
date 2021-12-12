/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.foreign.abi.x64.sysv;

public enum ArgumentClassImpl {
    POINTER, INTEGER, SSE, SSEUP, X87, X87UP, COMPLEX_X87, NO_CLASS, MEMORY;

    public ArgumentClassImpl merge(ArgumentClassImpl other) {
        if (this == other) {
            return this;
        }

        if (other == NO_CLASS) {
            return this;
        }
        if (this == NO_CLASS) {
            return other;
        }

        if (this == MEMORY || other == MEMORY) {
            return MEMORY;
        }

        if (this == POINTER || other == POINTER) {
            return POINTER;
        }

        if (this == INTEGER || other == INTEGER) {
            return INTEGER;
        }

        if (this == X87 || this == X87UP || this == COMPLEX_X87) {
            return MEMORY;
        }
        if (other == X87 || other == X87UP || other == COMPLEX_X87) {
            return MEMORY;
        }

        return SSE;
    }

    public boolean isIntegral() {
        return this == INTEGER || this == POINTER;
    }

    public boolean isPointer() {
        return this == POINTER;
    }

    public boolean isIndirect() {
        return this == MEMORY;
    }
}
