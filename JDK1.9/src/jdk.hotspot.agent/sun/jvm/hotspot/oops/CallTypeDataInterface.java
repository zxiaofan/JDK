/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.oops;

public interface CallTypeDataInterface<K> {
  int numberOfArguments();
  boolean hasArguments();
  K argumentType(int i);
  boolean hasReturn();
  K returnType();
  int argumentTypeIndex(int i);
  int returnTypeIndex();
}
