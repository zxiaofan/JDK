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
    requires transitive java.desktop;
    exports com.sun.java.accessibility.util;

    provides javax.accessibility.AccessibilityProvider with com.sun.java.accessibility.internal.ProviderImpl;
}
