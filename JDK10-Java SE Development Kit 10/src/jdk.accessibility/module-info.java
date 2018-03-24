/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
 * Defines JDK utility classes used by implementors of Assistive Technologies.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.accessibility {
    // source file: file:///t:/workspace/open/src/jdk.accessibility/share/classes/module-info.java
    //              file:///t:/workspace/open/src/jdk.accessibility/windows/classes/module-info.java.extra
    requires transitive java.desktop;
    exports com.sun.java.accessibility.util;

    provides javax.accessibility.AccessibilityProvider with com.sun.java.accessibility.internal.ProviderImpl;
}
