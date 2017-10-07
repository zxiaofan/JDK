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

package sun.jvm.hotspot.debugger;

import java.io.*;
import java.nio.*;

/** Implementation of DataSource using MappedByteBuffer. This works
    around a performance problem in JDK 1.4 where ByteBuffer's
    operations always become virtual calls rather than being inlined.
    Need to fix this soon. */

public class MappedByteBufferDataSource implements DataSource {
  private MappedByteBuffer buf;

  public MappedByteBufferDataSource(MappedByteBuffer buf) {
    this.buf = buf;
  }

  public byte  readByte()       throws IOException { return buf.get();            }
  public short readShort()      throws IOException { return buf.getShort();       }
  public int   readInt()        throws IOException { return buf.getInt();         }
  public long  readLong()       throws IOException { return buf.getLong();        }
  public int   read(byte[] b)   throws IOException { buf.get(b); return b.length; }
  public void  seek(long pos)   throws IOException {
    try {
      buf.position((int) pos);
    } catch (IllegalArgumentException e) {
      System.err.println("Error seeking to file position 0x" + Long.toHexString(pos));
      throw(e);
    }
  }
  public long  getFilePointer() throws IOException { return buf.position();       }
  public void  close()          throws IOException { buf = null;                  }
}
