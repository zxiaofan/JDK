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
 * This class abstracts an NT security token
 * and provides a mechanism to do same-process security impersonation.
 */

public class NTNumericCredential {

    private long impersonationToken;

    /**
     * Create an {@code NTNumericCredential} with an integer value.
     *
     * @param token the Windows NT security token for this user.
     */
    public NTNumericCredential(long token) {
        this.impersonationToken = token;
    }

    /**
     * Return an integer representation of this
     * {@code NTNumericCredential}.
     *
     * @return an integer representation of this
     *          {@code NTNumericCredential}.
     */
    public long getToken() {
        return impersonationToken;
    }

    /**
     * Return a string representation of this {@code NTNumericCredential}.
     *
     * @return a string representation of this {@code NTNumericCredential}.
     */
    public String toString() {
        java.text.MessageFormat form = new java.text.MessageFormat
                (sun.security.util.ResourcesMgr.getAuthResourceString
                        ("NTNumericCredential.name"));
        Object[] source = {Long.toString(impersonationToken)};
        return form.format(source);
    }

    /**
     * Compares the specified Object with this {@code NTNumericCredential}
     * for equality.  Returns true if the given object is also a
     * {@code NTNumericCredential} and the two NTNumericCredentials
     * represent the same NT security token.
     *
     * @param o Object to be compared for equality with this
     *          {@code NTNumericCredential}.
     *
     * @return true if the specified Object is equal to this
     *          {@code NTNumericCredential}.
     */
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (this == o)
            return true;

        if (!(o instanceof NTNumericCredential))
            return false;
        NTNumericCredential that = (NTNumericCredential)o;

        if (impersonationToken == that.getToken())
            return true;
        return false;
    }

    /**
     * Return a hash code for this {@code NTNumericCredential}.
     *
     * @return a hash code for this {@code NTNumericCredential}.
     */
    public int hashCode() {
        return (int)this.impersonationToken;
    }
}
