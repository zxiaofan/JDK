/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.packager.services.userjvmoptions;

import jdk.packager.services.UserJvmOptionsService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Access to old preferences based UserJvmOptions
 *
 * Do not instantiate this class directly, instead use
 * {@see jdk.packager.services.UserJvmOptionsService#getUserJVMDefaults()}
 * to get an instance.
 *
 * @since 8u40
 */
final public class PreferencesUserJvmOptions implements UserJvmOptionsService {

    Preferences node = Preferences.userRoot().node(System.getProperty("app.preferences.id").replace(".", "/")).node("JVMUserOptions");

    @Override
    public Map<String, String> getUserJVMOptions() {
        Map<String, String> result = new LinkedHashMap<>();
        try {
            for (String s : node.childrenNames()) {
                String o = node.get(s, null);
                if (o != null) {
                    result.put(s, o);
                }
            }
        } catch (BackingStoreException ignore) {
        }

        return result;
    }

    @Override
    public void setUserJVMOptions(Map<String, String> options) {
        try {
            node.clear();
            for (Map.Entry<String, String> entry : options.entrySet()) {
                node.put(entry.getKey(), entry.getValue());
            }
            node.flush();
        } catch (BackingStoreException ignore) {
        }

    }

    @Override
    public Map<String, String> getUserJVMOptionDefaults() {
        throw new UnsupportedOperationException("Preferences backed UserJvmOptions do not enumerate their defaults");
    }
}
