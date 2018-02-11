/*
 * Copyright (c) 2006, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.net.httpserver;
import java.net.*;
import java.io.*;
import java.util.*;
import java.security.Principal;

/**
 * Represents a user authenticated by HTTP Basic or Digest
 * authentication.
 */
public class HttpPrincipal implements Principal {
    private String username, realm;

    /**
     * creates a HttpPrincipal from the given username and realm
     * @param username The name of the user within the realm
     * @param realm The realm.
     * @throws NullPointerException if either username or realm are null
     */
    public HttpPrincipal (String username, String realm) {
        if (username == null || realm == null) {
            throw new NullPointerException();
        }
        this.username = username;
        this.realm = realm;
    }

    /**
     * Compares two HttpPrincipal. Returns <code>true</code>
     * if <i>another</i> is an instance of HttpPrincipal, and its
     * username and realm are equal to this object's username
     * and realm. Returns <code>false</code> otherwise.
     */
    public boolean equals (Object another) {
        if (!(another instanceof HttpPrincipal)) {
            return false;
        }
        HttpPrincipal theother = (HttpPrincipal)another;
        return (username.equals(theother.username) &&
                realm.equals(theother.realm));
    }

    /**
     * returns the contents of this principal in the form
     * <i>realm:username</i>
     */
    public String getName() {
        return username;
    }

    /**
     * returns the username this object was created with.
     */
    public String getUsername() {
        return username;
    }

    /**
     * returns the realm this object was created with.
     */
    public String getRealm() {
        return realm;
    }

    /**
     * returns a hashcode for this HttpPrincipal. This is calculated
     * as <code>(getUsername()+getRealm().hashCode()</code>
     */
    public int hashCode() {
        return (username+realm).hashCode();
    }

    /**
     * returns the same string as getName()
     */
    public String toString() {
        return getName();
    }
}
