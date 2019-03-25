/*
 * Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvm.hotspot.runtime.BasicType;
import sun.jvm.hotspot.utilities.*;

public class FieldType {

  private Symbol signature;
  private char   first;

  public FieldType(Symbol signature) {
    this.signature = signature;
    this.first     = (char) signature.getByteAt(0);
    if (Assert.ASSERTS_ENABLED) {
       switch (this.first) {
       case 'B':
       case 'C':
       case 'D':
       case 'F':
       case 'I':
       case 'J':
       case 'S':
       case 'Z':
       case 'L':
       case '[':
           break;   // Ok. signature char known
       default:
         Assert.that(false, "Unknown char in field signature \"" + signature.asString() + "\": " + this.first);
       }
    }
  }

  public boolean isOop()     { return isObject() || isArray(); }
  public boolean isByte()    { return first == 'B'; }
  public boolean isChar()    { return first == 'C'; }
  public boolean isDouble()  { return first == 'D'; }
  public boolean isFloat()   { return first == 'F'; }
  public boolean isInt()     { return first == 'I'; }
  public boolean isLong()    { return first == 'J'; }
  public boolean isShort()   { return first == 'S'; }
  public boolean isBoolean() { return first == 'Z'; }
  public boolean isObject()  { return first == 'L'; }
  public boolean isArray()   { return first == '['; }

  public Symbol getSignature() { return signature; }

  public static class ArrayInfo {
    private int dimension;
    private int elementBasicType; // See BasicType.java
    // FIXME: consider adding name of element class

    public ArrayInfo(int dimension, int elementBasicType) {
      this.dimension = dimension;
      this.elementBasicType = elementBasicType;
    }

    public int dimension()        { return dimension; }
    /** See BasicType.java */
    public int elementBasicType() { return elementBasicType; }
  }

  /** Only valid for T_ARRAY; throws unspecified exception otherwise */
  public ArrayInfo getArrayInfo() {
    int index = 1;
    int dim   = 1;
    index = skipOptionalSize(signature, index);
    while (signature.getByteAt(index) == '[') {
      index++;
      dim++;
      skipOptionalSize(signature, index);
    }
    int elementType = BasicType.charToType((char) signature.getByteAt(index));
    return new ArrayInfo(dim, elementType);
  }

  private int skipOptionalSize(Symbol sig, int index) {
    byte c = sig.getByteAt(index);
    while (c >= '0' && c <= '9') {
      ++index;
      c = sig.getByteAt(index);
    }
    return index;
  }
}
