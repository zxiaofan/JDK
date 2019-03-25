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


package org.graalvm.compiler.nodes;

import jdk.vm.ci.meta.JavaKind.FormatWithToString;

import jdk.internal.vm.compiler.word.LocationIdentity;

import jdk.vm.ci.meta.ResolvedJavaField;

public class FieldLocationIdentity extends LocationIdentity implements FormatWithToString {

    private final ResolvedJavaField inner;

    public FieldLocationIdentity(ResolvedJavaField inner) {
        this.inner = inner;
    }

    @Override
    public boolean isImmutable() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldLocationIdentity) {
            FieldLocationIdentity fieldLocationIdentity = (FieldLocationIdentity) obj;
            return inner.equals(fieldLocationIdentity.inner);

        }
        return false;
    }

    public ResolvedJavaField getField() {
        return inner;
    }

    @Override
    public int hashCode() {
        return inner.hashCode();
    }

    @Override
    public String toString() {
        return inner.format("%h.%n") + (isImmutable() ? ":immutable" : "");
    }
}
