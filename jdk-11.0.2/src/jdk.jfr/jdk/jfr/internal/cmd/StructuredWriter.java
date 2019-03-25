/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.cmd;

import java.io.PrintWriter;

abstract class StructuredWriter {
    private final static String LINE_SEPARATOR = String.format("%n");

    private final PrintWriter out;
    private final StringBuilder builder = new StringBuilder(4000);

    private char[] indentionArray = new char[0];
    private int indent = 0;
    private int column;

    StructuredWriter(PrintWriter p) {
        out = p;
    }

    final protected int getColumn() {
        return column;
    }

    // Flush to print writer
    public final void flush() {
        out.print(builder.toString());
        builder.setLength(0);
    }

    final public void printIndent() {
        builder.append(indentionArray, 0, indent);
        column += indent;
    }

    final public void println() {
        builder.append(LINE_SEPARATOR);
        column = 0;
    }

    final public void print(String... texts) {
        for (String text : texts) {
            print(text);
        }
    }

    final public void printAsString(Object o) {
        print(String.valueOf(o));
    }

    final public void print(String text) {
        builder.append(text);
        column += text.length();
    }

    final public void print(char c) {
        builder.append(c);
        column++;
    }

    final public void print(int value) {
        print(String.valueOf(value));
    }

    final public void indent() {
        indent += 2;
        updateIndent();
    }

    final public void retract() {
        indent -= 2;
        updateIndent();
    }

    final public void println(String text) {
        print(text);
        println();
    }

    private void updateIndent() {
        if (indent > indentionArray.length) {
            indentionArray = new char[indent];
            for (int i = 0; i < indentionArray.length; i++) {
                indentionArray[i] = ' ';
            }
        }
    }
}
