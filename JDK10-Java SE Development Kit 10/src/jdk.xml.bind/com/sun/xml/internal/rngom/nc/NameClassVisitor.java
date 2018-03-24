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
package com.sun.xml.internal.rngom.nc;

import javax.xml.namespace.QName;

/**
 * Visitor pattern over {@link NameClass} and its subclasses.
 */
public interface NameClassVisitor<V> {
    /**
     * Called for {@link ChoiceNameClass}
     */
    V visitChoice(NameClass nc1, NameClass nc2);
    /**
     * Called for {@link NsNameClass}
     */
    V visitNsName(String ns);
    /**
     * Called for {@link NsNameExceptNameClass}
     */
    V visitNsNameExcept(String ns, NameClass nc);
    /**
     * Called for {@link NameClass#ANY}
     */
    V visitAnyName();
    /**
     * Called for {@link AnyNameExceptNameClass}
     */
    V visitAnyNameExcept(NameClass nc);
    /**
     * Called for {@link SimpleNameClass}
     */
    V visitName(QName name);
    /**
     * Called for {@link NameClass#NULL}.
     */
    V visitNull();
}
