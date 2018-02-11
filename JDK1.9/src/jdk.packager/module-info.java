/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Defines the Java packager tool, javapackager.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.packager {
    requires jdk.jlink;
    requires jdk.jdeps;

    requires java.xml;
    requires java.desktop;
    requires java.logging;

    exports com.oracle.tools.packager;
    exports com.sun.javafx.tools.packager;
    exports com.sun.javafx.tools.packager.bundlers;
    exports com.sun.javafx.tools.resource;

    uses com.oracle.tools.packager.Bundler;
    uses com.oracle.tools.packager.Bundlers;

    provides com.oracle.tools.packager.Bundlers with
        com.oracle.tools.packager.BasicBundlers;

    provides com.oracle.tools.packager.Bundler with
        com.oracle.tools.packager.jnlp.JNLPBundler,
        com.oracle.tools.packager.linux.LinuxAppBundler,
        com.oracle.tools.packager.linux.LinuxDebBundler,
        com.oracle.tools.packager.linux.LinuxRpmBundler,
        com.oracle.tools.packager.mac.MacAppBundler,
        com.oracle.tools.packager.mac.MacAppStoreBundler,
        com.oracle.tools.packager.mac.MacDmgBundler,
        com.oracle.tools.packager.mac.MacPkgBundler,
        com.oracle.tools.packager.windows.WinAppBundler,
        com.oracle.tools.packager.windows.WinExeBundler,
        com.oracle.tools.packager.windows.WinMsiBundler;
}
