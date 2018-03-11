/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.mirror.apt;

/**
 * Represents the status of a completed round of annotation processing.
 *
 * @deprecated All components of this API have been superseded by the
 * standardized annotation processing API.  The replacement for the
 * functionality of this interface is {@link
 * javax.annotation.processing.RoundEnvironment}.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated
@SuppressWarnings("deprecation")
public interface RoundState {
    /**
     * Returns <tt>true</tt> if this was the last round of annotation
     * processing; returns <tt>false</tt> if there will be a subsequent round.
     */
    boolean finalRound();

    /**
     * Returns <tt>true</tt> if an error was raised in this round of processing;
     * returns <tt>false</tt> otherwise.
     */
    boolean errorRaised();

    /**
     * Returns <tt>true</tt> if new source files were created in this round of
     * processing; returns <tt>false</tt> otherwise.
     */
    boolean sourceFilesCreated();

    /**
     * Returns <tt>true</tt> if new class files were created in this round of
     * processing; returns <tt>false</tt> otherwise.
     */
    boolean classFilesCreated();
}
