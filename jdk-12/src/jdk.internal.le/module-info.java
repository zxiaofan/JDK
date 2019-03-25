/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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
    exports jdk.internal.org.jline.keymap to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.org.jline.reader to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.org.jline.reader.impl to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.org.jline.reader.impl.completer to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.org.jline.reader.impl.history to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.org.jline.terminal.impl to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.org.jline.terminal to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.org.jline.utils to
        jdk.scripting.nashorn.shell,
        jdk.jshell;
    exports jdk.internal.org.jline.terminal.spi to
        jdk.scripting.nashorn.shell,
        jdk.jshell;

    uses jdk.internal.org.jline.terminal.spi.JnaSupport;

}

