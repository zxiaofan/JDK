/*
 * Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.io.*;
import java.util.*;
import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.runtime.*;
import sun.jvm.hotspot.types.*;
import sun.jvm.hotspot.utilities.*;

// A Symbol is a canonicalized string.
// All Symbols reside in global symbolTable.

public class Symbol extends VMObject {
  static {
    VM.registerVMInitializedObserver(new Observer() {
        public void update(Observable o, Object data) {
          initialize(VM.getVM().getTypeDataBase());
        }
      });
  }

  private static synchronized void initialize(TypeDataBase db) throws WrongTypeException {
    Type type  = db.lookupType("Symbol");
    length     = type.getCIntegerField("_length");
    baseOffset = type.getField("_body").getOffset();
    idHash = type.getCIntegerField("_identity_hash");
  }

  // Format:
  //   [header]
  //   [klass ]
  //   [length] byte size of uft8 string
  //   ..body..

  public static Symbol create(Address addr) {
    if (addr == null) {
      return null;
    }
    return new Symbol(addr);
  }

  Symbol(Address addr) {
    super(addr);
  }

  public boolean isSymbol()            { return true; }

  private static long baseOffset; // tells where the array part starts

  // Fields
  private static CIntegerField length;

  // Accessors for declared fields
  public long   getLength() { return          length.getValue(this.addr); }

  public byte getByteAt(long index) {
    return addr.getJByteAt(baseOffset + index);
  }
  // _identity_hash is a short
  private static CIntegerField idHash;

  public int identityHash() {
    long addr_value = getAddress().asLongValue();
    int  addr_bits = (int)(addr_value >> (VM.getVM().getLogMinObjAlignmentInBytes() + 3));
    int  length = (int)getLength();
    int  byte0 = getByteAt(0);
    int  byte1 = getByteAt(1);
    int  id_hash = (int)(0xffff & idHash.getValue(this.addr));
    return id_hash |
           ((addr_bits ^ (length << 8) ^ ((byte0 << 8) | byte1)) << 16);
  }

  public boolean equals(byte[] modUTF8Chars) {
    int l = (int) getLength();
    if (l != modUTF8Chars.length) return false;
    while (l-- > 0) {
      if (modUTF8Chars[l] != getByteAt(l)) return false;
    }
    if (Assert.ASSERTS_ENABLED) {
      Assert.that(l == -1, "we should be at the beginning");
    }
    return true;
  }

  public byte[] asByteArray() {
    int length = (int) getLength();
    byte [] result = new byte [length];
    for (int index = 0; index < length; index++) {
      result[index] = getByteAt(index);
    }
    return result;
  }

  public String asString() {
    // Decode the byte array and return the string.
    try {
      return readModifiedUTF8(asByteArray());
    } catch(Exception e) {
      System.err.println(addr);
      e.printStackTrace();
      return null;
    }
  }

  public boolean startsWith(String str) {
    return asString().startsWith(str);
  }

  public void printValueOn(PrintStream tty) {
    tty.print("#" + asString());
  }

  /** Note: this comparison is used for vtable sorting only; it
      doesn't matter what order it defines, as long as it is a total,
      time-invariant order Since Symbol* are in C_HEAP, their
      relative order in memory never changes, so use address
      comparison for speed. */
  public long fastCompare(Symbol other) {
    return addr.minus(other.addr);
  }

  private static String readModifiedUTF8(byte[] buf) throws IOException {
    final int len = buf.length;
    byte[] tmp = new byte[len + 2];
    // write modified UTF-8 length as short in big endian
    tmp[0] = (byte) ((len >>> 8) & 0xFF);
    tmp[1] = (byte) ((len >>> 0) & 0xFF);
    // copy the data
    System.arraycopy(buf, 0, tmp, 2, len);
    DataInputStream dis = new DataInputStream(new ByteArrayInputStream(tmp));
    return dis.readUTF();
  }
}
