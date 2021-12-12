/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.reflect;

/** Assists in iterating down a method's signature */

class SignatureIterator {
    private final String sig;
    private int idx;

    public SignatureIterator(String sig) {
        this.sig = sig;
        reset();
    }

    public void reset() {
        idx = 1;
    }

    public boolean atEnd() {
        return sig.charAt(idx) == ')';
    }

    public String next() {
        if (atEnd()) return null;
        char c = sig.charAt(idx);
        if (c != '[' && c != 'L') {
            ++idx;
            return String.valueOf(c);
        }
        // Walk forward to end of entry
        int endIdx = idx;
        if (c == '[') {
            while ((c = sig.charAt(endIdx)) == '[') {
                endIdx++;
            }
        }

        if (c == 'L') {
            while (sig.charAt(endIdx) != ';') {
                endIdx++;
            }
        }

        int beginIdx = idx;
        idx = endIdx + 1;
        return sig.substring(beginIdx, idx);
    }

    /** Should only be called when atEnd() is true. Does not change
        state of iterator. */
    public String returnType() {
        if (!atEnd()) {
            throw new InternalError("Illegal use of SignatureIterator");
        }
        return sig.substring(idx + 1, sig.length());
    }
}
