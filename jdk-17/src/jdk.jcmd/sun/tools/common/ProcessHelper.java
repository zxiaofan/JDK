/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.common;

/**
 * A helper class to retrieve the main class name for a running
 * Java process. Default implementation returns null. Platform specific
 * implementation currently available for Linux only.
 */
final class ProcessHelper {

    /**
     * Returns the main class name for the given Java process
     *
     * @param pid - process ID (pid)
     * @return main class name or null if the main class could not be retrieved
     */
    static String getMainClass(String pid) {
        return null;
    }
}
