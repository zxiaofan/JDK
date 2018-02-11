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
 *
 *
 */
package com.sun.javafx.scene.control;

import javafx.scene.control.IndexRange;

public interface FormatterAccessor {

    public int getTextLength();
    public String getText(int begin, int end);

    public int getCaret();
    public int getAnchor();

}
