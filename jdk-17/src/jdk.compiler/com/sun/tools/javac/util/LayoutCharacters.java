/*
 * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.util;

/** An interface containing layout character constants used in Java
 *  programs.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public interface LayoutCharacters {

    /** Tabulator column increment.
     */
    static final int TabInc = 8;

    /** Standard indentation for subdiagnostics
     */
    static final int DiagInc = 4;

    /** Standard indentation for additional diagnostic lines
     */
    static final int DetailsInc = 2;

    /** Tabulator character.
     */
    static final byte TAB   = 0x9;

    /** Line feed character.
     */
    static final byte LF    = 0xA;

    /** Form feed character.
     */
    static final byte FF    = 0xC;

    /** Carriage return character.
     */
    static final byte CR    = 0xD;

    /** End of input character.  Used as a sentinel to denote the
     *  character one beyond the last defined character in a
     *  source file.
     */
    static final byte EOI   = 0x1A;

    /** Bump column to the next tab.
     */
    static int tabulate(int column) {
        return (column / TabInc * TabInc) + TabInc;
    }
}
