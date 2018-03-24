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

package sun.jvm.hotspot.debugger.win32.coff;

/** Models the "sstStaticSym" subsection in Visual C++ 5.0 debug
    information. This subsection is structured exactly like the
    sstGlobalPub and sstGlobalSym subsections. It contains S_PROCREF
    for all static functions as well as S_DATAREF for static module
    level data and non-static data that could not be included (due to
    type conflicts) in the sstGlobalSym subsection. */

public interface DebugVC50SSStaticSym extends DebugVC50SSSymbolBase {
}
