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

package sun.jvm.hotspot.runtime;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;

public interface JavaThreadPDAccess {
  public    Address getLastJavaFP(Address addr);
  public    Address getLastJavaPC(Address addr);
  public    Address getBaseOfStackPointer(Address addr);
  public    Frame getLastFramePD(JavaThread thread, Address addr);
  public    RegisterMap newRegisterMap(JavaThread thread, boolean updateMap);
  public    Frame getCurrentFrameGuess(JavaThread thread, Address addr);
  public    void printThreadIDOn(Address addr, PrintStream tty);
  public    void printInfoOn(Address threadAddr, PrintStream tty);
  public    Address getLastSP(Address addr);
  public    ThreadProxy getThreadProxy(Address addr);
}
