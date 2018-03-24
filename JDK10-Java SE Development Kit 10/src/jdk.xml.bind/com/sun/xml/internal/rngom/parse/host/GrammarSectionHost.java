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
package com.sun.xml.internal.rngom.parse.host;

import com.sun.xml.internal.rngom.ast.builder.Annotations;
import com.sun.xml.internal.rngom.ast.builder.BuildException;
import com.sun.xml.internal.rngom.ast.builder.CommentList;
import com.sun.xml.internal.rngom.ast.builder.Div;
import com.sun.xml.internal.rngom.ast.builder.GrammarSection;
import com.sun.xml.internal.rngom.ast.builder.Include;
import com.sun.xml.internal.rngom.ast.om.Location;
import com.sun.xml.internal.rngom.ast.om.ParsedElementAnnotation;
import com.sun.xml.internal.rngom.ast.om.ParsedPattern;

/**
 *
 * @author
 *      Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class GrammarSectionHost extends Base implements GrammarSection {
    private final GrammarSection lhs;
    private final GrammarSection rhs;

    GrammarSectionHost( GrammarSection lhs, GrammarSection rhs ) {
        this.lhs = lhs;
        this.rhs = rhs;
        if(lhs==null || rhs==null)
            throw new IllegalArgumentException();
    }

    public void define(String name, Combine combine, ParsedPattern _pattern,
        Location _loc, Annotations _anno) throws BuildException {
        ParsedPatternHost pattern = (ParsedPatternHost) _pattern;
        LocationHost loc = cast(_loc);
        AnnotationsHost anno = cast(_anno);

        lhs.define(name, combine, pattern.lhs, loc.lhs, anno.lhs);
        rhs.define(name, combine, pattern.rhs, loc.rhs, anno.rhs);
    }

    public Div makeDiv() {
        return new DivHost( lhs.makeDiv(), rhs.makeDiv() );
    }

    public Include makeInclude() {
        Include l = lhs.makeInclude();
        if(l==null) return null;
        return new IncludeHost( l, rhs.makeInclude() );
    }

    public void topLevelAnnotation(ParsedElementAnnotation _ea) throws BuildException {
        ParsedElementAnnotationHost ea = (ParsedElementAnnotationHost) _ea;
        lhs.topLevelAnnotation(ea==null?null:ea.lhs);
        rhs.topLevelAnnotation(ea==null?null:ea.rhs);
    }

    public void topLevelComment(CommentList _comments) throws BuildException {
        CommentListHost comments = (CommentListHost) _comments;

        lhs.topLevelComment(comments==null?null:comments.lhs);
        rhs.topLevelComment(comments==null?null:comments.rhs);
    }
}
