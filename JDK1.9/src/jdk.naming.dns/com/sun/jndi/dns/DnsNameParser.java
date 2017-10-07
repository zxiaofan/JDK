/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.dns;


import javax.naming.*;


/**
 * A name parser for DNS names.
 *
 * @author Scott Seligman
 */


class DnsNameParser implements NameParser {

    public Name parse(String name) throws NamingException {
        return new DnsName(name);
    }


    // Every DnsNameParser is created equal.

    public boolean equals(Object obj) {
        return (obj instanceof DnsNameParser);
    }

    public int hashCode() {
        return DnsNameParser.class.hashCode() + 1;
    }
}
