/*
 * Copyright (c) 2013, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

public class MethodCounters extends Metadata {
  public MethodCounters(Address addr) {
    super(addr);
  }

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type      = db.lookupType("MethodCounters");

    if (VM.getVM().isServerCompiler()) {
      interpreterThrowoutCountField = new CIntField(type.getCIntegerField("_interpreter_throwout_count"), 0);
    }
    if (!VM.getVM().isCore()) {
      invocationCounter        = new CIntField(type.getCIntegerField("_invocation_counter"), 0);
      backedgeCounter          = new CIntField(type.getCIntegerField("_backedge_counter"), 0);
    }
  }

  private static CIntField interpreterThrowoutCountField;
  private static CIntField invocationCounter;
  private static CIntField backedgeCounter;

  public int interpreterThrowoutCount() {
      if (interpreterThrowoutCountField != null) {
        return (int) interpreterThrowoutCountField.getValue(this);
      } else {
        return 0;
      }
  }
  public long getInvocationCounter() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(!VM.getVM().isCore(), "must not be used in core build");
    }
    return invocationCounter.getValue(this);
  }
  public long getBackedgeCounter() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(!VM.getVM().isCore(), "must not be used in core build");
    }
    return backedgeCounter.getValue(this);
  }

  public void printValueOn(PrintStream tty) {
  }
}

