/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
 * Internal API for line editing
 *
 * @since 9
 */
module jdk.internal.le {
    exports jdk.internal.jline to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.jline.console to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.jline.console.completer to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.jline.console.history to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.jline.extra to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.jline.internal to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
}

