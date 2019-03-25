/*
 * Copyright (c) 2006, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.beans.editors;

/**
 * Property editor for a java builtin "int" type.
 *
 */

import java.beans.*;

public class IntegerEditor extends NumberEditor {


    public void setAsText(String text) throws IllegalArgumentException {
        setValue((text == null) ? null : Integer.decode(text));
    }

}
