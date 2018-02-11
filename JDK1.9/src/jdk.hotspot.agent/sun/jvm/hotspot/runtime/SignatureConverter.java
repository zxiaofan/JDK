/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime;

import sun.jvm.hotspot.oops.*;

public class SignatureConverter extends SignatureIterator {
    private StringBuffer buf;
    private boolean first = true;

    public SignatureConverter(Symbol sig, StringBuffer buf) {
      super(sig);
      this.buf = buf;
    }

    public void doBool  () { appendComma(); buf.append("boolean"); }
    public void doChar  () { appendComma(); buf.append("char");    }
    public void doFloat () { appendComma(); buf.append("float");   }
    public void doDouble() { appendComma(); buf.append("double");  }
    public void doByte  () { appendComma(); buf.append("byte");    }
    public void doShort () { appendComma(); buf.append("short");   }
    public void doInt   () { appendComma(); buf.append("int");     }
    public void doLong  () { appendComma(); buf.append("long");    }
    public void doVoid  () {
       if(isReturnType()) {
          appendComma(); buf.append("void");
       } else {
          throw new RuntimeException("Should not reach here");
       }
    }

    public void doObject(int begin, int end) { doObject(begin, end, true); }
    public void doArray (int begin, int end) {
      appendComma();
      int inner = arrayInnerBegin(begin);
      switch (_signature.getByteAt(inner)) {
      case 'B': buf.append("byte"); break;
      case 'C': buf.append("char"); break;
      case 'D': buf.append("double"); break;
      case 'F': buf.append("float"); break;
      case 'I': buf.append("int"); break;
      case 'J': buf.append("long"); break;
      case 'S': buf.append("short"); break;
      case 'Z': buf.append("boolean"); break;
      case 'L': doObject(inner + 1, end, false); break;
      default: break;
      }
      for (int i = 0; i < inner - begin + 1; i++) {
        buf.append("[]");
      }
    }

    public void appendComma() {
      if (!first) {
        buf.append(", ");
      }
      first = false;
    }

    private void doObject(int begin, int end, boolean comma) {
      if (comma) {
        appendComma();
      }
      appendSubstring(begin, end - 1);
    }

    private void appendSubstring(int begin, int end) {
      for (int i = begin; i < end; i++) {
        buf.append((char) (_signature.getByteAt(i) & 0xFF));
      }
    }

    private int arrayInnerBegin(int begin) {
      while (_signature.getByteAt(begin) == '[') {
        ++begin;
      }
      return begin;
    }
}
