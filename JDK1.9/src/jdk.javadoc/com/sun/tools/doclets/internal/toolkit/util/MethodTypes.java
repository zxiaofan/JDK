/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.util;

/**
 * Enum representing method types.
 *
 * @author Bhavesh Patel
 */
@Deprecated
public enum MethodTypes {
    ALL(0xffff, "doclet.All_Methods", "t0", true),
    STATIC(0x1, "doclet.Static_Methods", "t1", false),
    INSTANCE(0x2, "doclet.Instance_Methods", "t2", false),
    ABSTRACT(0x4, "doclet.Abstract_Methods", "t3", false),
    CONCRETE(0x8, "doclet.Concrete_Methods", "t4", false),
    DEFAULT(0x10, "doclet.Default_Methods", "t5", false),
    DEPRECATED(0x20, "doclet.Deprecated_Methods", "t6", false);

    private final int value;
    private final String resourceKey;
    private final String tabId;
    private final boolean isDefaultTab;

    MethodTypes(int v, String k, String id, boolean dt) {
        this.value = v;
        this.resourceKey = k;
        this.tabId = id;
        this.isDefaultTab = dt;
    }

    public int value() {
        return value;
    }

    public String resourceKey() {
        return resourceKey;
    }

    public String tabId() {
        return tabId;
    }

    public boolean isDefaultTab() {
        return isDefaultTab;
    }
}
