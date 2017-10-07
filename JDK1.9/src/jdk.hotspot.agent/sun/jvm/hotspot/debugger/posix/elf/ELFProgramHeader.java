/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.debugger.posix.elf;

/**
 * This is the interface definintion for a ProgramHeader in an ELF file.
 * Program headers contain system information necessary for preparing a program
 * for execution.
 */
public interface ELFProgramHeader {
    /** Type defining that the array element is unused.  Other member values
     * are undefined. */
    public static final int TYPE_NULL = 0;
    /** Type defining that the array element specifies a loadable segment. */
    public static final int TYPE_LOAD = 1;
    public static final int TYPE_DYNAMIC = 2;
    public static final int TYPE_INTERP = 3;
    public static final int TYPE_NOTE = 4;
    public static final int TYPE_SHLIB = 5;
    public static final int TYPE_PHDR = 6;
    public static final int TYPE_LOPROC = 0x70000000;
    public static final int TYPE_HIPROC = 0x7fffffff;

    public int getType();
}
