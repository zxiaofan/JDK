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

package sun.jvm.hotspot.runtime;

import sun.jvm.hotspot.oops.*;

public abstract class SignatureInfo extends SignatureIterator {
  protected boolean hasIterated; // need this because iterate cannot be called in constructor (set is virtual!)
  protected int     size;
  protected int     type;        // BasicType

  protected void lazyIterate() {
    if (!hasIterated) {
      iterate();
      hasIterated = true;
    }
  }

  protected abstract void set(int size, int /*BasicType*/ type);

  public void doBool()                     { set(BasicTypeSize.getTBooleanSize(), BasicType.getTBoolean()); }
  public void doChar()                     { set(BasicTypeSize.getTCharSize(),    BasicType.getTChar());    }
  public void doFloat()                    { set(BasicTypeSize.getTFloatSize(),   BasicType.getTFloat());   }
  public void doDouble()                   { set(BasicTypeSize.getTDoubleSize(),  BasicType.getTDouble());  }
  public void doByte()                     { set(BasicTypeSize.getTByteSize(),    BasicType.getTByte());    }
  public void doShort()                    { set(BasicTypeSize.getTShortSize(),   BasicType.getTShort());   }
  public void doInt()                      { set(BasicTypeSize.getTIntSize(),     BasicType.getTInt());     }
  public void doLong()                     { set(BasicTypeSize.getTLongSize(),    BasicType.getTLong());    }
  public void doVoid()                     { set(BasicTypeSize.getTVoidSize(),    BasicType.getTVoid());    }
  public void doObject(int begin, int end) { set(BasicTypeSize.getTObjectSize(),  BasicType.getTObject());  }
  public void doArray(int begin, int end)  { set(BasicTypeSize.getTArraySize(),   BasicType.getTArray());   }

  public SignatureInfo(Symbol signature) {
    super(signature);

    type = BasicType.getTIllegal();
  }

  public int size() { lazyIterate(); return size; }
  public int type() { lazyIterate(); return type; }
}
