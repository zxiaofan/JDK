/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.fxml;

import java.io.IOException;

/**
 * Thrown when an error is encountered during a load operation.
 * @since JavaFX 2.0
 */
public class LoadException extends IOException {
    private static final long serialVersionUID = 0;

    public LoadException() {
        super();
    }

    public LoadException(String message) {
        super(message);
    }

    public LoadException(Throwable cause) {
        super(cause);
    }

    public LoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
