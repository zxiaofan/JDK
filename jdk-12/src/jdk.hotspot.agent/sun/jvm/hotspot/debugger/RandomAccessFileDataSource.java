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

import java.io.*;

/* This class is used by the Windows COFF and Posix ELF implementations. */
public class RandomAccessFileDataSource implements DataSource {
  public RandomAccessFileDataSource(RandomAccessFile file) {
    this.file = file;
  }

  public byte  readByte()       throws IOException { return file.readByte();       }
  public short readShort()      throws IOException { return file.readShort();      }
  public int   readInt()        throws IOException { return file.readInt();        }
  public long  readLong()       throws IOException { return file.readLong();       }
  public int   read(byte[] b)   throws IOException { return file.read(b);          }
  public void  seek(long pos)   throws IOException { file.seek(pos);               }
  public long  getFilePointer() throws IOException { return file.getFilePointer(); }
  public void  close()          throws IOException { file.close();                 }

  private RandomAccessFile file;
}
