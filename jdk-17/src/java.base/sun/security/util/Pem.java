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

package sun.security.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * The Length interface defines the length of an object
 */
public class Pem {

    /**
     * Decodes a PEM-encoded block.
     *
     * @param input the input string, according to RFC 1421, can only contain
     *              characters in the base-64 alphabet and whitespaces.
     * @return the decoded bytes
     * @throws java.io.IOException if input is invalid
     */
    public static byte[] decode(String input) throws IOException {
        byte[] src = input.replaceAll("\\s+", "")
                .getBytes(StandardCharsets.ISO_8859_1);
        try {
            return Base64.getDecoder().decode(src);
        } catch (IllegalArgumentException e) {
            throw new IOException(e);
        }
    }
}
