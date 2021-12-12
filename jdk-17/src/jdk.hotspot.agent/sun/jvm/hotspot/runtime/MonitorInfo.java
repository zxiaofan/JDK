/*
 * Copyright (c) 2001, 2009, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.utilities.*;

public class MonitorInfo {
  private OopHandle owner;
  private BasicLock lock;
  private OopHandle ownerKlass;
  private boolean eliminated;
  private boolean ownerIsScalarReplaced;

  public MonitorInfo(OopHandle owner, BasicLock lock, boolean eliminated, boolean ownerIsScalarReplaced) {
    if (!ownerIsScalarReplaced) {
      this.owner = owner;
      this.ownerKlass = null;
    } else {
      Assert.that(eliminated, "monitor should be eliminated for scalar replaced object");
      this.owner = null;
      this.ownerKlass = owner;
    }
    this.eliminated = eliminated;
    this.ownerIsScalarReplaced = ownerIsScalarReplaced;
  }

  public OopHandle owner() {
   Assert.that(!ownerIsScalarReplaced, "should not be called for scalar replaced object");
   return owner;
  }

  public OopHandle ownerKlass() {
   Assert.that(ownerIsScalarReplaced, "should not be called for not scalar replaced object");
   return ownerKlass;
  }

  public BasicLock lock()  { return lock; }
  public boolean eliminated() { return eliminated; }
  public boolean ownerIsScalarReplaced() { return ownerIsScalarReplaced; }
}
