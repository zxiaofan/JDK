/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Copyright (C) 2004-2011
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sun.xml.internal.rngom.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Localizes messages.
 */
public class Localizer {
    private final Class cls;
    private ResourceBundle bundle;
    /**
     * If non-null, any resources that weren't found in this localizer
     * will be delegated to the parent.
     */
    private final Localizer parent;

    public Localizer(Class cls) {
        this(null,cls);
    }

    public Localizer(Localizer parent, Class cls) {
        this.parent = parent;
        this.cls = cls;
    }

    private String getString(String key) {
        try {
            return getBundle().getString(key);
        } catch( MissingResourceException e ) {
            // delegation
            if(parent!=null)
                return parent.getString(key);
            else
                throw e;
        }
    }

    public String message(String key) {
        return MessageFormat.format(getString(key), new Object[]{});
    }

    public String message(String key, Object arg) {
        return MessageFormat.format(getString(key),
            new Object[]{arg});
    }

    public String message(String key, Object arg1, Object arg2) {
        return MessageFormat.format(getString(key), new Object[]{
                arg1, arg2});
    }

    public String message(String key, Object[] args) {
        return MessageFormat.format(getString(key), args);
    }

    private ResourceBundle getBundle() {
        if (bundle == null) {
            String s = cls.getName();
            int i = s.lastIndexOf('.');
            if (i > 0)
                s = s.substring(0, i + 1);
            else
                s = "";
            bundle = ResourceBundle.getBundle(s + "Messages");
        }
        return bundle;
    }
}
