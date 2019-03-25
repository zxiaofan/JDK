/*
 * Copyright (c) 2000, 2002, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.asm;

/** <P> Register is an abstraction over machine registers. </P>

    <P> FIXME: should align constants with underlying VM code </P> */

public abstract class Register extends ImmediateOrRegister {
  /** Corresponds to the machine register code. -1 stands for invalid
      register (initial value). */
  protected int number;

  public Register() {
    number = -1;
  }

  public Register(int number) {
    this.number = number;
  }

  /** Must be overridden by subclass to indicate number of available
      registers on this platform */
  public abstract int getNumberOfRegisters();

  public boolean isValid() {
    return ((0 <= number) && (number <= getNumberOfRegisters()));
  }

  public int getNumber() {
    return number;
  }

  public boolean equals(Object x) {
    if (x == null) {
      return false;
    }

    if (!getClass().equals(x.getClass())) {
      return false;
    }

    Register reg = (Register) x;

    return (reg.getNumber() == getNumber());
  }

  public int hashCode() {
    return number;
  }

  public boolean isRegister() {
    return true;
  }

  public abstract boolean isStackPointer();
  public abstract boolean isFramePointer();
  public abstract boolean isFloat();
}
