/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.MetaAccessProvider;

import org.graalvm.compiler.api.replacements.Fold;
import org.graalvm.compiler.api.replacements.Fold.InjectedParameter;
import org.graalvm.compiler.debug.Assertions;
import org.graalvm.compiler.replacements.nodes.AssertionNode;

// JaCoCo Exclude
public final class ReplacementsUtil {
    private ReplacementsUtil() {
        // empty
    }

    public static final boolean REPLACEMENTS_ASSERTIONS_ENABLED = Assertions.assertionsEnabled();

    /**
     * Asserts that condition evaluates to true by the time compilation is finished. This is
     * intended to be used within snippets or stubs, and will lead to a compile error if the
     * assertion fails.
     */
    public static void staticAssert(boolean condition, String message) {
        if (REPLACEMENTS_ASSERTIONS_ENABLED) {
            AssertionNode.assertion(true, condition, message);
        }
    }

    public static void staticAssert(boolean condition, String message, Object arg1) {
        if (REPLACEMENTS_ASSERTIONS_ENABLED) {
            AssertionNode.assertion(true, condition, message, arg1, "");
        }
    }

    public static void staticAssert(boolean condition, String message, Object arg1, Object arg2) {
        if (REPLACEMENTS_ASSERTIONS_ENABLED) {
            AssertionNode.assertion(true, condition, message, arg1, arg2);
        }
    }

    /**
     * Asserts that condition evaluates to true at runtime. This is intended to be used within
     * snippets or stubs, and will lead to a VM error if it fails.
     */
    public static void runtimeAssert(boolean condition, String message) {
        if (REPLACEMENTS_ASSERTIONS_ENABLED) {
            AssertionNode.assertion(false, condition, message);
        }
    }

    @Fold
    public static int arrayIndexScale(@InjectedParameter MetaAccessProvider metaAccessProvider, JavaKind elementKind) {
        return metaAccessProvider.getArrayIndexScale(elementKind);
    }

    @Fold
    public static int getArrayBaseOffset(@InjectedParameter MetaAccessProvider metaAccessProvider, JavaKind elementKind) {
        return metaAccessProvider.getArrayBaseOffset(elementKind);
    }

}
