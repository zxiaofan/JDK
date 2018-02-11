/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * This class implementation retrieves and makes available Solaris
 * UID/GID/groups information for the current user.
 *
 * @deprecated replaced by {@link UnixSystem}.
 * This class is subject to removal in a future version of Java SE.
 */
@Deprecated(since="1.4", forRemoval=true)
public class SolarisSystem {

    private native void getSolarisInfo();

    protected String username;
    protected long uid;
    protected long gid;
    protected long[] groups;

    /**
     * Instantiate a {@code SolarisSystem} and load
     * the native library to access the underlying system information.
     */
    public SolarisSystem() {
        System.loadLibrary("jaas_unix");
        getSolarisInfo();
    }

    /**
     * Get the username for the current Solaris user.
     *
     * @return the username for the current Solaris user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the UID for the current Solaris user.
     *
     * @return the UID for the current Solaris user.
     */
    public long getUid() {
        return uid;
    }

    /**
     * Get the GID for the current Solaris user.
     *
     * @return the GID for the current Solaris user.
     */
    public long getGid() {
        return gid;
    }

    /**
     * Get the supplementary groups for the current Solaris user.
     *
     * @return the supplementary groups for the current Solaris user.
     */
    public long[] getGroups() {
        return groups == null ? null : groups.clone();
    }
}
