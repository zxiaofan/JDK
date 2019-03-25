/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.code;

import java.io.*;
import sun.jvm.hotspot.code.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.utilities.*;

/** A port of the VM's Stub mechanism. Note that the separation of
    Stub and StubInterface (done in the VM to save space) is not
    currently necessary in these APIs and has been flattened so that
    class Stub has virtual functions overridden by concrete
    subclasses. */

public class Stub extends VMObject {

  public Stub(Address addr) {
    super(addr);
  }

  // NOTE (FIXME): initialize(int) / finalize() elided for now

  //
  // General info/converters
  //

  /** Must return the size provided by initialize */
  public long getSize()            { Assert.that(false, "should not call this"); return 0; }
  // NOTE (FIXME): code_size_to_size elided for now (would be a good reason for inserting the StubInterface abstraction)
  /** Needed to add this for iteration */
  public Address getAddress()      { return addr; }

  //
  // Code info
  //

  /** Points to the first byte of the code */
  public Address codeBegin()       { Assert.that(false, "should not call this"); return null; }
  /** Points to the first byte after the code */
  public Address codeEnd()         { Assert.that(false, "should not call this"); return null; }

  //
  // Debugging
  //

  /** Verifies the Stub */
  public void verify()             { Assert.that(false, "should not call this"); }
  /** Prints some information about the stub */
  public void printOn(PrintStream tty) { Assert.that(false, "should not call this"); }
}
