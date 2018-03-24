/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdeprscan;

/**
 * Exception representing an error encountered during CSV parsing.
 */
public class CSVParseException extends IllegalArgumentException {
    private static final long serialVersionUID = 6822670269555409371L;
    final String input;
    final int index;

    public CSVParseException(String msg, String input, int index) {
        super(msg);
        this.input = input;
        this.index = index;
    }

    public String getInput() { return input; }

    public int getIndex() { return index; }

    /**
     * Returns a string describing the parse error.
     *
     * @return a string describing the parse error
     */
    @Override
    public String getMessage() {
        return super.getMessage() + " at index " + index + ": " + input;
    }
}
