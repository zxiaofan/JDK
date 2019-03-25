/*
 * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger;

import sun.jvm.hotspot.debugger.cdbg.*;

/** This is a placeholder interface for a thread's context, containing
    only integer registers (no floating-point ones). What it contains
    is platform-dependent. Not all registers are guaranteed to be
    present in the context or read from the target process in all
    situations. However, the routines in it are exposed to allow
    platform-independent iteration. */

public interface ThreadContext {
  /** Number of integer registers in the context */
  public int getNumRegisters();

  /** Get the name of the specified register (0..getNumRegisters() -
      1) */
  public String getRegisterName(int i);

  /** Get the value of the specified register (0..getNumRegisters() -
      1) */
  public long getRegister(int index);

  /** Set the value of the specified register (0..getNumRegisters() -
      1) */
  public void setRegister(int index, long value);

  /** Get the value of the specified register (0..getNumRegisters() -
      1) as an Address */
  public Address getRegisterAsAddress(int index);

  /** Set the value of the specified register (0..getNumRegisters() -
      1) as an Address */
  public void setRegisterAsAddress(int index, Address value);

  public CFrame getTopFrame(Debugger dbg);
}
