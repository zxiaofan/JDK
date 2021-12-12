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

package sun.jvm.hotspot.types.basic;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.types.*;

/** This interface is designed to allow a platform-specific
    implementation of the TypeDataBase.isOfType() method, while
    leaving the rest of the basic.* package platform independent. */

public interface VtblAccess {
  /** This is the necessarily platform-specific implementation.
      Attempt to return the address of the vtbl for the given
      polymorphic C++ type. This value will be used when searching
      nearby memory to implement isOfType() in as platform-independent
      a manner as possible. Returns null if this value was not
      available for the given type, which might indicate that the type
      was not polymorphic or that an error occurred while trying to
      find the symbol. Note that this method does not support multiple
      inheritance. */
  public Address getVtblForType(Type type);

  /** Clear any cached values from symbol lookups in the target
      process. It is important that this mechanism be fast and for
      that reason the default implementation memoizes type-to-vtbl
      mappings. However, if the target process is resumed, these
      mappings may become invalid. */
  public void clearCaches();
}
