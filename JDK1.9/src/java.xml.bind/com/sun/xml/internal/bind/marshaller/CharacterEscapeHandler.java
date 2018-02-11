/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Performs character escaping and write the result
 * to the output.
 *
 * @since 1.0.1
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface CharacterEscapeHandler {

    /**
     * @param ch The array of characters.
     * @param start The starting position.
     * @param length The number of characters to use.
     * @param isAttVal true if this is an attribute value literal.
     */
    void escape( char[] ch, int start, int length, boolean isAttVal, Writer out ) throws IOException;

}
