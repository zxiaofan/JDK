/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.asm.*;
import sun.jvm.hotspot.utilities.*;

/** SPARCArgument is an abstraction used to represent an outgoing
    actual argument or an incoming formal parameter, whether it
    resides in memory or in a register, in a manner consistent with
    the SPARC Application Binary Interface, or ABI.  This is often
    referred to as the native or C calling convention. */

public class SPARCArgument {
  private int     number;
  private boolean isIn;

  // FIXME: add 64-bit stuff here (support for FP registers)

  /** Only 6 registers may contain integer parameters */
  public static final int NUM_REGISTER_PARAMETERS = 6;

  public SPARCArgument(int number, boolean isIn) {
    this.number = number;
    this.isIn   = isIn;
  }

  int     getNumber() { return number;     }
  boolean getIsIn()   { return isIn;       }
  boolean getIsOut()  { return !getIsIn(); }

  public SPARCArgument getSuccessor() { return new SPARCArgument(getNumber() + 1, getIsIn()); }
  public SPARCArgument asIn()         { return new SPARCArgument(getNumber(),     true);      }
  public SPARCArgument asOut()        { return new SPARCArgument(getNumber(),     false);     }

  /** Locating register-based arguments */
  public boolean isRegister()         { return number < NUM_REGISTER_PARAMETERS; }

  public SPARCRegister asRegister() {
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(isRegister(), "must be a register argument");
    }
    return new SPARCRegister(getIsIn() ? SPARCRegisterType.IN : SPARCRegisterType.OUT, getNumber());
  }

  // locating memory-based arguments (FIXME: elided for now, will
  // necessitate creating new SPARCAddress class)
  //  public SPARCAddress asAddress() {
  //    if (Assert.ASSERTS_ENABLED) {
  //      Assert.that(!isRegister(), "must be a memory argument");
  //    }
  //    return addressInFrame();
  //  }
  //
  //  /** When applied to a register-based argument, give the corresponding address
  //      into the 6-word area "into which callee may store register arguments"
  //      (This is a different place than the corresponding register-save area location.)  */
  //  public SPARCAddress addressInFrame() const {
  //    return SPARCAddress( is_in()   ? Address::extra_in_argument
  //                          : Address::extra_out_argument,
  //                _number );
  //  }
}
