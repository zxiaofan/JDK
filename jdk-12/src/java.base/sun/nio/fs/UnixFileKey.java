/*
 * Copyright (c) 2008, 2009, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.fs;

/**
 * Container for device/inode to uniquely identify file.
 */

class UnixFileKey {
    private final long st_dev;
    private final long st_ino;

    UnixFileKey(long st_dev, long st_ino) {
        this.st_dev = st_dev;
        this.st_ino = st_ino;
    }

    @Override
    public int hashCode() {
        return (int)(st_dev ^ (st_dev >>> 32)) +
               (int)(st_ino ^ (st_ino >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof UnixFileKey))
            return false;
        UnixFileKey other = (UnixFileKey)obj;
        return (this.st_dev == other.st_dev) && (this.st_ino == other.st_ino);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(dev=")
          .append(Long.toHexString(st_dev))
          .append(",ino=")
          .append(st_ino)
          .append(')');
        return sb.toString();
    }
}
