/*
 * Copyright (c) 2001, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javadoc.main;

import java.io.File;
import javax.tools.FileObject;

import com.sun.javadoc.SourcePosition;
import com.sun.tools.javac.util.Position;

/**
 * A source position: filename, line number, and column number.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @since J2SE1.4
 * @author Neal M Gafter
 * @author Michael Van De Vanter (position representation changed to char offsets)
 */
@Deprecated
public class SourcePositionImpl implements SourcePosition {
    FileObject filename;
    int position;
    Position.LineMap lineMap;

    /** The source file. Returns null if no file information is
     *  available. */
    public File file() {
        return (filename == null) ? null : new File(filename.getName());
    }

    /** The source file. Returns null if no file information is
     *  available. */
    public FileObject fileObject() {
        return filename;
    }

    /** The line in the source file. The first line is numbered 1;
     *  0 means no line number information is available. */
    public int line() {
        if (lineMap == null) {
            return 0;
        } else {
            return lineMap.getLineNumber(position);
        }
    }

    /** The column in the source file. The first column is
     *  numbered 1; 0 means no column information is available.
     *  Columns count characters in the input stream; a tab
     *  advances the column number to the next 8-column tab stop.
     */
    public int column() {
        if (lineMap == null) {
            return 0;
        }else {
            return lineMap.getColumnNumber(position);
        }
    }

    private SourcePositionImpl(FileObject file, int position,
                               Position.LineMap lineMap) {
        super();
        this.filename = file;
        this.position = position;
        this.lineMap = lineMap;
    }

    public static SourcePosition make(FileObject file, int pos,
                                      Position.LineMap lineMap) {
        if (file == null) return null;
        return new SourcePositionImpl(file, pos, lineMap);
    }

    public String toString() {
        // Backwards compatibility hack. ZipFileObjects use the format
        // zipfile(zipentry) but javadoc has been using zipfile/zipentry
        String fn = filename.getName();
        if (fn.endsWith(")")) {
            int paren = fn.lastIndexOf("(");
            if (paren != -1) {
                int i = paren+1;
                if (fn.charAt(i) == '/')
                    i++;
                fn = fn.substring(0, paren)
                        + File.separatorChar
                        + fn.substring(i, fn.length() - 1);
            }
        }

        if (position == Position.NOPOS)
            return fn;
        else
            return fn + ":" + line();
    }
}
