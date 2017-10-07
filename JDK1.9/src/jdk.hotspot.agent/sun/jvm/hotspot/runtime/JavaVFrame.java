/*
 * Copyright (c) 2000, 2007, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.utilities.*;

public abstract class JavaVFrame extends VFrame {
  /** JVM state */
  public abstract Method getMethod();
  public abstract int    getBCI();
  public abstract StackValueCollection getLocals();
  public abstract StackValueCollection getExpressions();
  public abstract List   getMonitors();    // List<MonitorInfo>

  /** Test operation */
  public boolean isJavaFrame() { return true; }

  /** Package-internal constructor */
  JavaVFrame(Frame fr, RegisterMap regMap, JavaThread thread) {
    super(fr, regMap, thread);
  }

  /** Get monitor (if any) that this JavaVFrame is trying to enter */
  // FIXME: not yet implemented
  //  public Address getPendingMonitor(int frameCount);

  /** Printing used during stack dumps */
  // FIXME: not yet implemented
  //  void print_lock_info(int frame_count);

  /** Printing operations */

  //
  // FIXME: implement visitor pattern for traversing vframe contents?
  //

  public void print() {
    printOn(System.out);
  }

  public void printOn(PrintStream tty) {
    super.printOn(tty);

    tty.print("\t");
    getMethod().printValueOn(tty);
    tty.println();
    tty.println("\tbci:\t" + getBCI());

    printStackValuesOn(tty, "locals",      getLocals());
    printStackValuesOn(tty, "expressions", getExpressions());

    // List<MonitorInfo>
    // FIXME: not yet implemented
    //    List list = getMonitors();
    //    if (list.isEmpty()) {
    //      return;
    //    }
    //    for (int index = 0; index < list.size(); index++) {
    //      MonitorInfo monitor = (MonitorInfo) list.get(index);
    //      tty.print("\t  obj\t");
    //      monitor.getOwner().printValueOn(tty);
    //      tty.println();
    //      tty.print("\t  ");
    //      monitor.lock().printOn(tty);
    //      tty.println();
    //    }
  }

  public void printActivation(int index) {
    printActivationOn(System.out, index);
  }

  public void printActivationOn(PrintStream tty, int index) {
    // frame number and method
    tty.print(index + " - ");
    printValueOn(tty);
    tty.println();

    if (VM.getVM().wizardMode()) {
      printOn(tty);
      tty.println();
    }
  }

  /** Verification operations */
  public void verify() {
  }

  public boolean equals(Object o) {
      if (o == null || !(o instanceof JavaVFrame)) {
          return false;
      }

      JavaVFrame other = (JavaVFrame) o;

      // Check static part
      if (!getMethod().equals(other.getMethod())) {
          return false;
      }

      if (getBCI() != other.getBCI()) {
          return false;
      }

      // dynamic part - we just compare the frame pointer
      if (! getFrame().equals(other.getFrame())) {
          return false;
      }
      return true;
  }

  public int hashCode() {
      return getMethod().hashCode() ^ getBCI() ^ getFrame().hashCode();
  }

  /** Structural compare */
  public boolean structuralCompare(JavaVFrame other) {
    // Check static part
    if (!getMethod().equals(other.getMethod())) {
      return false;
    }

    if (getBCI() != other.getBCI()) {
      return false;
    }

    // Check locals
    StackValueCollection locs      = getLocals();
    StackValueCollection otherLocs = other.getLocals();
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(locs.size() == otherLocs.size(), "sanity check");
    }
    for (int i = 0; i < locs.size(); i++) {
      // it might happen the compiler reports a conflict and
      // the interpreter reports a bogus int.
      if (      isCompiledFrame() && (locs.get(i)).getType()      == BasicType.getTConflict()) continue;
      if (other.isCompiledFrame() && (otherLocs.get(i)).getType() == BasicType.getTConflict()) continue;

      if (!locs.get(i).equals(otherLocs.get(i))) {
        return false;
      }
    }

    // Check expressions
    StackValueCollection exprs      = getExpressions();
    StackValueCollection otherExprs = other.getExpressions();
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(exprs.size() == otherExprs.size(), "sanity check");
    }
    for (int i = 0; i < exprs.size(); i++) {
      if (!exprs.get(i).equals(otherExprs.get(i))) {
        return false;
      }
    }

    return true;
  }

  //--------------------------------------------------------------------------------
  // Internals only below this point
  //

  private void printStackValuesOn(PrintStream tty, String title, StackValueCollection values) {
    if (values.isEmpty()) {
      return;
    }
    tty.println("\t" + title + ":");
    for (int index = 0; index < values.size(); index++) {
      tty.print("\t" + index + "\t");
      values.get(index).printOn(tty);
      tty.println();
    }
  }
}
