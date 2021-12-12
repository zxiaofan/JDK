/*
 * Copyright (c) 2011, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jpackage.internal;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class PackagerException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final ResourceBundle bundle = ResourceBundle.getBundle(
            "jdk.jpackage.internal.resources.MainResources");

    public PackagerException(Throwable cause) {
        super(cause);
    }

    public PackagerException(String key, Throwable cause) {
        super(bundle.getString(key), cause);
    }

    public PackagerException(String key) {
        super(bundle.getString(key));
    }

    public PackagerException(String key, String ... arguments) {
        super(MessageFormat.format(
                bundle.getString(key), (Object[]) arguments));
    }

    public PackagerException(
            Throwable cause, String key, String ... arguments) {
        super(MessageFormat.format(bundle.getString(key),
                (Object[]) arguments), cause);
    }

}
