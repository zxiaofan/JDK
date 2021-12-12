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

/**
 * Defines services that allow agents to
 * instrument programs running on the JVM.
 *
 * @moduleGraph
 * @since 9
 */
module java.instrument {
    exports java.lang.instrument;

    // allow java launcher to load agents in executable JAR files
    exports sun.instrument to java.base;
}

