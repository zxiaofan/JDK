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
 * Defines APIs for the JavaFX / Swing interop support included with the
 * JavaFX UI toolkit, including {@link javafx.embed.swing.SwingNode} (for
 * embedding Swing inside a JavaFX application) and
 * {@link javafx.embed.swing.JFXPanel} (for embedding JavaFX inside a Swing
 * application).
 *
 * @moduleGraph
 * @since 9
 */
module javafx.swing {
    requires transitive java.desktop;
    requires transitive javafx.graphics;

    requires java.datatransfer;
    requires javafx.base;

    exports javafx.embed.swing;

    exports com.sun.javafx.embed.swing to
        javafx.graphics;
}
