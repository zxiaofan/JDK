/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Represents an entry in the mount table.
 */

class UnixMountEntry {
    private byte[] name;        // file system name
    private byte[] dir;         // directory (mount point)
    private byte[] fstype;      // ufs, nfs, ...
    private byte[] opts;        // mount options
    private long dev;           // device ID

    private volatile String fstypeAsString;
    private volatile String optionsAsString;

    UnixMountEntry() {
    }

    String name() {
        return Util.toString(name);
    }

    String fstype() {
        if (fstypeAsString == null)
            fstypeAsString = Util.toString(fstype);
        return fstypeAsString;
    }

    byte[] dir() {
        return dir;
    }

    long dev() {
        return dev;
    }

    /**
     * Tells whether the mount entry has the given option.
     */
    boolean hasOption(String requested) {
        if (optionsAsString == null)
            optionsAsString = Util.toString(opts);
        for (String opt: Util.split(optionsAsString, ',')) {
            if (opt.equals(requested))
                return true;
        }
        return false;
    }

    // generic option
    boolean isIgnored() {
        return hasOption("ignore");
    }

    // generic option
    boolean isReadOnly() {
        return hasOption("ro");
    }
}
