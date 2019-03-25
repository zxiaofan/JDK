/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.debug;

/**
 * Object used to close a debug {@link DebugContext#indent() indentation} scope.
 * <p>
 * Example usage:
 *
 * <pre>
 *
 *      try (Indent i1 = Debug.logAndIndent("header message")) {
 *          ...
 *          Debug.log("message");
 *          ...
 *          try (Indent i2 = Debug.logAndIndent(sub-header message")) {
 *              ...
 *              Debug.log("inner message");
 *              ...
 *          }
 *      }
 *
 * </pre>
 */
public interface Indent extends AutoCloseable {

    /**
     * Closes the current indentation scope.
     */
    @Override
    void close();
}
