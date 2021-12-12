/*
 * Copyright (c) 2010, 2011, Oracle and/or its affiliates. All rights reserved.
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
 *******************************************************************************
 * Copyright (C) 2009, International Business Machines Corporation and         *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 */
package sun.util.locale;

public class StringTokenIterator {
    private String text;
    private String dlms;        // null if a single char delimiter
    private char delimiterChar; // delimiter if a single char delimiter

    private String token;
    private int start;
    private int end;
    private boolean done;

    public StringTokenIterator(String text, String dlms) {
        this.text = text;
        if (dlms.length() == 1) {
            delimiterChar = dlms.charAt(0);
        } else {
            this.dlms = dlms;
        }
        setStart(0);
    }

    public String first() {
        setStart(0);
        return token;
    }

    public String current() {
        return token;
    }

    public int currentStart() {
        return start;
    }

    public int currentEnd() {
        return end;
    }

    public boolean isDone() {
        return done;
    }

    public String next() {
        if (hasNext()) {
            start = end + 1;
            end = nextDelimiter(start);
            token = text.substring(start, end);
        } else {
            start = end;
            token = null;
            done = true;
        }
        return token;
    }

    public boolean hasNext() {
        return (end < text.length());
    }

    public StringTokenIterator setStart(int offset) {
        if (offset > text.length()) {
            throw new IndexOutOfBoundsException();
        }
        start = offset;
        end = nextDelimiter(start);
        token = text.substring(start, end);
        done = false;
        return this;
    }

    public StringTokenIterator setText(String text) {
        this.text = text;
        setStart(0);
        return this;
    }

    private int nextDelimiter(int start) {
        int textlen = this.text.length();
        if (dlms == null) {
            for (int idx = start; idx < textlen; idx++) {
                if (text.charAt(idx) == delimiterChar) {
                    return idx;
                }
            }
        } else {
            int dlmslen = dlms.length();
            for (int idx = start; idx < textlen; idx++) {
                char c = text.charAt(idx);
                for (int i = 0; i < dlmslen; i++) {
                    if (c == dlms.charAt(i)) {
                        return idx;
                    }
                }
            }
        }
        return textlen;
    }
}
