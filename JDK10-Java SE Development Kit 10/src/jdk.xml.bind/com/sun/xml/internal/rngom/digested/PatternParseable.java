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
import com.sun.xml.internal.rngom.ast.builder.IncludedGrammar;
import com.sun.xml.internal.rngom.ast.builder.SchemaBuilder;
import com.sun.xml.internal.rngom.ast.builder.Scope;
import com.sun.xml.internal.rngom.ast.om.Location;
import com.sun.xml.internal.rngom.ast.om.ParsedNameClass;
import com.sun.xml.internal.rngom.ast.om.ParsedPattern;
import com.sun.xml.internal.rngom.nc.NameClass;
import com.sun.xml.internal.rngom.parse.Parseable;
import org.xml.sax.Locator;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
final class PatternParseable implements Parseable {
    private final DPattern pattern;

    public PatternParseable(DPattern p) {
        this.pattern = p;
    }

    public ParsedPattern parse(SchemaBuilder sb) throws BuildException {
        return (ParsedPattern)pattern.accept(new Parser(sb));
    }

    public ParsedPattern parseInclude(String uri, SchemaBuilder f, IncludedGrammar g, String inheritedNs) throws BuildException {
        throw new UnsupportedOperationException();
    }

    public ParsedPattern parseExternal(String uri, SchemaBuilder f, Scope s, String inheritedNs) throws BuildException {
        throw new UnsupportedOperationException();
    }


    private static class Parser implements DPatternVisitor<ParsedPattern> {
        private final SchemaBuilder sb;

        public Parser(SchemaBuilder sb) {
            this.sb = sb;
        }

        private Annotations parseAnnotation(DPattern p) {
            // TODO
            return null;
        }

        private Location parseLocation(DPattern p) {
            Locator l = p.getLocation();
            return sb.makeLocation(l.getSystemId(),l.getLineNumber(),l.getColumnNumber());
        }

        private ParsedNameClass parseNameClass(NameClass name) {
            // TODO: reparse the name class
            return name;
        }



        public ParsedPattern onAttribute(DAttributePattern p) {
            return sb.makeAttribute(
                parseNameClass(p.getName()),
                (ParsedPattern)p.getChild().accept(this),
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onChoice(DChoicePattern p) {
            List<ParsedPattern> kids = new ArrayList<ParsedPattern>();
            for( DPattern c=p.firstChild(); c!=null; c=c.next )
                kids.add( (ParsedPattern)c.accept(this) );
            return sb.makeChoice(kids,parseLocation(p),null);
        }

        public ParsedPattern onData(DDataPattern p) {
            // TODO
            return null;
        }

        public ParsedPattern onElement(DElementPattern p) {
            return sb.makeElement(
                parseNameClass(p.getName()),
                (ParsedPattern)p.getChild().accept(this),
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onEmpty(DEmptyPattern p) {
            return sb.makeEmpty(
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onGrammar(DGrammarPattern p) {
            // TODO
            return null;
        }

        public ParsedPattern onGroup(DGroupPattern p) {
            List<ParsedPattern> kids = new ArrayList<ParsedPattern>();
            for( DPattern c=p.firstChild(); c!=null; c=c.next )
                kids.add( (ParsedPattern)c.accept(this) );
            return sb.makeGroup(kids,parseLocation(p),null);
        }

        public ParsedPattern onInterleave(DInterleavePattern p) {
            List<ParsedPattern> kids = new ArrayList<ParsedPattern>();
            for( DPattern c=p.firstChild(); c!=null; c=c.next )
                kids.add( (ParsedPattern)c.accept(this) );
            return sb.makeInterleave(kids,parseLocation(p),null);
        }

        public ParsedPattern onList(DListPattern p) {
            return sb.makeList(
                (ParsedPattern)p.getChild().accept(this),
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onMixed(DMixedPattern p) {
            return sb.makeMixed(
                (ParsedPattern)p.getChild().accept(this),
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onNotAllowed(DNotAllowedPattern p) {
            return sb.makeNotAllowed(
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onOneOrMore(DOneOrMorePattern p) {
            return sb.makeOneOrMore(
                (ParsedPattern)p.getChild().accept(this),
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onOptional(DOptionalPattern p) {
            return sb.makeOptional(
                (ParsedPattern)p.getChild().accept(this),
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onRef(DRefPattern p) {
            // TODO
            return null;
        }

        public ParsedPattern onText(DTextPattern p) {
            return sb.makeText(
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onValue(DValuePattern p) {
            return sb.makeValue(
                p.getDatatypeLibrary(),
                p.getType(),
                p.getValue(),
                p.getContext(),
                p.getNs(),
                parseLocation(p),
                parseAnnotation(p) );
        }

        public ParsedPattern onZeroOrMore(DZeroOrMorePattern p) {
            return sb.makeZeroOrMore(
                (ParsedPattern)p.getChild().accept(this),
                parseLocation(p),
                parseAnnotation(p) );
        }
    }
}
