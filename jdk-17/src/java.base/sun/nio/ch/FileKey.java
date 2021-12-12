/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
 *
 */

package sun.nio.ch;

import java.io.FileDescriptor;
import java.io.IOException;

/*
 * Represents a key to a specific file on Windows
 */
public class FileKey {

    private long dwVolumeSerialNumber;
    private long nFileIndexHigh;
    private long nFileIndexLow;

    private FileKey() { }

    public static FileKey create(FileDescriptor fd) throws IOException {
        FileKey fk = new FileKey();
        fk.init(fd);
        return fk;
    }

    public int hashCode() {
        return (int)(dwVolumeSerialNumber ^ (dwVolumeSerialNumber >>> 32)) +
               (int)(nFileIndexHigh ^ (nFileIndexHigh >>> 32)) +
               (int)(nFileIndexLow ^ (nFileIndexHigh >>> 32));
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof FileKey))
            return false;
        FileKey other = (FileKey)obj;
        if ((this.dwVolumeSerialNumber != other.dwVolumeSerialNumber) ||
            (this.nFileIndexHigh != other.nFileIndexHigh) ||
            (this.nFileIndexLow != other.nFileIndexLow)) {
            return false;
        }
        return true;
    }

    private native void init(FileDescriptor fd) throws IOException;
    private static native void initIDs();

    static {
        IOUtil.load();
        initIDs();
    }
}
