/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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
 * @(#)$Id: EncoderFactory.java,v 1.3 2005/09/10 19:07:33 kohsuke Exp $
 */
package com.sun.codemodel.internal.util;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Creates {@link CharsetEncoder} from a charset name.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public class EncoderFactory {

    public static CharsetEncoder createEncoder( String encodin ) {
        Charset cs = Charset.forName(System.getProperty("file.encoding"));
        CharsetEncoder encoder = cs.newEncoder();
        return encoder;
    }
}
