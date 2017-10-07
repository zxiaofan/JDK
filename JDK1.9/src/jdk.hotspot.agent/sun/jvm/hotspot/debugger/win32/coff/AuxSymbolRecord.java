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

package sun.jvm.hotspot.debugger.win32.coff;

/** Describes an Auxiliary Symbol Record. Such records may follow a
    Symbol Table record. (Some of the descriptions are taken directly
    from Microsoft's documentation and are copyrighted by Microsoft.)  */

public interface AuxSymbolRecord {
  public static final int FUNCTION_DEFINITION   = 0;
  public static final int BF_EF_RECORD          = 1;
  public static final int WEAK_EXTERNAL         = 2;
  public static final int FILE                  = 3;
  public static final int SECTION_DEFINITION    = 4;

  /** Returns {@link #FUNCTION_DEFINITION}, {@link #BF_EF_RECORD},
      {@link #WEAK_EXTERNAL}, {@link #FILE}, or {@link
      #SECTION_DEFINITION}, indicating the concrete subtype of this
      interface. */
  public int getType();
}
