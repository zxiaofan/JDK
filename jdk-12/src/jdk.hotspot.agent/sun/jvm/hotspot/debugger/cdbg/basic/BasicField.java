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

public class BasicField implements Field {
  private String  name;
  private Type    type;
  private int     accessControl;
  private boolean isStatic;
  private long    offset;
  private Address address;

  /** See {@link sun.jvm.hotspot.debugger.cdbg.AccessControl} for
      valid access control values */
  public BasicField(String name, Type type, int accessControl, boolean isStatic) {
    this.name = name;
    this.type = type;
    this.accessControl = accessControl;
  }

  public int getAccessControl() { return accessControl; }

  public String getName() { return name; }

  public Type getType() { return type; }

  public boolean isStatic() { return isStatic; }

  /** Nonstatic fields only: set offset of field */
  public void setOffset(long offset) {
    if (isStatic) throw new RuntimeException("Nonstatic fields only");
    this.offset = offset;
  }

  /** Nonstatic fields only: get offset of field */
  public long getOffset() {
    if (isStatic) throw new RuntimeException("Nonstatic fields only");
    return offset;
  }

  /** Static fields only: set address of field. The resolution
      mechanism will automatically attempt to find the address of the
      field based on a "class name"::"field name" global symbol lookup
      in the database if the address has not been set. */
  public void setAddress(Address address) {
    if (!isStatic) throw new RuntimeException("Static fields only");
    this.address = address;
  }

  /** Static fields only: get address of field */
  public Address getAddress() {
    if (!isStatic) throw new RuntimeException("Static fields only");
    return address;
  }

  public void resolveTypes(Type containingType, BasicCDebugInfoDataBase db, ResolveListener listener) {
    type = db.resolveType(containingType, type, listener, "resolving field type");
    if (isStatic) {
      if (address == null) {
        String fieldSymName = getType().getName() + "::" + getName();
        GlobalSym sym = db.lookupSym(fieldSymName);
        if (sym == null) {
          listener.resolveFailed(getType(), getName());
        } else {
          address = sym.getAddress();
        }
      }
    }
  }
}
