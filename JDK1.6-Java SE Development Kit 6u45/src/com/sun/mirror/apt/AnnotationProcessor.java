/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.apt;


import java.io.IOException;
import java.util.Collection;


/**
 * An annotation processor, used to examine and process the
 * annotations of program elements.  An annotation processor may,
 * for example, create new source files and XML documents to be used
 * in conjunction with the original code.
 *
 * <p> An annotation processor is constructed by a
 * {@linkplain AnnotationProcessorFactory factory}, which provides it with an
 * {@linkplain AnnotationProcessorEnvironment environment} that
 * encapsulates the state it needs.
 * Messages regarding warnings and errors encountered during processing
 * should be directed to the environment's {@link Messager},
 * and new files may be created using the environment's {@link Filer}.
 *
 * <p> Each annotation processor is created to process annotations
 * of a particular annotation type or set of annotation types.
 * It may use its environment to find the program elements with
 * annotations of those types.  It may freely examine any other program
 * elements in the course of its processing.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface AnnotationProcessor {

    /**
     * Process all program elements supported by this annotation processor.
     */
    void process();
}
