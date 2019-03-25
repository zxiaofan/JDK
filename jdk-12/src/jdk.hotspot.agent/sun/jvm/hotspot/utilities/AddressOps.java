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

package sun.jvm.hotspot.utilities;

import sun.jvm.hotspot.debugger.*;

/** Helper class with operations on addresses. Solves the problem of
    one or both of the arguments being null and needing to call
    methods like greaterThan(), lessThan(), etc. on them. */

public class AddressOps {
  /** Returns true if a1 is less than a2. Either or both may be null. */
  public static boolean lessThan(Address a1, Address a2) {
    if (a2 == null) {
      return false;
    } else if (a1 == null) {
      return true;
    } else {
      return a1.lessThan(a2);
    }
  }

  /** Returns true if a1 is less than or equal to a2. Either or both may be null. */
  public static boolean lessThanOrEqual(Address a1, Address a2) {
    if (a2 == null) {
      return (a1 == null);
    } else if (a1 == null) {
      return true;
    } else {
      return a1.lessThanOrEqual(a2);
    }
  }

  /** Returns true if a1 is greater than a2. Either or both may be null. */
  public static boolean greaterThan(Address a1, Address a2) {
    if (a1 == null) {
      return false;
    } else if (a2 == null) {
      return true;
    } else {
      return a1.greaterThan(a2);
    }
  }

  /** Returns true if a1 is greater than or equal to a2. Either or both may be null. */
  public static boolean greaterThanOrEqual(Address a1, Address a2) {
    if (a1 == null) {
      return (a2 == null);
    } else if (a2 == null) {
      return true;
    } else {
      return a1.greaterThanOrEqual(a2);
    }
  }

  /** Returns true if a1 is equal to a2. Either or both may be null. */
  public static boolean equal(Address a1, Address a2) {
    if ((a1 == null) && (a2 == null)) {
      return true;
    }

    if ((a1 == null) || (a2 == null)) {
      return false;
    }

    return (a1.equals(a2));
  }

  /** Shorthand for {@link #lessThan} */
  public static boolean lt(Address a1, Address a2) {
    return lessThan(a1, a2);
  }

  /** Shorthand for {@link #lessThanOrEqual} */
  public static boolean lte(Address a1, Address a2) {
    return lessThanOrEqual(a1, a2);
  }

  /** Shorthand for {@link #greaterThan} */
  public static boolean gt(Address a1, Address a2) {
    return greaterThan(a1, a2);
  }

  /** Shorthand for {@link #greaterThanOrEqual} */
  public static boolean gte(Address a1, Address a2) {
    return greaterThanOrEqual(a1, a2);
  }

  /** Returns maximum of the two addresses */
  public static Address max(Address a1, Address a2) {
    return (gt(a1, a2) ? a1 : a2);
  }

  /** Returns minimum of the two addresses */
  public static Address min(Address a1, Address a2) {
    return (lt(a1, a2) ? a1 : a2);
  }
}
