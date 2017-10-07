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

package com.sun.codemodel.internal;

import java.lang.annotation.Annotation;

/**
 * Base interface for typed annotation writer.
 *
 * <p>
 * Annotation compiler can generate a strongly typed annotation
 * writer to assist applications to write uses of annotations.
 * Such typed annotation writer interfaces all derive from
 * this common interface.
 *
 * <p>
 * The type parameter 'A' represents the
 * @author Kohsuke Kawaguchi
 */
public interface JAnnotationWriter<A extends Annotation> {
    /**
     * Gets the underlying annotation use object to which we are writing.
     */
    JAnnotationUse getAnnotationUse();

    /**
     * The type of the annotation that this writer is writing.
     */
    Class<A> getAnnotationType();
}
