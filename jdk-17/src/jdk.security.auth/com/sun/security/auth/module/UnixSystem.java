/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.auth.module;

/**
 * This class implementation retrieves and makes available Unix
 * UID/GID/groups information for the current user.
 */
public class UnixSystem {

    private native void getUnixInfo();

    // Warning: the following 4 fields are used by Unix.c

    /** The current username. */
    protected String username;

    /** The current user ID. */
    protected long uid;

    /** The current group ID. */
    protected long gid;

    /** The current list of groups. */
    protected long[] groups;

    /**
     * Instantiate a {@code UnixSystem} and load
     * the native library to access the underlying system information.
     */
    public UnixSystem() {
        System.loadLibrary("jaas");
        getUnixInfo();
    }

    /**
     * Get the username for the current Unix user.
     *
     * @return the username for the current Unix user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the UID for the current Unix user.
     *
     * @return the UID for the current Unix user.
     */
    public long getUid() {
        return uid;
    }

    /**
     * Get the GID for the current Unix user.
     *
     * @return the GID for the current Unix user.
     */
    public long getGid() {
        return gid;
    }

    /**
     * Get the supplementary groups for the current Unix user.
     *
     * @return the supplementary groups for the current Unix user.
     */
    public long[] getGroups() {
        return groups == null ? null : groups.clone();
    }
}
