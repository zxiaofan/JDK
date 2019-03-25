/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.util;

/**
 * System Property access for internal use only.
 * Read-only access to System property values initialized during Phase 1
 * are cached.  Setting, clearing, or modifying the value using
 * {@link System#setProperty) or {@link System#getProperties()} is ignored.
 * <strong>{@link SecurityManager#checkPropertyAccess} is NOT checked
 * in these access methods. The caller of these methods should take care to ensure
 * that the returned property is not made accessible to untrusted code.</strong>
 */
public final class StaticProperty {

    // The class static initialization is triggered to initialize these final
    // fields during init Phase 1 and before a security manager is set.
    private static final String JAVA_HOME = initProperty("java.home");
    private static final String USER_HOME = initProperty("user.home");
    private static final String USER_DIR  = initProperty("user.dir");
    private static final String USER_NAME = initProperty("user.name");

    private StaticProperty() {}

    private static String initProperty(String key) {
        String v = System.getProperty(key);
        if (v == null) {
            throw new InternalError("null property: " + key);
        }
        return v;
    }

    /**
     * Return the {@code java.home} system property.
     *
     * <strong>{@link SecurityManager#checkPropertyAccess} is NOT checked
     * in this method. The caller of this method should take care to ensure
     * that the returned property is not made accessible to untrusted code.</strong>
     *
     * @return the {@code java.home} system property
     */
    public static String javaHome() {
        return JAVA_HOME;
    }

    /**
     * Return the {@code user.home} system property.
     *
     * <strong>{@link SecurityManager#checkPropertyAccess} is NOT checked
     * in this method. The caller of this method should take care to ensure
     * that the returned property is not made accessible to untrusted code.</strong>
     *
     * @return the {@code user.home} system property
     */
    public static String userHome() {
        return USER_HOME;
    }

    /**
     * Return the {@code user.dir} system property.
     *
     * <strong>{@link SecurityManager#checkPropertyAccess} is NOT checked
     * in this method. The caller of this method should take care to ensure
     * that the returned property is not made accessible to untrusted code.</strong>
     *
     * @return the {@code user.dir} system property
     */
    public static String userDir() {
        return USER_DIR;
    }

    /**
     * Return the {@code user.name} system property.
     *
     * <strong>{@link SecurityManager#checkPropertyAccess} is NOT checked
     * in this method. The caller of this method should take care to ensure
     * that the returned property is not made accessible to untrusted code.</strong>
     *
     * @return the {@code user.name} system property
     */
    public static String userName() {
        return USER_NAME;
    }
}
