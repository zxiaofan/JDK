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

package sun.jvm.hotspot.debugger.cdbg;

/** Describes enumerated types. Enumerations are like ints except that
    they have a set of named values. */

public interface EnumType extends IntType {
  /** Number of enumerates defined in this enum */
  public int getNumEnumerates();

  /** Fetch <i>i</i>th (0..getNumEnumerants() - 1) name */
  public String getEnumName(int i);

  /** Fetch <i>i</i>th (0..getNumEnumerants() - 1) value */
  public long getEnumValue(int i);

  /** Return name for given enum value, or null if not found */
  public String enumNameForValue(long val);
}
