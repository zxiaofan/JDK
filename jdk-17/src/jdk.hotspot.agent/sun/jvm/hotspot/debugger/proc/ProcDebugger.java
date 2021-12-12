/*
 * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.proc;

import java.util.List;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;

/** An extension of the JVMDebugger interface with a few additions to
    support 32-bit vs. 64-bit debugging as well as features required
    by the architecture-specific subpackages. */

public interface ProcDebugger extends JVMDebugger {
  public MachineDescription getMachineDescription() throws DebuggerException;
  public String       addressValueToString(long address) throws DebuggerException;
  public boolean      readJBoolean(long address) throws DebuggerException;
  public byte         readJByte(long address) throws DebuggerException;
  public char         readJChar(long address) throws DebuggerException;
  public double       readJDouble(long address) throws DebuggerException;
  public float        readJFloat(long address) throws DebuggerException;
  public int          readJInt(long address) throws DebuggerException;
  public long         readJLong(long address) throws DebuggerException;
  public short        readJShort(long address) throws DebuggerException;
  public long         readCInteger(long address, long numBytes, boolean isUnsigned)
    throws DebuggerException;
  public ProcAddress   readAddress(long address) throws DebuggerException;
  public ProcAddress   readCompOopAddress(long address) throws DebuggerException;
  public ProcAddress   readCompKlassAddress(long address) throws DebuggerException;
  public ProcOopHandle readOopHandle(long address) throws DebuggerException;
  public ProcOopHandle readCompOopHandle(long address) throws DebuggerException;
  public long[]       getThreadIntegerRegisterSet(int tid) throws DebuggerException;
  public long         getAddressValue(Address addr) throws DebuggerException;

  // for ProcCDebugger, ProcCFrame and SharedObject
  public List<ThreadProxy> getThreadList() throws DebuggerException;
  public List<LoadObject> getLoadObjectList() throws DebuggerException;
  public CFrame        topFrameForThread(ThreadProxy thread) throws DebuggerException;
  public ClosestSymbol lookup(long address) throws DebuggerException;
  public String        demangle(String name);
}
