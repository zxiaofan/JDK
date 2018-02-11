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
 *
 *
 */

package jdk.javadoc.internal.doclets.toolkit.util;

import jdk.javadoc.internal.doclets.toolkit.util.TableTabTypes.TableTabs;

/**
 * Enum representing module package types.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
public enum ModulePackageTypes implements TableTabTypes {
    ALL(TableTabs.tab(0xffff, "doclet.All_Packages", "t0", true)),
    EXPORTED(TableTabs.tab(0x1, "doclet.Exported_Packages_Summary", "t1", false)),
    OPENED(TableTabs.tab(0x2, "doclet.Opened_Packages_Summary", "t2", false)),
    CONCEALED(TableTabs.tab(0x4, "doclet.Concealed_Packages_Summary", "t3", false));

    private final TableTabs tabs;

    private ModulePackageTypes(TableTabs t) {
        this.tabs = t;
    }

    public TableTabs tableTabs() {
        return this.tabs;
    }
}
