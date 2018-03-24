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

import com.sun.xml.internal.rngom.ast.om.Location;
import com.sun.xml.internal.rngom.parse.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class DDataPattern extends DPattern {
    DPattern except;

    String datatypeLibrary;
    String type;

    final List<Param> params = new ArrayList<Param>();

    /**
     * Parameter to a data pattern.
     */
    public final class Param {
        String name;
        String value;
        Context context;
        String ns;
        Location loc;
        Annotation anno;

        public Param(String name, String value, Context context, String ns, Location loc, Annotation anno) {
            this.name = name;
            this.value = value;
            this.context = context;
            this.ns = ns;
            this.loc = loc;
            this.anno = anno;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public Context getContext() {
            return context;
        }

        public String getNs() {
            return ns;
        }

        public Location getLoc() {
            return loc;
        }

        public Annotation getAnno() {
            return anno;
        }
    }

    /**
     * Gets the datatype library URI.
     *
     * @return
     *      Can be empty (which represents the built-in datatypes), but never null.
     */
    public String getDatatypeLibrary() {
        return datatypeLibrary;
    }

    /**
     * Gets the datatype name, such as "int" or "token".
     *
     * @return
     *      never null.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the parameters of this &lt;data pattern.
     *
     * @return
     *      can be empty but never null.
     */
    public List<Param> getParams() {
        return params;
    }

    /**
     * Gets the pattern that reprsents the {@code <except>} child of this data pattern.
     *
     * @return null if not exist.
     */
    public DPattern getExcept() {
        return except;
    }

    public boolean isNullable() {
        return false;
    }

    public Object accept( DPatternVisitor visitor ) {
        return visitor.onData(this);
    }
}
