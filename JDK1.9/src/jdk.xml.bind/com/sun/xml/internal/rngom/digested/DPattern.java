/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Copyright (C) 2004-2012
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
package com.sun.xml.internal.rngom.digested;

import com.sun.xml.internal.rngom.ast.om.ParsedPattern;
import com.sun.xml.internal.rngom.parse.Parseable;
import org.xml.sax.Locator;

/**
 * Base class of all the patterns.
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public abstract class DPattern implements ParsedPattern {

    Locator location;
    DAnnotation annotation;
    /**
     * Used to chain the child patterns in a doubly-linked list.
     */
    DPattern next;
    DPattern prev;

    /**
     * Returns where the pattern is defined in the source code.
     */
    public Locator getLocation() {
        return location;
    }

    /**
     * Returns the annotation associated with it.
     *
     * @return may be empty, but never be null.
     */
    public DAnnotation getAnnotation() {
        if (annotation == null) {
            return DAnnotation.EMPTY;
        }
        return annotation;
    }

    /**
     * Returns true if this pattern is nullable.
     *
     * A nullable pattern is a pattern that can match the empty sequence.
     */
    public abstract boolean isNullable();

    public abstract <V> V accept(DPatternVisitor<V> visitor);

    /**
     * Creates a {@link Parseable} object that reparses this pattern.
     */
    public Parseable createParseable() {
        return new PatternParseable(this);
    }

    /**
     * Returns true if this is {@link DElementPattern}.
     */
    public final boolean isElement() {
        return this instanceof DElementPattern;
    }

    /**
     * Returns true if this is {@link DAttributePattern}.
     */
    public final boolean isAttribute() {
        return this instanceof DAttributePattern;
    }
}
