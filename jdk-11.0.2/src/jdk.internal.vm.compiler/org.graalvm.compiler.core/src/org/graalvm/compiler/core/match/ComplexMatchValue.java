/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.match;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.gen.NodeLIRBuilder;

import jdk.vm.ci.meta.Value;

/**
 * A wrapper value for the lazy evaluation of a complex match. There's an intermediate class for the
 * closure because Value is serializable which is a hassle for the little inner classes which
 * usually occur here.
 */
public class ComplexMatchValue extends Value {

    /**
     * This is the Value of a node which was matched as part of a complex match. The value isn't
     * actually useable but this marks it as having been evaluated.
     */
    public static final Value INTERIOR_MATCH = new Value(LIRKind.Illegal) {

        @Override
        public String toString() {
            return "INTERIOR_MATCH";
        }

        @Override
        public boolean equals(Object other) {
            // This class is a singleton
            return other != null && getClass() == other.getClass();
        }
    };

    final ComplexMatchResult result;

    public ComplexMatchValue(ComplexMatchResult result) {
        super(LIRKind.Illegal);
        this.result = result;
    }

    public Value evaluate(NodeLIRBuilder builder) {
        return result.evaluate(builder);
    }
}
