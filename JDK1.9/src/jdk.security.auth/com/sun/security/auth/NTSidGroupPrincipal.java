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
 * and represents one of the groups to which a Windows NT user belongs.
 *
 * <p> Principals such as this {@code NTSidGroupPrincipal}
 * may be associated with a particular {@code Subject}
 * to augment that {@code Subject} with an additional
 * identity.  Refer to the {@code Subject} class for more information
 * on how to achieve this.  Authorization decisions can then be based upon
 * the Principals associated with a {@code Subject}.
 *
 * @see java.security.Principal
 * @see javax.security.auth.Subject
 * @see com.sun.security.auth.NTSid
 */
public class NTSidGroupPrincipal extends NTSid {

    private static final long serialVersionUID = -1373347438636198229L;

    /**
     * Create an {@code NTSidGroupPrincipal} with a Windows NT group name.
     *
     * @param name the Windows NT group SID for this user.
     *
     * @exception NullPointerException if the {@code name}
     *                  is {@code null}.
     */
    public NTSidGroupPrincipal(String name) {
        super(name);
    }

    /**
     * Return a string representation of this {@code NTSidGroupPrincipal}.
     *
     * @return a string representation of this {@code NTSidGroupPrincipal}.
     */
    public String toString() {
        java.text.MessageFormat form = new java.text.MessageFormat
                (sun.security.util.ResourcesMgr.getAuthResourceString
                        ("NTSidGroupPrincipal.name"));
        Object[] source = {getName()};
        return form.format(source);
    }

    /**
     * Compares the specified Object with this {@code NTSidGroupPrincipal}
     * for equality.  Returns true if the given object is also a
     * {@code NTSidGroupPrincipal} and the two NTSidGroupPrincipals
     * have the same SID.
     *
     * @param o Object to be compared for equality with this
     *          {@code NTSidGroupPrincipal}.
     *
     * @return true if the specified Object is equal to this
     *          {@code NTSidGroupPrincipal}.
     */
    public boolean equals(Object o) {
            if (o == null)
                return false;

        if (this == o)
            return true;

        if (!(o instanceof NTSidGroupPrincipal))
            return false;

        return super.equals(o);
    }

}
