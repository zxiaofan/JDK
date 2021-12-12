/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2020, NTT DATA.
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

package sun.jvm.hotspot.debugger.linux.amd64;

import java.lang.ref.Cleaner;
import sun.jvm.hotspot.debugger.Address;
import sun.jvm.hotspot.debugger.DebuggerException;

public class DwarfParser {
  private final long p_dwarf_context; // native dwarf context handle

  private static native void init0();
  private static native long createDwarfContext(long lib);
  private static native void destroyDwarfContext(long context);
  private native boolean isIn0(long pc);

  static {
    init0();
  }

  public DwarfParser(Address lib) {
    p_dwarf_context = createDwarfContext(lib.asLongValue());

    if (p_dwarf_context == 0L) {
      throw new DebuggerException("Could not create DWARF context");
    }

    Cleaner.create()
           .register(this, () -> DwarfParser.destroyDwarfContext(p_dwarf_context));
  }

  public boolean isIn(Address pc) {
    return isIn0(pc.asLongValue());
  }

  private native void processDwarf0(long pc);

  public void processDwarf(Address pc) {
    processDwarf0(pc.asLongValue());
  }

  public native int getCFARegister();
  public native int getCFAOffset();
  public native int getReturnAddressOffsetFromCFA();
  public native int getBasePointerOffsetFromCFA();
  public native boolean isBPOffsetAvailable();
}
