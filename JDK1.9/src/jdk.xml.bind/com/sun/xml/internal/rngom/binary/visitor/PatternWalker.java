/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.xml.internal.rngom.binary.visitor;

import com.sun.xml.internal.rngom.binary.Pattern;
import com.sun.xml.internal.rngom.nc.NameClass;
import com.sun.xml.internal.org.relaxng.datatype.Datatype;

/**
 * Walks the pattern tree.
 *
 * @author
 *      Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class PatternWalker implements PatternVisitor {
    public void visitEmpty() {
    }

    public void visitNotAllowed() {
    }

    public void visitError() {
    }

    public void visitGroup(Pattern p1, Pattern p2) {
        visitBinary(p1, p2);
    }

    protected void visitBinary(Pattern p1, Pattern p2) {
        p1.accept(this);
        p2.accept(this);
    }

    public void visitInterleave(Pattern p1, Pattern p2) {
        visitBinary(p1, p2);
    }

    public void visitChoice(Pattern p1, Pattern p2) {
        visitBinary(p1, p2);
    }

    public void visitOneOrMore(Pattern p) {
        p.accept(this);
    }

    public void visitElement(NameClass nc, Pattern content) {
        content.accept(this);
    }

    public void visitAttribute(NameClass ns, Pattern value) {
        value.accept(this);
    }

    public void visitData(Datatype dt) {
    }

    public void visitDataExcept(Datatype dt, Pattern except) {
    }

    public void visitValue(Datatype dt, Object obj) {
    }

    public void visitText() {
    }

    public void visitList(Pattern p) {
        p.accept(this);
    }

    public void visitAfter(Pattern p1, Pattern p2) {
    }
}
