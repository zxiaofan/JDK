/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;

public class StackValueCollection {
  private List<StackValue> list;

  public StackValueCollection()           { list = new ArrayList<>(); }
  public StackValueCollection(int length) { list = new ArrayList<>(length); }

  public void add(StackValue val) { list.add(val); }
  public int  size()              { return list.size(); }
  public boolean isEmpty()        { return (size() == 0); }
  public StackValue get(int i)    { return (StackValue) list.get(i); }

  // Get typed locals/expressions
  // FIXME: must figure out whether word swapping is necessary on x86
  public boolean   booleanAt(int slot)   { return (int)get(slot).getInteger() != 0; }
  public byte      byteAt(int slot)      { return (byte) get(slot).getInteger(); }
  public char      charAt(int slot)      { return (char) get(slot).getInteger(); }
  public short     shortAt(int slot)     { return (short) get(slot).getInteger(); }
  public int       intAt(int slot)       { return (int) get(slot).getInteger(); }
  public long      longAt(int slot)      { return VM.getVM().buildLongFromIntsPD((int) get(slot).getInteger(),
                                                                                 (int) get(slot+1).getInteger()); }

  public OopHandle oopHandleAt(int slot) {
    StackValue sv = get(slot);
    if (sv.getType() == BasicType.getTConflict()) {
      throw new WrongTypeException("Conflict type");
    }
    return sv.getObject();
  }

  public float     floatAt(int slot)     { return Float.intBitsToFloat(intAt(slot)); }
  public double    doubleAt(int slot)    { return Double.longBitsToDouble(longAt(slot)); }
}
