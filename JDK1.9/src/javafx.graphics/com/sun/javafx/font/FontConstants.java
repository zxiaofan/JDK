/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font;

public interface FontConstants {
    /*  useful tags */
    public static final int ttcfTag = 0x74746366; // 'ttcf' - TTC file
    public static final int v1ttTag = 0x00010000; // 'v1tt' - Version 1 TT font
    public static final int trueTag = 0x74727565; // 'true' - Version 2 TT font
    public static final int ottoTag = 0x4f54544f; // 'otto' - OpenType CFF font
    public static final int woffTag = 0x774F4646; // 'wOFF' - WOFF File Format
    public static final int cmapTag = 0x636D6170; // 'cmap'
    public static final int headTag = 0x68656164; // 'head'
    public static final int hheaTag = 0x68686561; // 'hhea'
    public static final int hmtxTag = 0x686D7478; // 'hmtx'
    public static final int maxpTag = 0x6D617870; // 'maxp'
    public static final int nameTag = 0x6E616D65; // 'name'
    public static final int os_2Tag = 0x4F532F32; // 'OS/2'
    public static final int postTag = 0x706F7374; // 'post'

    /* sizes, in bytes, of TT/TTC header records */
    public static final int TTCHEADERSIZE = 12;
    public static final int DIRECTORYHEADERSIZE = 12;
    public static final int DIRECTORYENTRYSIZE = 16;

    /* WOFF headers recored */
    public static final int WOFFHEADERSIZE = 44;
    public static final int WOFFDIRECTORYENTRYSIZE = 20;
}
