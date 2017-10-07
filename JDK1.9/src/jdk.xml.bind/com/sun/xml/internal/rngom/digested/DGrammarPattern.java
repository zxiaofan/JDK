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
package com.sun.xml.internal.rngom.digested;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * {@code <grammar>} pattern, which is a collection of named patterns.
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class DGrammarPattern extends DPattern implements Iterable<DDefine> {
    private final Map<String,DDefine> patterns = new HashMap<String,DDefine>();

    DPattern start;

    /**
     * Gets the start pattern.
     */
    public DPattern getStart() {
        return start;
    }

    /**
     * Gets the named pattern by its name.
     *
     * @return
     *      null if not found.
     */
    public DDefine get( String name ) {
        return patterns.get(name);
    }

    DDefine getOrAdd( String name ) {
        if(patterns.containsKey(name)) {
            return get(name);
        } else {
            DDefine d = new DDefine(name);
            patterns.put(name,d);
            return d;
        }
    }

    /**
     * Iterates all the {@link DDefine}s in this grammar.
     */
    public Iterator<DDefine> iterator() {
        return patterns.values().iterator();
    }

    public boolean isNullable() {
        return start.isNullable();
    }

    public <V> V accept( DPatternVisitor<V> visitor ) {
        return visitor.onGrammar(this);
    }
}
