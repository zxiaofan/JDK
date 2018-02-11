/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.marshaller;

import java.io.IOException;
import java.io.Writer;

/**
 * Performs no character escaping.
 *
 * @author
 *     Roman Grigoriadi (roman.grigoriadi@oracle.com)
 */
public class NoEscapeHandler implements CharacterEscapeHandler {

    public static final NoEscapeHandler theInstance = new NoEscapeHandler();

    @Override
    public void escape(char[] ch, int start, int length, boolean isAttVal, Writer out) throws IOException {
        out.write(ch, start, length);
    }
}
