/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.util;

/**
 * Strategy for comparing two objects. Default predefined strategies are {@link #DEFAULT},
 * {@link #IDENTITY}, and {@link #IDENTITY_WITH_SYSTEM_HASHCODE}.
 */
public abstract class Equivalence {

    /**
     * Default equivalence calling {@link #equals(Object)} to check equality and {@link #hashCode()}
     * for obtaining hash values. Do not change the logic of this class as it may be inlined in
     * other places.
     */
    public static final Equivalence DEFAULT = new Equivalence() {

        @Override
        public boolean equals(Object a, Object b) {
            return a.equals(b);
        }

        @Override
        public int hashCode(Object o) {
            return o.hashCode();
        }
    };

    /**
     * Identity equivalence using {@code ==} to check equality and {@link #hashCode()} for obtaining
     * hash values. Do not change the logic of this class as it may be inlined in other places.
     */
    public static final Equivalence IDENTITY = new Equivalence() {

        @Override
        public boolean equals(Object a, Object b) {
            return a == b;
        }

        @Override
        public int hashCode(Object o) {
            return o.hashCode();
        }
    };

    /**
     * Identity equivalence using {@code ==} to check equality and
     * {@link System#identityHashCode(Object)} for obtaining hash values. Do not change the logic of
     * this class as it may be inlined in other places.
     */
    public static final Equivalence IDENTITY_WITH_SYSTEM_HASHCODE = new Equivalence() {

        @Override
        public boolean equals(Object a, Object b) {
            return a == b;
        }

        @Override
        public int hashCode(Object o) {
            return System.identityHashCode(o);
        }
    };

    /**
     * Subclass for creating custom equivalence definitions.
     */
    protected Equivalence() {
    }

    public abstract boolean equals(Object a, Object b);

    public abstract int hashCode(Object o);
}
