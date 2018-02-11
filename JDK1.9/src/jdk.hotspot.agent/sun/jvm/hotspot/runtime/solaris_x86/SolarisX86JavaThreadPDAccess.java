/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime.solaris_x86;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.x86.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.runtime.x86.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;

/** Placeholder for now to allow us to start the SA without support
    for stack traces */

public class SolarisX86JavaThreadPDAccess implements JavaThreadPDAccess {
  private static AddressField lastJavaFPField;
  private static AddressField osThreadField;
  private static AddressField baseOfStackPointerField;

  // Field from OSThread
  private static CIntegerField osThreadThreadIDField;

  // This is currently unneeded but is being kept in case we change
  // the currentFrameGuess algorithm
  private static final long GUESS_SCAN_RANGE = 128 * 1024;


  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("JavaThread");
    Type anchorType = db.lookupType("JavaFrameAnchor");

    lastJavaFPField    = anchorType.getAddressField("_last_Java_fp");
    osThreadField      = type.getAddressField("_osthread");

    type = db.lookupType("OSThread");
    osThreadThreadIDField   = type.getCIntegerField("_thread_id");
  }

  public    Address getLastJavaFP(Address addr) {
    return lastJavaFPField.getValue(addr.addOffsetTo(sun.jvm.hotspot.runtime.JavaThread.getAnchorField().getOffset()));
  }

  public    Address getLastJavaPC(Address addr) {
    return null;
  }

  public Address getBaseOfStackPointer(Address addr) {
    return null;
  }

  public Frame getLastFramePD(JavaThread thread, Address addr) {
    Address fp = thread.getLastJavaFP();
    if (fp == null) {
      return null; // no information
    }
    Address pc =  thread.getLastJavaPC();
    if ( pc != null ) {
      return new X86Frame(thread.getLastJavaSP(), fp, pc);
    } else {
      return new X86Frame(thread.getLastJavaSP(), fp);
    }
  }

  public RegisterMap newRegisterMap(JavaThread thread, boolean updateMap) {
    return new X86RegisterMap(thread, updateMap);
  }

  public Frame getCurrentFrameGuess(JavaThread thread, Address addr) {
    ThreadProxy t = getThreadProxy(addr);
    X86ThreadContext context = (X86ThreadContext) t.getContext();
    X86CurrentFrameGuess guesser = new X86CurrentFrameGuess(context, thread);
    if (!guesser.run(GUESS_SCAN_RANGE)) {
      return null;
    }
    if (guesser.getPC() == null) {
      return new X86Frame(guesser.getSP(), guesser.getFP());
    } else {
      return new X86Frame(guesser.getSP(), guesser.getFP(), guesser.getPC());
    }
  }


  public void printThreadIDOn(Address addr, PrintStream tty) {
    tty.print(getThreadProxy(addr));
  }


  public void printInfoOn(Address threadAddr, PrintStream tty) {
  }

  public Address getLastSP(Address addr) {
    ThreadProxy t = getThreadProxy(addr);
    X86ThreadContext context = (X86ThreadContext) t.getContext();
    return context.getRegisterAsAddress(X86ThreadContext.ESP);
  }

  public ThreadProxy getThreadProxy(Address addr) {
    // Fetch the OSThread (for now and for simplicity, not making a
    // separate "OSThread" class in this package)
    Address osThreadAddr = osThreadField.getValue(addr);
    // Get the address of the thread ID from the OSThread
    Address tidAddr = osThreadAddr.addOffsetTo(osThreadThreadIDField.getOffset());

    JVMDebugger debugger = VM.getVM().getDebugger();
    return debugger.getThreadForIdentifierAddress(tidAddr);
  }

}
