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

package sun.jvm.hotspot.debugger.linux;

import java.util.List;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;

/** An extension of the JVMDebugger interface with a few additions to
    support 32-bit vs. 64-bit debugging as well as features required
    by the architecture-specific subpackages. */

public interface LinuxDebugger extends JVMDebugger {
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
  public LinuxAddress readAddress(long address) throws DebuggerException;
  public LinuxAddress readCompOopAddress(long address) throws DebuggerException;
  public LinuxAddress readCompKlassAddress(long address) throws DebuggerException;
  public LinuxOopHandle readOopHandle(long address) throws DebuggerException;
  public LinuxOopHandle readCompOopHandle(long address) throws DebuggerException;
  public long[]       getThreadIntegerRegisterSet(int lwp_id) throws DebuggerException;
  public long         getAddressValue(Address addr) throws DebuggerException;
  public Address      findLibPtrByAddress(Address pc);

  // For LinuxCDebugger
  public List<ThreadProxy> getThreadList();
  public List<LoadObject> getLoadObjectList();
  public ClosestSymbol lookup(long address);
  public String demangle(String sym);

  // NOTE: this interface implicitly contains the following methods:
  // From the Debugger interface via JVMDebugger
  //   public void attach(int processID) throws DebuggerException;
  //   public void attach(String executableName, String coreFileName) throws DebuggerException;
  //   public boolean detach();
  //   public Address parseAddress(String addressString) throws NumberFormatException;
  //   public String getOS();
  //   public String getCPU();
  // From the SymbolLookup interface via Debugger and JVMDebugger
  //   public Address lookup(String objectName, String symbol);
  //   public OopHandle lookupOop(String objectName, String symbol);
  // From the JVMDebugger interface
  //   public void configureJavaPrimitiveTypeSizes(long jbooleanSize,
  //                                               long jbyteSize,
  //                                               long jcharSize,
  //                                               long jdoubleSize,
  //                                               long jfloatSize,
  //                                               long jintSize,
  //                                               long jlongSize,
  //                                               long jshortSize);
  // From the ThreadAccess interface via Debugger and JVMDebugger
  //   public ThreadProxy getThreadForIdentifierAddress(Address addr);
}
