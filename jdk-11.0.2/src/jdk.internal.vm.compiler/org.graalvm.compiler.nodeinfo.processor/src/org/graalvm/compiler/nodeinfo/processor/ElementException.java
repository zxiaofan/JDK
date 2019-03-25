/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodeinfo.processor;

import javax.lang.model.element.Element;

/**
 * Denotes an error encountered while processing an element.
 */
@SuppressWarnings("serial")
public class ElementException extends RuntimeException {
    public final Element element;

    public ElementException(Element element, String format, Object... args) {
        super(String.format(format, args));
        this.element = element;
    }
}
