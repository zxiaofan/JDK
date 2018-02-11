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
 * Defines APIs for playback of media and audio content, as part of the
 * JavaFX UI toolkit, including {@link javafx.scene.media.MediaView} and
 * {@link javafx.scene.media.MediaPlayer}.
 *
 * @moduleGraph
 * @since 9
 */
module javafx.media {
    requires transitive javafx.base;
    requires transitive javafx.graphics;

    exports javafx.scene.media;

    exports com.sun.javafx.media to
        javafx.web;
    exports com.sun.media.jfxmedia to
        javafx.web;
    exports com.sun.media.jfxmedia.control to
        javafx.web;
    exports com.sun.media.jfxmedia.events to
        javafx.web;
    exports com.sun.media.jfxmedia.locator to
        javafx.web;
    exports com.sun.media.jfxmedia.track to
        javafx.web;
}
