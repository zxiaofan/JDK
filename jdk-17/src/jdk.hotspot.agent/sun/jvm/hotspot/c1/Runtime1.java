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

package sun.jvm.hotspot.c1;

import java.util.*;
import sun.jvm.hotspot.code.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.Observable;
import sun.jvm.hotspot.utilities.Observer;

/** Currently a minimal port to get C1 frame traversal working */

public class Runtime1 {
  private static Field         blobsField;

  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) {
    Type type = db.lookupType("Runtime1");

    blobsField = type.getField("_blobs");
  }

  public Runtime1() {
  }

  /** FIXME: consider making argument "type-safe" in Java port */
  public Address entryFor(int id) {
    return blobFor(id).codeBegin();
  }

  /** FIXME: consider making argument "type-safe" in Java port */
  public CodeBlob blobFor(int id) {
    Address blobAddr = blobsField.getStaticFieldAddress().getAddressAt(id * VM.getVM().getAddressSize());
    return VM.getVM().getCodeCache().createCodeBlobWrapper(blobAddr);
  }
}
