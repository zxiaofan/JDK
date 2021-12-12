/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger.cdbg.basic;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.cdbg.*;

/** Describes line number information for a given range of program
    counters. */

public class BasicLineNumberInfo implements LineNumberInfo {
  private String sourceFileName;
  private int lineNo;
  private Address startPC;
  private Address endPC;

  public BasicLineNumberInfo(String sourceFileName,
                             int lineNo,
                             Address startPC,
                             Address endPC) {
    this.sourceFileName = sourceFileName;
    this.lineNo = lineNo;
    this.startPC = startPC;
    this.endPC = endPC;
  }

  /** Not specified whether this is an absolute or relative path. */
  public String  getSourceFileName() { return sourceFileName; }
  public int     getLineNumber()     { return lineNo; }
  public Address getStartPC()        { return startPC; }
  /** FIXME: specify whether this is inclusive or exclusive (currently
      when BasicLineNumberMapping.recomputeEndPCs() is called, this is
      exclusive) */
  public Address getEndPC()          { return endPC; }

  /** For recomputing end PCs if they are not available in the debug info */
  public void    setEndPC(Address pc) { endPC = pc; }
}
