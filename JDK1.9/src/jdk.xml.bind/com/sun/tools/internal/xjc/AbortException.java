/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

/*
 * Use is subject to the license terms.
 */
package com.sun.tools.internal.xjc;


/**
 * Signals the abortion of the compilation.
 * <p>
 * This exception should be only thrown from {@link ErrorReceiver}
 * for the consistent error handling.
 *
 * @author Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public class AbortException extends RuntimeException {
    public AbortException() {
    }
}
