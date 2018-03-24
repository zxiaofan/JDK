/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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

public class HeapPrinter implements HeapVisitor {

  public HeapPrinter(PrintStream tty) {
    oopPrinter = new OopPrinter(tty);
  }

  private OopPrinter oopPrinter;

  public void prologue(long size) {}

  public boolean doObj(Oop obj) {
          obj.iterate(oopPrinter, true);
          return false;
  }

  public void epilogue() {}
}
