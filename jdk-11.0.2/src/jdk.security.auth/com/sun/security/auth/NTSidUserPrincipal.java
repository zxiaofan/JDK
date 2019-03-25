/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.auth;

/**
 * This class extends {@code NTSid}
 * and represents a Windows NT user's SID.
 *
 * <p> Principals such as this {@code NTSidUserPrincipal}
 * may be associated with a particular {@code Subject}
 * to augment that {@code Subject} with an additional
 * identity.  Refer to the {@code Subject} class for more information
 * on how to achieve this.  Authorization decisions can then be based upon
 * the Principals associated with a {@code Subject}.
 *
 * @see java.security.Principal
 * @see javax.security.auth.Subject
 */
public class NTSidUserPrincipal extends NTSid {

    private static final long serialVersionUID = -5573239889517749525L;

    /**
     * Create an {@code NTSidUserPrincipal} with a Windows NT SID.
     *
     * @param name a string version of the Windows NT SID for this user.
     *
     * @exception NullPointerException if the {@code name}
     *                  is {@code null}.
     */
    public NTSidUserPrincipal(String name) {
        super(name);
    }

    /**
     * Return a string representation of this {@code NTSidUserPrincipal}.
     *
     * @return a string representation of this {@code NTSidUserPrincipal}.
     */
    public String toString() {
        java.text.MessageFormat form = new java.text.MessageFormat
                (sun.security.util.ResourcesMgr.getAuthResourceString
                        ("NTSidUserPrincipal.name"));
        Object[] source = {getName()};
        return form.format(source);
    }

    /**
     * Compares the specified Object with this {@code NTSidUserPrincipal}
     * for equality.  Returns true if the given object is also a
     * {@code NTSidUserPrincipal} and the two NTSidUserPrincipals
     * have the same SID.
     *
     * @param o Object to be compared for equality with this
     *          {@code NTSidUserPrincipal}.
     *
     * @return true if the specified Object is equal to this
     *          {@code NTSidUserPrincipal}.
     */
    public boolean equals(Object o) {
            if (o == null)
                return false;

        if (this == o)
            return true;

        if (!(o instanceof NTSidUserPrincipal))
            return false;

        return super.equals(o);
    }
}
