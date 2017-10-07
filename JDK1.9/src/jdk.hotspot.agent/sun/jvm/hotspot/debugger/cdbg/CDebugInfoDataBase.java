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

package sun.jvm.hotspot.debugger.cdbg;

import sun.jvm.hotspot.debugger.*;

/** Database for C and C++ debug information. This is being kept as
    minimal as possible for now. It is not complete; for example, it
    will have to be extended to support scoped information (module
    scope, namespace scope). */

public interface CDebugInfoDataBase {
  /** Name-to-type mapping */
  public Type lookupType(String name);

  /** Name-to-type mapping with const/volatile qualifications */
  public Type lookupType(String name, int cvAttributes);

  /** Iteration through all types */
  public void iterate(TypeVisitor t);

  /** Return debug info (closest lexically-enclosing block) for
      current program counter. Returns null if no debug information
      found or available. */
  public BlockSym debugInfoForPC(Address pc);

  /** Look up global or module-local symbol by name. FIXME: need some
      way to identify modules -- has not been thought through yet
      because it isn't clear exactly how these are represented in the
      Visual C++ debug info. */
  public GlobalSym lookupSym(String name);

  /** Returns line number information for the given PC, including
      source file name (not specified whether this is an absolute or
      relative path) and start and end PCs for this line. Returns null
      if no line number information is available. */
  public LineNumberInfo lineNumberForPC(Address pc) throws DebuggerException;

  /** Iteration through all line number information in this
      database. */
  public void iterate(LineNumberVisitor v);
}
