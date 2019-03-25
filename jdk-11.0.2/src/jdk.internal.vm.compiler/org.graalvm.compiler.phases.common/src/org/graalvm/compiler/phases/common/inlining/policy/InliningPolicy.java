/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.common.inlining.policy;

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.spi.Replacements;
import org.graalvm.compiler.phases.common.inlining.walker.MethodInvocation;

public interface InliningPolicy {
    class Decision {
        public static final Decision YES = new Decision(true, "(unknown reason)");
        public static final Decision NO = new Decision(false, "(unknown reason)");

        private final boolean shouldInline;
        private final String reason;

        private Decision(boolean shouldInline, String reason) {
            this.shouldInline = shouldInline;
            this.reason = reason;
        }

        public boolean shouldInline() {
            return shouldInline;
        }

        public String getReason() {
            return reason;
        }

        public Decision withReason(boolean isTracing, String newReason, Object... args) {
            if (isTracing) {
                return new Decision(shouldInline, String.format(newReason, args));
            } else {
                return this;
            }
        }
    }

    boolean continueInlining(StructuredGraph graph);

    Decision isWorthInlining(Replacements replacements, MethodInvocation invocation, int inliningDepth, boolean fullyProcessed);
}
