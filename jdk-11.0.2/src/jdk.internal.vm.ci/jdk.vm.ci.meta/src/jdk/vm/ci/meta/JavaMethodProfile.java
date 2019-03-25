/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.JavaMethodProfile.ProfiledMethod;

/**
 * This profile object represents the method profile at a specific BCI. The precision of the
 * supplied values may vary, but a runtime that provides this information should be aware that it
 * will be used to guide performance-critical decisions like speculative inlining, etc.
 */
public final class JavaMethodProfile extends AbstractJavaProfile<ProfiledMethod, ResolvedJavaMethod> {

    public JavaMethodProfile(double notRecordedProbability, ProfiledMethod[] pitems) {
        super(notRecordedProbability, pitems);
    }

    public ProfiledMethod[] getMethods() {
        return super.getItems();
    }

    public static class ProfiledMethod extends AbstractProfiledItem<ResolvedJavaMethod> {

        public ProfiledMethod(ResolvedJavaMethod method, double probability) {
            super(method, probability);
        }

        /**
         * Returns the type for this profile entry.
         */
        public ResolvedJavaMethod getMethod() {
            return getItem();
        }

        @Override
        public String toString() {
            return "{" + item.getName() + ", " + probability + "}";
        }
    }
}
