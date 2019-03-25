/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * A package of the Java Image I/O API dealing with synchronous notification of
 * events during the reading and writing of images.
 * <p>
 * The {@code IIOReadProgressListener} interface allows for notification of the
 * percentage of an image that has been read successfully.
 * <p>
 * The {@code IIOReadUpdateListener} interface allows for notification of the
 * portions of an image that have been read. This is useful, for example, for
 * implementing dynamic display of an image as it is loaded.
 * <p>
 * The {@code IIOReadWarningListener} interface allows for notification of
 * non-fatal errors during reading.
 * <p>
 * The {@code IIOWriteWarningListener} and {@code IIOWriteProgressListener}
 * interfaces perform analogous functions for writers.
 *
 * @since 1.4
 */
package javax.imageio.event;
