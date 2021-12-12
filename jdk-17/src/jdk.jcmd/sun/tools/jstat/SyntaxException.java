/*
 * Copyright (c) 2004, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jstat;

import java.io.StreamTokenizer;
import java.util.Set;
import java.util.Iterator;

/**
 * An exception class for syntax exceptions detected by the options file
 * parser.
 *
 * @author Brian Doherty
 * @since 1.5
 */
@SuppressWarnings("serial") // JDK implementation class
public class SyntaxException extends ParserException {
    private String message;

    public SyntaxException(String message) {
        this.message = message;
    }

    public SyntaxException(int lineno, String expected, String found) {
        message = "Syntax error at line " + lineno
                  + ": Expected " + expected
                  + ", Found " + found;
    }

    public SyntaxException(int lineno, String expected, Token found) {
        message = "Syntax error at line " + lineno
                  + ": Expected " + expected
                  + ", Found " + found.toMessage();
    }

    public SyntaxException(int lineno, Token expected, Token found) {
        message = "Syntax error at line " + lineno
                  + ": Expected " + expected.toMessage()
                  + ", Found " + found.toMessage();
    }

    public SyntaxException(int lineno, Set<String> expected, Token found) {
        StringBuilder msg = new StringBuilder();

        msg.append("Syntax error at line ").append(lineno)
                .append(": Expected one of \'");

        for (String keyWord : expected) {
            msg.append(keyWord).append('|');
        }
        if (!expected.isEmpty()) {
            msg.setLength(msg.length() - 1);
        }

        message = msg.append("\', Found ").append(found.toMessage()).toString();
    }

    public String getMessage() {
        return message;
    }
}

