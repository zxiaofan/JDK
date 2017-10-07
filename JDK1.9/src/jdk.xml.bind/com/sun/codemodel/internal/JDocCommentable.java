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

/**
 * Program elements that can have Javadoc
 *
 * @author Jonas von Malottki
 */
public interface JDocCommentable {
    /**
     * @return the JavaDoc of the Element
     */
    JDocComment javadoc();
}
