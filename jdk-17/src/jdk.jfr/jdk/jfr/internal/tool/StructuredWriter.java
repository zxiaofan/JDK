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

package jdk.jfr.internal.tool;

import java.io.PrintWriter;

abstract class StructuredWriter {
    private final PrintWriter out;
    private final StringBuilder builder = new StringBuilder(4000);

    private char[] indentionArray = new char[0];
    private int indent = 0;
    private int column;
    // print first event immediately so tool feels responsive
    private boolean first = true;
    private String lineSeparator = String.format("%n");

    StructuredWriter(PrintWriter p) {
        out = p;
    }

    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    protected final int getColumn() {
        return column;
    }

    // Flush to print writer
    public final void flush(boolean hard) {
        if (hard) {
            out.print(builder.toString());
            builder.setLength(0);
            return;
        }
        if (first || builder.length() > 100_000) {
            out.print(builder.toString());
            builder.setLength(0);
            first = false;
        }
    }

    public final void printIndent() {
        builder.append(indentionArray, 0, indent);
        column += indent;
    }

    public final void println() {
        builder.append(lineSeparator);
        column = 0;
    }

    public final void print(String... texts) {
        for (String text : texts) {
            print(text);
        }
    }

    public final void printAsString(Object o) {
        print(String.valueOf(o));
    }

    public final void print(String text) {
        builder.append(text);
        column += text.length();
    }

    public final void print(char c) {
        builder.append(c);
        column++;
    }

    public final void print(int value) {
        print(String.valueOf(value));
    }

    public final void indent() {
        indent += 2;
        updateIndent();
    }

    public final void retract() {
        indent -= 2;
        updateIndent();
    }

    public final void println(String text) {
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
