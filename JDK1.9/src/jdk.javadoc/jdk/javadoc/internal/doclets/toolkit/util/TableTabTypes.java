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

/**
 * Interface representing table tab types.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Bhavesh Patel
 */
public interface TableTabTypes {

    TableTabs tableTabs();

    public static final class TableTabs {

        private final int value;
        private final String resourceKey;
        private final String tabId;
        private final boolean isDefaultTab;

        private TableTabs(int v, String k, String id, boolean dt) {
            this.value = v;
            this.resourceKey = k;
            this.tabId = id;
            this.isDefaultTab = dt;
        }

        public static TableTabs tab(int value, String resourceKey, String tabId, boolean isDefaultTab) {
            return new TableTabs(value, resourceKey, tabId, isDefaultTab);
        }

        public int value() {
            return this.value;
        }

        public String resourceKey() {
            return this.resourceKey;
        }

        public String tabId() {
            return this.tabId;
        }

        public boolean isDefaultTab() {
            return this.isDefaultTab;
        }
    }
}
