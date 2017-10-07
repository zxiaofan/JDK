/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.api.tree;

import jdk.nashorn.internal.parser.Token;
import jdk.nashorn.internal.runtime.ParserException;

final class DiagnosticImpl implements Diagnostic {
    private final ParserException exp;
    private final Kind kind;

    DiagnosticImpl(final ParserException exp, final Kind kind) {
        this.exp = exp;
        this.kind = kind;
    }

    @Override
    public Kind getKind() {
        return kind;
    }

    @Override
    public long getPosition() {
        return exp.getPosition();
    }

    @Override
    public String getFileName() {
        return exp.getFileName();
    }

    @Override
    public long getLineNumber() {
        return exp.getLineNumber();
    }

    @Override
    public long getColumnNumber() {
        return exp.getColumnNumber();
    }

    @Override
    public String getCode() {
        final long token = exp.getToken();
        return (token < 0)? null : Token.toString(null, token, true);
    }

    @Override
    public String getMessage() {
        return exp.getMessage();
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
