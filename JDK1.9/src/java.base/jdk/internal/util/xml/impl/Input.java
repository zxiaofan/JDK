/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.util.xml.impl;

import java.io.Reader;

/**
 * A parsed entity input state.
 *
 * This class represents a parsed entity input state. The parser uses
 * an instance of this class to manage input.
 */

public class Input {

    /** The entity public identifier or null. */
    public String pubid;
    /** The entity systen identifier or null. */
    public String sysid;
    /** The encoding from XML declaration or null */
    public String xmlenc;
    /** The XML version from XML declaration or 0x0000 */
    public char xmlver;
    /** The entity reader. */
    public Reader src;
    /** The character buffer. */
    public char[] chars;
    /** The length of the character buffer. */
    public int chLen;
    /** The index of the next character to read. */
    public int chIdx;
    /** The next input in a chain. */
    public Input next;

    /**
     * Constructor.
     *
     * @param buffsize The input buffer size.
     */
    public Input(int buffsize) {
        chars = new char[buffsize];
        chLen = chars.length;
    }

    /**
     * Constructor.
     *
     * @param buff The input buffer.
     */
    public Input(char[] buff) {
        chars = buff;
        chLen = chars.length;
    }

    /**
     * Constructor.
     */
    public Input() {
    }
}
