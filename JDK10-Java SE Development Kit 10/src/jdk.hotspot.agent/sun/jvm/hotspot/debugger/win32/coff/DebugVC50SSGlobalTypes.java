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

package sun.jvm.hotspot.debugger.win32.coff;

/** Models the "sstGlobalTypes" subsection in Visual C++ 5.0 debug
    information. This class provides access to the types via
    iterators; it does not instantiate objects to represent types
    because of the expected high volume of types. The caller is
    expected to traverse this table and convert the platform-dependent
    types into a platform-independent format at run time. */

public interface DebugVC50SSGlobalTypes extends DebugVC50Subsection {
  /** Number of types in the table. */
  public int getNumTypes();

  /** Absolute file offset of the <i>i</i>th (0..getNumTypes() - 1)
      type in the table. */
  public int getTypeOffset(int i);

  /** Create a new type iterator pointing to the first type in the
      subsection. */
  public DebugVC50TypeIterator getTypeIterator();
}
