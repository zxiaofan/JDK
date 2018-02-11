/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.asm.sparc;

/** A class providing the enums describing SPARC register types */

public class SPARCRegisterType {
  private SPARCRegisterType() {
  }

  public static final SPARCRegisterType GLOBAL = new SPARCRegisterType();
  public static final SPARCRegisterType OUT    = new SPARCRegisterType();
  public static final SPARCRegisterType IN     = new SPARCRegisterType();
  public static final SPARCRegisterType LOCAL  = new SPARCRegisterType();
}
