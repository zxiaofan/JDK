/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.css.parser;

import javafx.css.Stylesheet;

import java.io.File;
import java.io.IOException;

/** Css2Bin <input file> [<output file name>]
 * java com.sun.javafx.css.parser.Css2Bin input.css output.bss
 *  If no output file is given, then the input file name is used with an extension of 'bss'x
 */
public final class Css2Bin {
    public static void main(String args[]) throws Exception {

        if ( args.length < 1 ) throw new IllegalArgumentException("expected file name as argument");

        try {
            String ifname = args[0];
            String ofname = (args.length > 1) ?
                args[1] : ifname.substring(0, ifname.lastIndexOf('.')+1).concat("bss");

            convertToBinary(ifname, ofname);

        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    public static void convertToBinary(String ifname, String ofname) throws IOException {

        if (ifname == null || ofname == null) {
            throw new IllegalArgumentException("parameters cannot be null");
        }

        if (ifname.equals(ofname)) {
            throw new IllegalArgumentException("input file and output file cannot be the same");
        }

        final File source = new File(ifname);
        final File destination = new File(ofname);
        Stylesheet.convertToBinary(source, destination);

    }

}
