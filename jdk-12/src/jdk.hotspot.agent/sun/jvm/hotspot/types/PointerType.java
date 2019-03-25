/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.types;

import java.util.*;

/** This interface describes C pointer types, specifically to be able
    to model pointer fields within types more accurately. */

public interface PointerType extends Type {
  /** Returns the target type of this PointerType. */
  public Type getTargetType();
}
