/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.scene.transform;

import javafx.beans.NamedArg;


/**
 * The <code>NonInvertibleTransformException</code> class represents
 * an exception that is thrown if an operation is performed requiring
 * the inverse of a {@code Transform} object which is in a non-invertible state.
 * @since JavaFX 8.0
 */
public class NonInvertibleTransformException extends java.lang.Exception {

    /**
     * Creates a new instance of {@code NonInvertibleTransformException}
     * with the specified detail message.
     * @param message the detail message
     */
    public NonInvertibleTransformException(@NamedArg("message") String message) {
        super (message);
    }
}
