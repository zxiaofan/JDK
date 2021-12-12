/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.module;

/**
 * Represents the module target.
 *
 * For now, this is a single value for the target platform, e.g. "linux-x64".
 */
public final class ModuleTarget {

    private final String targetPlatform;

    public ModuleTarget(String targetPlatform) {
        this.targetPlatform = targetPlatform;
    }

    public String targetPlatform() {
        return targetPlatform;
    }

}
