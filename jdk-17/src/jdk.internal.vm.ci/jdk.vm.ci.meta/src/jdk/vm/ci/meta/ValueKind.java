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
 */
package jdk.vm.ci.meta;

/**
 * Represents the type of {@link Value values}. This class can be extended by compilers to track
 * additional information about values.
 */
public abstract class ValueKind<K extends ValueKind<K>> {

    private enum IllegalKind implements PlatformKind {
        ILLEGAL;

        private final EnumKey<IllegalKind> key = new EnumKey<>(this);

        @Override
        public Key getKey() {
            return key;
        }

        @Override
        public int getSizeInBytes() {
            return 0;
        }

        @Override
        public int getVectorLength() {
            return 0;
        }

        @Override
        public char getTypeChar() {
            return '-';
        }
    }

    private static class IllegalValueKind extends ValueKind<IllegalValueKind> {

        IllegalValueKind() {
            super(IllegalKind.ILLEGAL);
        }

        @Override
        public IllegalValueKind changeType(PlatformKind newPlatformKind) {
            return this;
        }

        @Override
        public String toString() {
            return "ILLEGAL";
        }
    }

    /**
     * The non-type.
     */
    public static final ValueKind<?> Illegal = new IllegalValueKind();

    private final PlatformKind platformKind;

    public ValueKind(PlatformKind platformKind) {
        this.platformKind = platformKind;
    }

    public final PlatformKind getPlatformKind() {
        return platformKind;
    }

    /**
     * Create a new {@link ValueKind} with a different {@link PlatformKind}. Subclasses must
     * override this to preserve the additional information added by the compiler.
     */
    public abstract K changeType(PlatformKind newPlatformKind);

    /**
     * Returns a String representation of the kind, which will be included at the end of
     * {@link Value#toString()} implementation. Defaults to {@link #toString()} but can be
     * overridden to provide something more specific.
     */
    public String getKindSuffix() {
        return toString();
    }
}
