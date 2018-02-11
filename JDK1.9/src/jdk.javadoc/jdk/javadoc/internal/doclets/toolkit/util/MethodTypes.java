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

package jdk.javadoc.internal.doclets.toolkit.util;

/**
 * Enum representing method types.
 *
 * @author Bhavesh Patel
 */
public enum MethodTypes implements TableTabTypes {

    ALL(TableTabs.tab(0xffff, "doclet.All_Methods", "t0", true)),
    STATIC(TableTabs.tab(0x1, "doclet.Static_Methods", "t1", false)),
    INSTANCE(TableTabs.tab(0x2, "doclet.Instance_Methods", "t2", false)),
    ABSTRACT(TableTabs.tab(0x4, "doclet.Abstract_Methods", "t3", false)),
    CONCRETE(TableTabs.tab(0x8, "doclet.Concrete_Methods", "t4", false)),
    DEFAULT(TableTabs.tab(0x10, "doclet.Default_Methods", "t5", false)),
    DEPRECATED(TableTabs.tab(0x20, "doclet.Deprecated_Methods", "t6", false));

    private final TableTabs tabs;

    private MethodTypes(TableTabs t) {
        this.tabs = t;
    }

    public TableTabs tableTabs() {
        return this.tabs;
    }
    }
