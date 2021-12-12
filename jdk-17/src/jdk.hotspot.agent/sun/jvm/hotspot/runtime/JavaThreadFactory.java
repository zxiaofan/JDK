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

package sun.jvm.hotspot.runtime;

/** This is only used internally to this package and its operating
    system- and CPU-specific subpackages to be able to instantiate the
    correct platform-specific implementation of JavaThread which
    handles the last Java frame pointer and other constructs
    properly. */

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;

public interface JavaThreadFactory {
  public JavaThread createJavaThreadWrapper(Address realThreadObjAddr, TypeDataBase db);
}
