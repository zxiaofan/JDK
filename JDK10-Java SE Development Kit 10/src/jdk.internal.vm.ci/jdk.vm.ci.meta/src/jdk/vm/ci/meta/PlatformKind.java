/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
 * Represents a platform-specific low-level type for values.
 */
public interface PlatformKind {

    String name();

    public interface Key {

    }

    class EnumKey<E extends Enum<E>> implements Key {
        private final Enum<E> e;

        public EnumKey(Enum<E> e) {
            this.e = e;
        }

        @Override
        public int hashCode() {
            return e.ordinal();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof EnumKey) {
                EnumKey<?> that = (EnumKey<?>) obj;
                return this.e == that.e;
            }
            return false;
        }
    }

    /**
     * Gets a value associated with this object that can be used as a stable key in a map. The
     * {@link Object#hashCode()} implementation of the returned value should be stable between VM
     * executions.
     */
    Key getKey();

    /**
     * Get the size in bytes of this {@link PlatformKind}.
     */
    int getSizeInBytes();

    /**
     * Returns how many primitive values fit in this {@link PlatformKind}. For scalar types this is
     * one, for SIMD types it may be higher.
     */
    int getVectorLength();

    /**
     * Gets a single type char that identifies this type for use in debug output.
     */
    char getTypeChar();
}
