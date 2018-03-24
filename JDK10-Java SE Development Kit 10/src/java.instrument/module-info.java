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
    // source file: file:///t:/workspace/open/src/java.instrument/share/classes/module-info.java
    //              file:///t:/workspace/closed/src/java.instrument/share/classes/module-info.java.extra
    exports java.lang.instrument;
    exports jdk.internal.instrumentation to
        jdk.jfr,
        jdk.management.resource;
    exports sun.instrument to java.base;

}
