/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.debugger;

/** Base class for all twos-complement machine descriptions, which
    handles the cIntegerType{Min,Max}Value methods. */

public abstract class MachineDescriptionTwosComplement {

  /** Handles 1, 2, 4, and 8-byte signed integers */
  private static final long[] signedMinValues = {
    Byte.MIN_VALUE,
    Short.MIN_VALUE,
    Integer.MIN_VALUE,
    Long.MIN_VALUE
  };

  /** Handles 1, 2, 4, and 8-byte signed integers */
  private static final long[] signedMaxValues = {
    Byte.MAX_VALUE,
    Short.MAX_VALUE,
    Integer.MAX_VALUE,
    Long.MAX_VALUE
  };

  /** Handles 1, 2, and 4-byte unsigned integers properly, with a bug
      in the 8-byte unsigned integer's constant */
  private static final long[] unsignedMaxValues = {
    255L,
    65535L,
    4294967295L,
    -1L
  };

  public long cIntegerTypeMaxValue(long sizeInBytes, boolean isUnsigned) {
    if (isUnsigned) {
      // Would be nice to signal to the caller that 8-byte unsigned
      // integers are not supported properly, but it looks like doing
      // so at this level will cause problems above

      return tableLookup(sizeInBytes, unsignedMaxValues);
    } else {
      return tableLookup(sizeInBytes, signedMaxValues);
    }
  };

  public long cIntegerTypeMinValue(long sizeInBytes, boolean isUnsigned) {
    if (isUnsigned) {
      return 0;
    }

    return tableLookup(sizeInBytes, signedMinValues);
  }

  // Nearly all of the supported machines are not LP64 */
  public boolean isLP64() {
    return false;
  }

  private long tableLookup(long sizeInBytes, long[] table) {
    switch ((int) sizeInBytes) {
    case 1:
      return table[0];
    case 2:
      return table[1];
    case 4:
      return table[2];
    case 8:
      return table[3];
    default:
      throw new IllegalArgumentException("C integer type of " + sizeInBytes + " not supported");
    }
  }
}
