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

public class BasicNamedFieldIdentifier implements NamedFieldIdentifier {
  private Field field;

  public BasicNamedFieldIdentifier(Field field) {
    this.field = field;
  }

  public String getName()  { return field.getName(); }
  public Type getType()    { return field.getType(); }
  public String toString() { return getName(); }
}
