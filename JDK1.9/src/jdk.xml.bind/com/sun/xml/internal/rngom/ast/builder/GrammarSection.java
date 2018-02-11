/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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
 * Copyright (C) 2004-2015
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
package com.sun.xml.internal.rngom.ast.builder;

import com.sun.xml.internal.rngom.ast.om.Location;
import com.sun.xml.internal.rngom.ast.om.ParsedElementAnnotation;
import com.sun.xml.internal.rngom.ast.om.ParsedPattern;

/**
 * The container that can have {@code <define>} elements.
 * <p>
 * {@link Div}, {@link Grammar}, {@link Include}, or {@link IncludedGrammar}.
 */
public interface GrammarSection<
    P extends ParsedPattern,
    E extends ParsedElementAnnotation,
    L extends Location,
    A extends Annotations<E,L,CL>,
    CL extends CommentList<L>> {

    static final class Combine {
        private final String name;
        private Combine(String name) {
            this.name = name;
        }
        final public String toString() {
            return name;
        }
    }

    static final Combine COMBINE_CHOICE = new Combine("choice");
    static final Combine COMBINE_INTERLEAVE = new Combine("interleave");

    // using \u0000 guarantees that the name will be never used as
    // a user-defined pattern name.
    static final String START = "\u0000#start\u0000";

    /**
     * Called when a pattern is defined.
     *
     * @param name
     *      Name of the pattern. For the definition by a {@code <start/>} element,
     *      this parameter is the same as {@link #START}.
     *      to test if it's a named pattern definition or the start pattern definition.
     * @param combine
     *      null or {@link #COMBINE_CHOICE} or {@link #COMBINE_INTERLEAVE} depending
     *      on the value of the combine attribute.
     * @param pattern
     *      The pattern to be defined.
     */
    void define( String name, Combine combine, P pattern, L loc, A anno) throws BuildException;

    /**
     * Called when an annotation is found.
     */
    void topLevelAnnotation(E ea) throws BuildException;

    /**
     * Called when a comment is found.
     */
    void topLevelComment(CL comments) throws BuildException;

    /**
     * Called when {@code <div>} is found.
     *
     * @return
     *      the returned {@link Div} object will receive callbacks for structures
     *      inside the {@code <div>} element.
     */
    Div<P,E,L,A,CL> makeDiv();

    /**
     * Returns null if already in an include.
     */
    Include<P,E,L,A,CL> makeInclude();
}
