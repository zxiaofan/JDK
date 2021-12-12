/*
 * Copyright (c) 2000, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * This class implementation retrieves and makes available NT
 * security information for the current user.
 *
 */
public class NTSystem {

    private native void getCurrent(boolean debug);
    private native long getImpersonationToken0();

    // Warning: the next 6 fields are used by nt.c
    private String userName;
    private String domain;
    private String domainSID;
    private String userSID;
    private String[] groupIDs;
    private String primaryGroupID;

    private long   impersonationToken;

    /**
     * Instantiate an {@code NTSystem} and load
     * the native library to access the underlying system information.
     */
    public NTSystem() {
        this(false);
    }

    /**
     * Instantiate an {@code NTSystem} and load
     * the native library to access the underlying system information.
     */
    NTSystem(boolean debug) {
        loadNative();
        getCurrent(debug);
    }

    /**
     * Get the username for the current NT user.
     *
     * @return the username for the current NT user.
     */
    public String getName() {
        return userName;
    }

    /**
     * Get the domain for the current NT user.
     *
     * @return the domain for the current NT user.
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Get a printable SID for the current NT user's domain.
     *
     * @return a printable SID for the current NT user's domain.
     */
    public String getDomainSID() {
        return domainSID;
    }

    /**
     * Get a printable SID for the current NT user.
     *
     * @return a printable SID for the current NT user.
     */
    public String getUserSID() {
        return userSID;
    }

    /**
     * Get a printable primary group SID for the current NT user.
     *
     * @return the primary group SID for the current NT user.
     */
    public String getPrimaryGroupID() {
        return primaryGroupID;
    }

    /**
     * Get the printable group SIDs for the current NT user.
     *
     * @return the group SIDs for the current NT user.
     */
    public String[] getGroupIDs() {
        return groupIDs == null ? null : groupIDs.clone();
    }

    /**
     * Get an impersonation token for the current NT user.
     *
     * @return an impersonation token for the current NT user.
     */
    public synchronized long getImpersonationToken() {
        if (impersonationToken == 0) {
            impersonationToken = getImpersonationToken0();
        }
        return impersonationToken;
    }


    private void loadNative() {
        System.loadLibrary("jaas");
    }
}
