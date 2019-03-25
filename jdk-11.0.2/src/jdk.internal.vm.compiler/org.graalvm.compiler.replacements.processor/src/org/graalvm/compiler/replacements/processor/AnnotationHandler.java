/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.processor;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;

import org.graalvm.compiler.processor.AbstractProcessor;

/**
 * Handles processing of a single annotation type.
 */
public abstract class AnnotationHandler {

    protected final AbstractProcessor processor;
    protected final String annotationTypeName;

    public AnnotationHandler(AbstractProcessor processor, String annotationTypeName) {
        this.processor = processor;
        this.annotationTypeName = annotationTypeName;
    }

    /**
     * Processes the presence of {@code annotation} on {@code element}.
     */
    public abstract void process(Element element, AnnotationMirror annotation, PluginGenerator generator);
}
