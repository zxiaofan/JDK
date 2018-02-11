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

/**
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class DPatternWalker implements DPatternVisitor<Void> {
    public Void onAttribute(DAttributePattern p) {
        return onXmlToken(p);
    }

    protected Void onXmlToken(DXmlTokenPattern p) {
        return onUnary(p);
    }

    public Void onChoice(DChoicePattern p) {
        return onContainer(p);
    }

    protected Void onContainer(DContainerPattern p) {
        for( DPattern c=p.firstChild(); c!=null; c=c.next )
            c.accept(this);
        return null;
    }

    public Void onData(DDataPattern p) {
        return null;
    }

    public Void onElement(DElementPattern p) {
        return onXmlToken(p);
    }

    public Void onEmpty(DEmptyPattern p) {
        return null;
    }

    public Void onGrammar(DGrammarPattern p) {
        return p.getStart().accept(this);
    }

    public Void onGroup(DGroupPattern p) {
        return onContainer(p);
    }

    public Void onInterleave(DInterleavePattern p) {
        return onContainer(p);
    }

    public Void onList(DListPattern p) {
        return onUnary(p);
    }

    public Void onMixed(DMixedPattern p) {
        return onUnary(p);
    }

    public Void onNotAllowed(DNotAllowedPattern p) {
        return null;
    }

    public Void onOneOrMore(DOneOrMorePattern p) {
        return onUnary(p);
    }

    public Void onOptional(DOptionalPattern p) {
        return onUnary(p);
    }

    public Void onRef(DRefPattern p) {
        return p.getTarget().getPattern().accept(this);
    }

    public Void onText(DTextPattern p) {
        return null;
    }

    public Void onValue(DValuePattern p) {
        return null;
    }

    public Void onZeroOrMore(DZeroOrMorePattern p) {
        return onUnary(p);
    }

    protected Void onUnary(DUnaryPattern p) {
        return p.getChild().accept(this);
    }
}
