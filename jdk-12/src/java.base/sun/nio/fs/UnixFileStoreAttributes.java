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

class UnixFileStoreAttributes {
    private long f_frsize;          // block size
    private long f_blocks;          // total
    private long f_bfree;           // free
    private long f_bavail;          // usable

    private UnixFileStoreAttributes() {
    }

    static UnixFileStoreAttributes get(UnixPath path) throws UnixException {
        UnixFileStoreAttributes attrs = new UnixFileStoreAttributes();
        UnixNativeDispatcher.statvfs(path, attrs);
        return attrs;
    }

    long blockSize() {
        return f_frsize;
    }

    long totalBlocks() {
        return f_blocks;
    }

    long freeBlocks() {
        return f_bfree;
    }

    long availableBlocks() {
        return f_bavail;
    }

}
