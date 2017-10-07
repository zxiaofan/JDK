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

import java.security.Principal;
import static sun.security.util.ResourcesMgr.getAuthResourceString;


/**
 * This class implements the {@code Principal} interface
 * and represents a Solaris user.
 *
 * <p> Principals such as this {@code SolarisPrincipal}
 * may be associated with a particular {@code Subject}
 * to augment that {@code Subject} with an additional
 * identity.  Refer to the {@code Subject} class for more information
 * on how to achieve this.  Authorization decisions can then be based upon
 * the Principals associated with a {@code Subject}.
 *
 * @deprecated As of JDK&nbsp;1.4, replaced by
 *             {@link UnixPrincipal}.
 *             This class is entirely deprecated.
 * This class is subject to removal in a future version of Java SE.
 * @see java.security.Principal
 * @see javax.security.auth.Subject
 */
@Deprecated(since="1.4", forRemoval=true)
public class SolarisPrincipal implements Principal, java.io.Serializable {

    private static final long serialVersionUID = -7840670002439379038L;

    /**
     * @serial
     */
    private String name;

    /**
     * Create a SolarisPrincipal with a Solaris username.
     *
     * @param name the Unix username for this user.
     *
     * @exception NullPointerException if the {@code name}
     *                  is {@code null}.
     */
    public SolarisPrincipal(String name) {
        if (name == null)
            throw new NullPointerException(getAuthResourceString("provided.null.name"));

        this.name = name;
    }

    /**
     * Return the Unix username for this {@code SolarisPrincipal}.
     *
     * @return the Unix username for this {@code SolarisPrincipal}
     */
    public String getName() {
        return name;
    }

    /**
     * Return a string representation of this {@code SolarisPrincipal}.
     *
     * @return a string representation of this {@code SolarisPrincipal}.
     */
    public String toString() {
        return(getAuthResourceString("SolarisPrincipal.") + name);
    }

    /**
     * Compares the specified Object with this {@code SolarisPrincipal}
     * for equality.  Returns true if the given object is also a
     * {@code SolarisPrincipal} and the two SolarisPrincipals
     * have the same username.
     *
     * @param o Object to be compared for equality with this
     *          {@code SolarisPrincipal}.
     *
     * @return true if the specified Object is equal to this
     *          {@code SolarisPrincipal}.
     */
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (this == o)
            return true;

        if (!(o instanceof SolarisPrincipal))
            return false;
        SolarisPrincipal that = (SolarisPrincipal)o;

        if (this.getName().equals(that.getName()))
            return true;
        return false;
    }

    /**
     * Return a hash code for this {@code SolarisPrincipal}.
     *
     * @return a hash code for this {@code SolarisPrincipal}.
     */
    public int hashCode() {
        return name.hashCode();
    }
}
