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

import sun.jvm.hotspot.debugger.cdbg.*;

public class BasicIndexableFieldIdentifier implements IndexableFieldIdentifier {
  private Type type;
  private int  index;

  public BasicIndexableFieldIdentifier(Type type, int index) {
    this.type = type;
    this.index = index;
  }

  public Type    getType()  { return type; }
  public int     getIndex() { return index; }
  public String  toString() { return Integer.toString(getIndex()); }
}
