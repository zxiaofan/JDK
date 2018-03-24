/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.parser;

import com.sun.tools.javac.parser.Tokens.TokenKind;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Log;
import com.sun.tools.javac.util.Name;

/**
 *  A utility class to parse a string in a doc comment containing a
 *  reference to an API element, such as a type, field or method.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ReferenceParser {
    /**
     * An object to contain the result of parsing a reference to an API element.
     * Any, but not all, of the member fields may be null.
     */
    static public class Reference {
        /** The type, if any, in the signature. */
        public final JCTree qualExpr;
        /** The member name, if any, in the signature. */
        public final Name member;
        /** The parameter types, if any, in the signature. */
        public final List<JCTree> paramTypes;

        Reference(JCTree qualExpr, Name member, List<JCTree> paramTypes) {
            this.qualExpr = qualExpr;
            this.member = member;
            this.paramTypes = paramTypes;
        }
    }

    /**
     * An exception that indicates an error occurred while parsing a signature.
     */
    static public class ParseException extends Exception {
        private static final long serialVersionUID = 0;
        ParseException(String message) {
            super(message);
        }
    }

    private final ParserFactory fac;

    /**
     * Create a parser object to parse reference signatures.
     * @param fac a factory for parsing Java source code.
     */
    public ReferenceParser(ParserFactory fac) {
        this.fac = fac;
    }

    /**
     * Parse a reference to an API element as may be found in doc comment.
     * @param sig the signature to be parsed
     * @return a {@code Reference} object containing the result of parsing the signature
     * @throws ParseException if there is an error while parsing the signature
     */
    public Reference parse(String sig) throws ParseException {

        // Break sig apart into qualifiedExpr member paramTypes.
        JCTree qualExpr;
        Name member;
        List<JCTree> paramTypes;

        Log.DeferredDiagnosticHandler deferredDiagnosticHandler
                = new Log.DeferredDiagnosticHandler(fac.log);

        try {
            int hash = sig.indexOf("#");
            int lparen = sig.indexOf("(", hash + 1);
            if (hash == -1) {
                if (lparen == -1) {
                    qualExpr = parseType(sig);
                    member = null;
                } else {
                    qualExpr = null;
                    member = parseMember(sig.substring(0, lparen));
                }
            } else {
                qualExpr = (hash == 0) ? null : parseType(sig.substring(0, hash));
                if (lparen == -1)
                    member = parseMember(sig.substring(hash + 1));
                else
                    member = parseMember(sig.substring(hash + 1, lparen));
            }

            if (lparen < 0) {
                paramTypes = null;
            } else {
                int rparen = sig.indexOf(")", lparen);
                if (rparen != sig.length() - 1)
                    throw new ParseException("dc.ref.bad.parens");
                paramTypes = parseParams(sig.substring(lparen + 1, rparen));
            }

            if (!deferredDiagnosticHandler.getDiagnostics().isEmpty())
                throw new ParseException("dc.ref.syntax.error");

        } finally {
            fac.log.popDiagnosticHandler(deferredDiagnosticHandler);
        }

        return new Reference(qualExpr, member, paramTypes);
    }

    private JCTree parseType(String s) throws ParseException {
        JavacParser p = fac.newParser(s, false, false, false);
        JCTree tree = p.parseType();
        if (p.token().kind != TokenKind.EOF)
            throw new ParseException("dc.ref.unexpected.input");
        return tree;
    }

    private Name parseMember(String s) throws ParseException {
        JavacParser p = fac.newParser(s, false, false, false);
        Name name = p.ident();
        if (p.token().kind != TokenKind.EOF)
            throw new ParseException("dc.ref.unexpected.input");
        return name;
    }

    private List<JCTree> parseParams(String s) throws ParseException {
        if (s.trim().isEmpty())
            return List.nil();

        JavacParser p = fac.newParser(s.replace("...", "[]"), false, false, false);
        ListBuffer<JCTree> paramTypes = new ListBuffer<>();
        paramTypes.add(p.parseType());

        if (p.token().kind == TokenKind.IDENTIFIER)
            p.nextToken();

        while (p.token().kind == TokenKind.COMMA) {
            p.nextToken();
            paramTypes.add(p.parseType());

            if (p.token().kind == TokenKind.IDENTIFIER)
                p.nextToken();
        }

        if (p.token().kind != TokenKind.EOF)
            throw new ParseException("dc.ref.unexpected.input");

        return paramTypes.toList();
    }
}
