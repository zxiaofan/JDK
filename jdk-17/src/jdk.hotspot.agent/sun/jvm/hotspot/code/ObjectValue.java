/*
 * Copyright (c) 2009, 2020, Oracle and/or its affiliates. All rights reserved.
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
import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.utilities.*;

/** An ObjectValue describes an object eliminated by escape analysis. */

public class ObjectValue extends ScopeValue {
  private int              id;
  private ScopeValue       klass;
  private List<ScopeValue> fieldsValue;

  // Field "boolean visited" is not implemented here since
  // it is used only a during debug info creation.

  public ObjectValue(int id) {
    this.id = id;
    klass   = null;
    fieldsValue = new ArrayList<>();
  }

  public boolean isObject() { return true; }
  public int id() { return id; }
  public ScopeValue getKlass() { return klass; }
  public List<ScopeValue> getFieldsValue() { return fieldsValue; }
  public ScopeValue getFieldAt(int i) { return (ScopeValue)fieldsValue.get(i); }
  public int fieldsSize() { return fieldsValue.size(); }

  // Field "value" is always NULL here since it is used
  // only during deoptimization of a compiled frame
  // pointing to reallocated object.
  public OopHandle getValue() { return null; }

  /** Serialization of debugging information */

  void readObject(DebugInfoReadStream stream) {
    klass = readFrom(stream);
    Assert.that(klass.isConstantOop(), "should be constant klass oop");
    int length = stream.readInt();
    for (int i = 0; i < length; i++) {
      ScopeValue val = readFrom(stream);
      fieldsValue.add(val);
    }
  }

  // Printing

  public void print() {
    printOn(System.out);
  }

  public void printOn(PrintStream tty) {
    tty.print("scalarObj[" + id + "]");
  }

  void printFieldsOn(PrintStream tty) {
    if (fieldsValue.size() > 0) {
      ((ScopeValue)fieldsValue.get(0)).printOn(tty);
    }
    for (int i = 1; i < fieldsValue.size(); i++) {
      tty.print(", ");
      ((ScopeValue)fieldsValue.get(i)).printOn(tty);
    }
  }

};
