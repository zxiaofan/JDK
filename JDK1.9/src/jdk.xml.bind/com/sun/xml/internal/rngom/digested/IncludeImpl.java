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
package com.sun.xml.internal.rngom.digested;

import com.sun.xml.internal.rngom.ast.builder.Annotations;
import com.sun.xml.internal.rngom.ast.builder.BuildException;
import com.sun.xml.internal.rngom.ast.builder.Include;
import com.sun.xml.internal.rngom.ast.builder.IncludedGrammar;
import com.sun.xml.internal.rngom.ast.builder.Scope;
import com.sun.xml.internal.rngom.ast.om.Location;
import com.sun.xml.internal.rngom.ast.om.ParsedPattern;
import com.sun.xml.internal.rngom.parse.IllegalSchemaException;
import com.sun.xml.internal.rngom.parse.Parseable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
final class IncludeImpl extends GrammarBuilderImpl implements Include {

    private Set overridenPatterns = new HashSet();
    private boolean startOverriden = false;

    public IncludeImpl(DGrammarPattern p, Scope parent, DSchemaBuilderImpl sb) {
        super(p, parent, sb);
    }

    @Override
    public void define(String name, Combine combine, ParsedPattern pattern, Location loc, Annotations anno) throws BuildException {
        super.define(name, combine, pattern, loc, anno);
        if(name==START)
            startOverriden = true;
        else
            overridenPatterns.add(name);
    }

    public void endInclude(Parseable current, String uri, String ns, Location loc, Annotations anno) throws BuildException, IllegalSchemaException {
        current.parseInclude(uri,sb,new IncludedGrammarImpl(grammar,parent,sb),ns);
    }

    private class IncludedGrammarImpl extends GrammarBuilderImpl implements IncludedGrammar {
        public IncludedGrammarImpl(DGrammarPattern p, Scope parent, DSchemaBuilderImpl sb) {
            super(p, parent, sb);
        }

        @Override
        public void define(String name, Combine combine, ParsedPattern pattern, Location loc, Annotations anno) throws BuildException {
            // check for overridden pattern
            if(name==START) {
                if(startOverriden)
                    return;
            } else {
                if(overridenPatterns.contains(name))
                    return;
            }
            // otherwise define
            super.define(name, combine, pattern, loc, anno);
        }

        public ParsedPattern endIncludedGrammar(Location loc, Annotations anno) throws BuildException {
            return null;
        }
    }
}
