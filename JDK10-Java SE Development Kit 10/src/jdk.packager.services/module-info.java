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
 * Defines the services used by the Java packager tool.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.packager.services {
    exports jdk.packager.services;
    exports jdk.packager.services.singleton;

    requires java.prefs;
    requires java.desktop;

    uses jdk.packager.services.UserJvmOptionsService;

    provides jdk.packager.services.UserJvmOptionsService with jdk.packager.services.userjvmoptions.LauncherUserJvmOptions;
}
