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
 * Defines the core scenegraph APIs for the JavaFX UI toolkit
 * (such as layout containers, application lifecycle, shapes,
 * transformations, canvas, input, painting, image handling, and effects),
 * as well as APIs for animation, css, concurrency, geometry, printing, and
 * windowing.
 *
 * @moduleGraph
 * @since 9
 */
module javafx.graphics {
    // source file: file:///c:/cygwin/var/tmp/jib-java_re/install/java/re/javafx/9/promoted/all/181/bundles/windows-x64/javafx-exports.zip/modules_src/javafx.graphics/module-info.java
    //              file:///c:/workspace/9-2-build-windows-amd64-cygwin-phase2/jdk9/6725/deploy/dependencies/javafx.graphics/share/classes/module-info.java.extra
    requires transitive javafx.base;
    requires java.desktop;
    requires java.xml;
    requires jdk.jsobject;
    exports javafx.animation;
    exports javafx.application;
    exports javafx.concurrent;
    exports javafx.css;
    exports javafx.css.converter;
    exports javafx.geometry;
    exports javafx.print;
    exports javafx.scene;
    exports javafx.scene.canvas;
    exports javafx.scene.effect;
    exports javafx.scene.image;
    exports javafx.scene.input;
    exports javafx.scene.layout;
    exports javafx.scene.paint;
    exports javafx.scene.shape;
    exports javafx.scene.text;
    exports javafx.scene.transform;
    exports javafx.stage;
    exports com.sun.glass.ui to
        javafx.media,
        javafx.web;
    exports com.sun.glass.utils to
        javafx.media,
        javafx.web;
    exports com.sun.javafx.application to
        java.base,
        javafx.controls,
        javafx.deploy,
        javafx.swing,
        javafx.web;
    exports com.sun.javafx.css to
        javafx.controls,
        javafx.deploy;
    exports com.sun.javafx.css.parser to jdk.packager;
    exports com.sun.javafx.cursor to javafx.swing;
    exports com.sun.javafx.embed to javafx.swing;
    exports com.sun.javafx.font to javafx.web;
    exports com.sun.javafx.geom to
        javafx.controls,
        javafx.media,
        javafx.swing,
        javafx.web;
    exports com.sun.javafx.geom.transform to
        javafx.controls,
        javafx.media,
        javafx.swing,
        javafx.web;
    exports com.sun.javafx.iio to javafx.web;
    exports com.sun.javafx.jmx to
        javafx.media,
        javafx.swing,
        javafx.web;
    exports com.sun.javafx.menu to javafx.controls;
    exports com.sun.javafx.perf to javafx.deploy;
    exports com.sun.javafx.scene to
        javafx.controls,
        javafx.media,
        javafx.swing,
        javafx.web;
    exports com.sun.javafx.scene.input to
        javafx.controls,
        javafx.swing,
        javafx.web;
    exports com.sun.javafx.scene.layout to
        javafx.controls,
        javafx.web;
    exports com.sun.javafx.scene.text to
        javafx.controls,
        javafx.web;
    exports com.sun.javafx.scene.traversal to
        javafx.controls,
        javafx.web;
    exports com.sun.javafx.sg.prism to
        javafx.media,
        javafx.swing,
        javafx.web;
    exports com.sun.javafx.stage to
        javafx.controls,
        javafx.deploy,
        javafx.swing;
    exports com.sun.javafx.text to javafx.web;
    exports com.sun.javafx.tk to
        javafx.controls,
        javafx.deploy,
        javafx.media,
        javafx.swing,
        javafx.web;
    exports com.sun.javafx.tk.quantum to javafx.deploy;
    exports com.sun.javafx.util to
        javafx.controls,
        javafx.fxml,
        javafx.media,
        javafx.swing,
        javafx.web;
    exports com.sun.prism to
        javafx.media,
        javafx.web;
    exports com.sun.prism.image to javafx.web;
    exports com.sun.prism.paint to javafx.web;
    exports com.sun.scenario.effect to javafx.web;
    exports com.sun.scenario.effect.impl to javafx.web;
    exports com.sun.scenario.effect.impl.prism to javafx.web;

}
