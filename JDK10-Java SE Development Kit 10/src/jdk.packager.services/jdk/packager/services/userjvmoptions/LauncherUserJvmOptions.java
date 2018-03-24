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

import java.security.AllPermission;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * Access the UserJVMOptions via a native library provided by the launcher.
 *
 * Do not instantiate this class directly, instead use
 * {@see jdk.packager.services.UserJvmOptionsService#getUserJVMDefaults()}
 * to get an instance.
 *
 * @since 8u40
 */
final public class LauncherUserJvmOptions implements UserJvmOptionsService {

    private static final Object semaphore = new Object();

    static {
        try {
            checkAllPermissions();
            System.loadLibrary("packager");
        } catch (SecurityException se) {
            se.printStackTrace(System.err);
            // fail to load, we will also throw on all public methods
        }
    }

    private static void checkAllPermissions() {
        final SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new AllPermission());
        }
    }

    /**
     * Access the default User JVM Option for a specific key
     *
     * @param option the key for the User JVM Option
     *
     * @return the default value of the user JVM Option.  Currently set user
     * values are not considered, and only the default is returned.  If there
     * is no default value then null is returned.
     */
    private static native String _getUserJvmOptionDefaultValue(String option);

    /**
     * This lists the keys for User JVM Options that will have a default
     * provided by the launcher.
     *
     * This list will be a subset of the keys used by the launcher and only
     * lists those values that will have a default value provided if the user
     * does not set a value of their own.
     *
     * @return an array of keys in no particular order.
     */
    private static native String[] _getUserJvmOptionDefaultKeys();
    /**
     * Access the current User JVM Option for a specific key
     *
     * @param option the key for the User JVM Option
     *
     * @return the current value of the user JVM Option.  If the user has not
     * set a value then the default value is returned, except in the case where
     * there is no default value, where null is returned.
     */
    private static native String _getUserJvmOptionValue(String option);

    /**
     * Update the all User JVM Options
     *
     * All option/value pairs will be replaced with the values provided. The
     * parameters options and values are paired at the same index.
     * Example: options[3] = -Xmx and values[3] = 999m
     * This cannot be used to adjust default values.
     *
     * @param options the keys for the User JVM Options
     * @param values the values for the User JVM Options
     */
    private static native void _setUserJvmKeysAndValues(String[] options, String[] values);

    /**
     * This lists the keys for all User JVM Options that will be used by the
     * launcher.
     *
     * This list will be a superset of the defaults as may also include user
     * values that do not have a default.
     *
     * @return an array of keys in no particular order.
     */
    private static native String[] _getUserJvmOptionKeys();

    @Override
    public Map<String, String> getUserJVMOptions() {
        checkAllPermissions();
        synchronized (semaphore) {
            Map<String, String> results = new LinkedHashMap<>();
            for (String s : _getUserJvmOptionKeys()) {
                results.put(s, _getUserJvmOptionValue(s));
            }
            return results;
        }
    }

    @Override
    public void setUserJVMOptions(Map<String, String> options) {
        checkAllPermissions();
        synchronized (semaphore) {
            List<String> keys = new LinkedList<>();
            List<String> values = new LinkedList<>();

            for (Map.Entry<String, String> option : options.entrySet()) {
                if (option.getKey() == null) {
                    throw new IllegalArgumentException("For Launcher Backed UserJVMOptions keys in the UserJVMOptions map cannot be null.");
                }
                if (option.getValue() == null) {
                    throw new IllegalArgumentException("For Launcher Backed UserJVMOptions values in the UserJVMOptions map cannot be null.  Keys are removed by absence, not by setting keys to null.");
                }
                keys.add(option.getKey());
                values.add(option.getValue());
            }

            _setUserJvmKeysAndValues(keys.toArray(new String[keys.size()]),
                    values.toArray(new String[values.size()]));
        }
    }

    @Override
    public Map<String, String> getUserJVMOptionDefaults() {
        checkAllPermissions();
        synchronized (semaphore) {
            Map<String, String> results = new LinkedHashMap<>();
            for (String s : _getUserJvmOptionDefaultKeys()) {
                results.put(s, _getUserJvmOptionDefaultValue(s));
            }
            return results;
        }
    }
}
