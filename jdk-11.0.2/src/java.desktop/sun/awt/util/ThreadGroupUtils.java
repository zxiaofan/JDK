/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.util;

/**
 * A utility class needed to access the root {@code ThreadGroup}
 *
 * The class should not depend on any others, because it' called from JNI_OnLoad of the AWT
 * native library. Triggering class loading could lead to a deadlock.
 */
public final class ThreadGroupUtils {

    private ThreadGroupUtils() {
        // Avoid instantiation
    }

    /**
     * Returns a root thread group.
     * Should be called with {@link sun.security.util.SecurityConstants#MODIFY_THREADGROUP_PERMISSION}
     *
     * @return a root {@code ThreadGroup}
     */
    public static ThreadGroup getRootThreadGroup() {
        ThreadGroup currentTG = Thread.currentThread().getThreadGroup();
        ThreadGroup parentTG = currentTG.getParent();
        while (parentTG != null) {
            currentTG = parentTG;
            parentTG = currentTG.getParent();
        }
        return currentTG;
    }
}
