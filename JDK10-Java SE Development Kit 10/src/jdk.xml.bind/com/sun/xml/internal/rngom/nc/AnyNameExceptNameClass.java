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

public class AnyNameExceptNameClass extends NameClass {

    private final NameClass nameClass;

    public AnyNameExceptNameClass(NameClass nameClass) {
        this.nameClass = nameClass;
    }

    public boolean contains(QName name) {
        return !nameClass.contains(name);
    }

    public int containsSpecificity(QName name) {
        return contains(name) ? SPECIFICITY_ANY_NAME : SPECIFICITY_NONE;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AnyNameExceptNameClass))
            return false;
        return nameClass.equals(((AnyNameExceptNameClass) obj).nameClass);
    }

    public int hashCode() {
        return ~nameClass.hashCode();
    }

    public <V> V accept(NameClassVisitor<V> visitor) {
        return visitor.visitAnyNameExcept(nameClass);
    }

    public boolean isOpen() {
        return true;
    }
}
