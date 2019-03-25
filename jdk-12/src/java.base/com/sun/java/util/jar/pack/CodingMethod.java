/*
 * Copyright (c) 2003, 2010, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.java.util.jar.pack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface for encoding and decoding int arrays using bytewise codes.
 * @author John Rose
 */
interface CodingMethod {
    // Read and write an array of ints from/to a stream.
    public void readArrayFrom(InputStream in, int[] a, int start, int end) throws IOException;
    public void writeArrayTo(OutputStream out, int[] a, int start, int end) throws IOException;

    // how to express me in a band header?
    public byte[] getMetaCoding(Coding dflt);
}
