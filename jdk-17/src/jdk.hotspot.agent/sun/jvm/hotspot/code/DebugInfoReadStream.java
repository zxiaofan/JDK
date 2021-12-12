/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.VM;
import sun.jvm.hotspot.utilities.*;
import sun.jvm.hotspot.oops.Method;

public class DebugInfoReadStream extends CompressedReadStream {
  private NMethod code;
  private int InvocationEntryBCI;
  private List<ObjectValue> objectPool;

  public DebugInfoReadStream(NMethod code, int offset) {
    super(code.scopesDataBegin(), offset);
    InvocationEntryBCI = VM.getVM().getInvocationEntryBCI();
    this.code = code;
    this.objectPool = null;
  }

  public DebugInfoReadStream(NMethod code, int offset, List<ObjectValue> objectPool) {
    super(code.scopesDataBegin(), offset);
    InvocationEntryBCI = VM.getVM().getInvocationEntryBCI();
    this.code = code;
    this.objectPool = objectPool;
  }

  public OopHandle readOopHandle() {
    return code.getOopAt(readInt());
  }

  public Method readMethod() {
    return code.getMethodAt(readInt());
  }

  ScopeValue readObjectValue() {
    int id = readInt();
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(objectPool != null, "object pool does not exist");
      for (Iterator itr = objectPool.iterator(); itr.hasNext();) {
        ObjectValue ov = (ObjectValue) itr.next();
        Assert.that(ov.id() != id, "should not be read twice");
      }
    }
    ObjectValue result = new ObjectValue(id);
    // Cache the object since an object field could reference it.
    objectPool.add(result);
    result.readObject(this);
    return result;
  }

  ScopeValue getCachedObject() {
    int id = readInt();
    Assert.that(objectPool != null, "object pool does not exist");
    for (Iterator itr = objectPool.iterator(); itr.hasNext();) {
      ObjectValue ov = (ObjectValue) itr.next();
      if (ov.id() == id) {
        return ov;
      }
    }
    Assert.that(false, "should not reach here");
    return null;
  }

  public int readBCI() {
    return readInt() + InvocationEntryBCI;
  }
}
