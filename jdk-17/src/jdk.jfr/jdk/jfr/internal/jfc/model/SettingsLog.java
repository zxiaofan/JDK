/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.jfc.model;

import java.util.Map;
import java.util.TreeMap;

public final class SettingsLog {
    private static final Map<String, String> settings = new TreeMap<>();
    private static boolean enabled;

    public static void enable() {
        enabled = true;
    }

    public static void flush() {
        if (!settings.isEmpty()) {
            System.out.println();
            System.out.println("Setting:");
            for (var s : settings.entrySet()) {
                System.out.println("\"" + s.getKey() + "=" + s.getValue() + "\"");
            }
            settings.clear();
        }
    }

    static void log(XmlSetting setting, String value) {
        if (enabled) {
            settings.put(setting.getFullName(), value);
        }
    }
}
