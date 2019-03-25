/*
 * Copyright (c) 2001, 2012, Oracle and/or its affiliates. All rights reserved.
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

/** Models a "C" programming language frame on the stack -- really
    just an arbitrary frame with hooks to access C and C++ debug
    information if available. It is recommended that implementors of
    this interface derive from BasicCFrame, which provides some of the
    functionality. */

public interface CFrame {
  /** Returns null when no more frames on stack */
  public CFrame sender(ThreadProxy th);

  /** Get the program counter of this frame */
  public Address pc();

  /** Get the loadobject in which the PC lies. Returns null if the PC
      is not contained in any of the loadobjects in the target
      process. */
  public LoadObject loadObjectForPC();

  /** If debug information is available, retrieves the block in which
      the program counter lies. Returns null if there is no debug
      information for the current program counter or if the PC could
      not be located for other reasons. */
  public BlockSym blockForPC();

  /** For the loadobject in which the PC lies, fetch the name of the
      closest exported symbol and the distance of the PC to that
      symbol. Returns null if the PC was not within any of the
      loadobjects of the target process. FIXME: specify whether this
      is mangled/demangled. */
  public ClosestSymbol closestSymbolToPC();

  /** Gets the base pointer in this frame from which local variable
      offsets in the debug info are based. Typically this is the
      base-of-frame pointer (EBP on x86, FP/I6 on SPARC). */
  public Address localVariableBase();

  /** Visit all local variables in this frame if debug information is
      available. Automatically descends into compound types and arrays. */
  public void iterateLocals(ObjectVisitor v);
}
