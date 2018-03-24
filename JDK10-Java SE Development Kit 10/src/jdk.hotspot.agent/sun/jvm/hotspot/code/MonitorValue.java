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

package sun.jvm.hotspot.code;

import java.io.*;

public class MonitorValue {
  private ScopeValue owner;
  private Location   basicLock;
  private boolean    eliminated;

  // FIXME: not useful yet
  //  MonitorValue(ScopeValue* owner, Location basic_lock);

  public MonitorValue(DebugInfoReadStream stream) {
    basicLock = new Location(stream);
    owner     = ScopeValue.readFrom(stream);
    eliminated= stream.readBoolean();
  }

  public ScopeValue owner()     { return owner; }
  public Location   basicLock() { return basicLock; }
  public boolean   eliminated() { return eliminated; }

  // FIXME: not yet implementable
  //  void write_on(DebugInfoWriteStream* stream);

  public void printOn(PrintStream tty) {
    tty.print("monitor{");
    owner().printOn(tty);
    tty.print(",");
    basicLock().printOn(tty);
    tty.print("}");
    if (eliminated) {
      tty.print(" (eliminated)");
    }
  }
}
