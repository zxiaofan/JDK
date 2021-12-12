/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2020, Microsoft Corporation. All rights reserved.
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

package sun.jvm.hotspot.runtime.win32_aarch64;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.aarch64.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.runtime.aarch64.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

/** This class is only public to allow using the VMObjectFactory to
    instantiate these.
*/

public class Win32AARCH64JavaThreadPDAccess implements JavaThreadPDAccess {
  private static AddressField  lastJavaFPField;
  private static AddressField  osThreadField;

  // Field from OSThread
  private static Field         osThreadThreadIDField;

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
    osThreadField           = type.getAddressField("_osthread");

    Type anchorType = db.lookupType("JavaFrameAnchor");
    lastJavaFPField         = anchorType.getAddressField("_last_Java_fp");

    Type osThreadType = db.lookupType("OSThread");
    osThreadThreadIDField = osThreadType.getField("_thread_id");
  }

  public Address getLastJavaFP(Address addr) {
    return lastJavaFPField.getValue(addr.addOffsetTo(sun.jvm.hotspot.runtime.JavaThread.getAnchorField().getOffset()));
  }

  public Address getLastJavaPC(Address addr) {
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
      return new AARCH64Frame(thread.getLastJavaSP(), fp, pc);
    } else {
      return new AARCH64Frame(thread.getLastJavaSP(), fp);
    }
  }

  public RegisterMap newRegisterMap(JavaThread thread, boolean updateMap) {
    return new AARCH64RegisterMap(thread, updateMap);
  }

  public Frame getCurrentFrameGuess(JavaThread thread, Address addr) {
    ThreadProxy t = getThreadProxy(addr);
    AARCH64ThreadContext context = (AARCH64ThreadContext) t.getContext();
    AARCH64CurrentFrameGuess guesser = new AARCH64CurrentFrameGuess(context, thread);
    if (!guesser.run(GUESS_SCAN_RANGE)) {
      return null;
    }
    if (guesser.getPC() == null) {
      return new AARCH64Frame(guesser.getSP(), guesser.getFP());
    } else {
      return new AARCH64Frame(guesser.getSP(), guesser.getFP(), guesser.getPC());
    }
  }

  public void printThreadIDOn(Address addr, PrintStream tty) {
    tty.print(getThreadProxy(addr));
  }

  public void printInfoOn(Address threadAddr, PrintStream tty) {
  }

  public Address getLastSP(Address addr) {
    ThreadProxy t = getThreadProxy(addr);
    AARCH64ThreadContext context = (AARCH64ThreadContext) t.getContext();
    return context.getRegisterAsAddress(AARCH64ThreadContext.SP);
  }

  public ThreadProxy getThreadProxy(Address addr) {
    // Addr is the address of the JavaThread.
    // Fetch the OSThread (for now and for simplicity, not making a
    // separate "OSThread" class in this package)
    Address osThreadAddr = osThreadField.getValue(addr);
    // Get the address of the thread_id within the OSThread
    Address threadIdAddr = osThreadAddr.addOffsetTo(osThreadThreadIDField.getOffset());

    JVMDebugger debugger = VM.getVM().getDebugger();
    return debugger.getThreadForIdentifierAddress(threadIdAddr);
  }
}
