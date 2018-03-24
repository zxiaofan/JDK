/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime;

import jdk.nashorn.api.scripting.NashornException;
import jdk.nashorn.internal.objects.Global;
import jdk.nashorn.internal.parser.Token;

/**
 * ECMAScript parser exceptions.
 */
@SuppressWarnings("serial")
public final class ParserException extends NashornException {
    // Source from which this ParserException originated
    private final Source source;
    // token responsible for this exception
    private final long token;
    // if this is translated as ECMA error, which type should be used?
    private final JSErrorType errorType;

    /**
     * Constructor
     *
     * @param msg exception message for this parser error.
     */
    public ParserException(final String msg) {
        this(JSErrorType.SYNTAX_ERROR, msg, null, -1, -1, -1);
    }

    /**
     * Constructor
     *
     * @param errorType error type
     * @param msg       exception message
     * @param source    source from which this exception originates
     * @param line      line number of exception
     * @param column    column number of exception
     * @param token     token from which this exception originates
     *
     */
    public ParserException(final JSErrorType errorType, final String msg, final Source source, final int line, final int column, final long token) {
        super(msg, source != null ? source.getName() : null, line, column);
        this.source = source;
        this.token = token;
        this.errorType = errorType;
    }

    /**
     * Get the {@code Source} of this {@code ParserException}
     * @return source
     */
    public Source getSource() {
        return source;
    }

    /**
     * Get the token responsible for this {@code ParserException}
     * @return token
     */
    public long getToken() {
        return token;
    }

    /**
     * Get token position within source where the error originated.
     * @return token position if available, else -1
     */
    public int getPosition() {
        return Token.descPosition(token);
    }

    /**
     * Get the {@code JSErrorType} of this {@code ParserException}
     * @return error type
     */
    public JSErrorType getErrorType() {
        return errorType;
    }

    /**
     * Throw this {@code ParserException} as one of the 7 native JavaScript errors
     */
    public void throwAsEcmaException() {
        throw ECMAErrors.asEcmaException(this);
    }

    /**
     * Throw this {@code ParserException} as one of the 7 native JavaScript errors
     * @param global global scope object
     */
    public void throwAsEcmaException(final Global global) {
        throw ECMAErrors.asEcmaException(global, this);
    }
}

