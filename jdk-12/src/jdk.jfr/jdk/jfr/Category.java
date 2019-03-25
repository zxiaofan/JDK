/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Event annotation, to associate the event type with a category, in the format
 * of a human-readable path.
 * <p>
 * The category determines how an event is presented to the user. Events that
 * are in the same category are typically displayed together in graphs and
 * trees. To avoid the overlap of durational events in graphical
 * representations, overlapping events must be in separate categories.
 * <p>
 * For example, to monitor image uploads to a web server with a separate thread
 * for each upload, an event called File Upload starts when the user uploads a
 * file and ends when the upload is complete. For advanced diagnostics about
 * image uploads, more detailed events are created (for example, Image Read,
 * Image Resize, and Image Write). During these detailed events. other low
 * level-events could occur (for example, Socket Read and File Write).
 * <p>
 * The following example shows a visualization that avoids overlaps:
 *
 * <pre>
 * -------------------------------------------------------------------
 *   |                         File Upload                        |
 * ------------------------------------------------------------------
 *   |       Image Read          | Image Resize |   Image Write   |
 * ------------------------------------------------------------------
 *   | Socket Read | Socket Read |              |    File Write   |
 * -------------------------------------------------------------------
 * </pre>
 *
 * The example can be achieved by using the following categories:
 *
 * <table class="striped">
 * <caption>Recording options and their purpose.</caption> <thead>
 * <tr>
 * <th scope="col">Event Name</th>
 * <th scope="col">Annotation</th>
 * </tr>
 * </thead> <tbody>
 * <tr>
 * <th scope="row">File Upload</th>
 * <td><code>@Category("Upload")</code></td>
 * </tr>
 * <tr>
 * <th scope="row">Image Read</th>
 * <td><code>@Category({"Upload", "Image Upload"})</code></td>
 * </tr>
 * <tr>
 * <th scope="row">Image Resize</th>
 * <td><code>@Category({"Upload", "Image Upload"})</code></td>
 * </tr>
 * <tr>
 * <th scope="row">Image Write</th>
 * <td><code>@Category({"Upload", "Image Upload"})</code></td>
 * </tr>
 * <tr>
 * <th scope="row">Socket Read</th>
 * <td><code>@Category("Java Application")</code></td>
 * </tr>
 * <tr>
 * <th scope="row">File Write</th>
 * <td><code>@Category("Java Application")</code></td>
 * </tr>
 * </tbody>
 * </table>
 * <p>
 * The File Upload, Image Read, and Socket Read events happen concurrently (in
 * the same thread), but the events are in different categories so they do not
 * overlap in the visualization.
 * <p>
 * The following examples shows how the category is used to determine how events
 * are visualized in a tree:
 *
 * <pre>
 *  |- Java Application
 *  |  |- Socket Read
 *  |  |- File Write
 *  |- Upload
 *     |- File Upload
 *     |- Image Upload
 *        |- Image Read
 *        |- Image Resize
 *        |- File Write
 * </pre>
 *
 * @since 9
 */
@MetadataDefinition
@Target({ ElementType.TYPE })
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface Category {
    /**
     * Returns the category names for this annotation, starting with the root.
     *
     * @return the category names
     */
    String[] value();
}
