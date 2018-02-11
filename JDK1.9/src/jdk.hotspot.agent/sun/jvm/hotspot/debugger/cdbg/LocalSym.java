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

/** Models a local variable in a scope. The meaning of the frame
    offset is platform-dependent, and is typically added to the base
    of frame pointer. */

public interface LocalSym extends Sym {
  /** Name of the local variable */
  public String getName();

  /** Type of the local variable */
  public Type getType();

  /** Offset, in bytes, in the frame of the local variable */
  public long getFrameOffset();
}
