/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.dummy;

import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.CDebugger;
import sun.jvm.hotspot.utilities.*;

/** For testing purposes */

public class DummyDebugger extends DebuggerBase {
  private MachineDescription machDesc;

  public DummyDebugger(MachineDescription machDesc) {
    this.machDesc = machDesc;
  }

  public boolean hasProcessList() throws DebuggerException {
    return false;
  }

  public List<ProcessInfo> getProcessList() throws DebuggerException {
    return null;
  }

  public void attach(int processID) throws DebuggerException {
  }

  public void attach(String executableName, String coreFileName)
    throws DebuggerException {
  }

  public boolean detach() {
    return true;
  }

  public Address parseAddress(String addrStr) {
    String s = addrStr.trim();
    if (!s.startsWith("0x")) {
      throw new NumberFormatException(addrStr);
    }
    long l = 0;
    for (int i = 2; i < s.length(); ++i) {
      int val = charToNibble(s.charAt(i));
      l <<= 4;
      l |= val;
    }
    return new DummyAddress(this, l);
  }

  public long getAddressValue(Address addr) {
    if (addr == null) return 0;
    return ((DummyAddress) addr).getValue();
  }

  public String getOS() {
    return PlatformInfo.getOS();
  }

  public String getCPU() {
    return PlatformInfo.getCPU();
  }

  public MachineDescription getMachineDescription() throws DebuggerException {
    return machDesc;
  }

  public boolean hasConsole() {
    return false;
  }

  public String consoleExecuteCommand(String cmd)
    throws DebuggerException {
    throw new DebuggerException("unimplemented");
  }

  public String getConsolePrompt() throws DebuggerException {
    throw new DebuggerException("unimplemented");
  }

  public CDebugger getCDebugger() throws DebuggerException {
    return null;
  }

  public Address lookup(String objectName, String symbol) {
    return null;
  }

  public OopHandle lookupOop(String objectName, String symbol) {
    return null;
  }

  public ThreadProxy getThreadForIdentifierAddress(Address addr) {
    return null;
  }

  public ThreadProxy getThreadForThreadId(long id) {
    return null;
  }

  public ReadResult readBytesFromProcess(long address, long numBytes)
                               throws DebuggerException {
    throw new DebuggerException("Unimplemented");
  }

  public void writeBytesToProcess(long a, long b, byte[] buf)
                               throws DebuggerException {
    throw new DebuggerException("Unimplemented");
  }

  //----------------------------------------------------------------------
  // Package-internal routines
  //

  String addressToString(DummyAddress addr) {
    StringBuilder buf = new StringBuilder();
    buf.append("0x");
    String val;
    if (addr == null) {
      val = "0";
    } else {
      val = Long.toHexString(addr.getValue());
    }
    for (int i = 0; i < ((2 * machDesc.getAddressSize()) - val.length()); i++) {
      buf.append('0');
    }
    buf.append(val);
    return buf.toString();
  }

  //----------------------------------------------------------------------
  // Internals only below this point
  //

  private int charToNibble(char ascii) throws NumberFormatException {
    if (ascii >= '0' && ascii <= '9') {
      return ascii - '0';
    } else if (ascii >= 'A' && ascii <= 'F') {
      return 10 + ascii - 'A';
    } else if (ascii >= 'a' && ascii <= 'f') {
      return 10 + ascii - 'a';
    }
    throw new NumberFormatException(Character.toString(ascii));
  }
}
