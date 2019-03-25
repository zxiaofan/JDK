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
 * Defines the Preferences API.
 *
 * @uses java.util.prefs.PreferencesFactory
 *
 * @moduleGraph
 * @since 9
 */
module java.prefs {
    requires java.xml;

    exports java.util.prefs;

    uses java.util.prefs.PreferencesFactory;
}
