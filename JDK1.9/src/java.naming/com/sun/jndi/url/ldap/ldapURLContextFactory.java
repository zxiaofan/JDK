/*
 * Copyright (c) 1999, 2011, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.url.ldap;

import java.util.Hashtable;
import javax.naming.*;
import javax.naming.directory.DirContext;
import javax.naming.spi.*;
import com.sun.jndi.ldap.LdapCtx;
import com.sun.jndi.ldap.LdapCtxFactory;
import com.sun.jndi.ldap.LdapURL;

/**
 * An LDAP URL context factory.
 *
 * @author Rosanna Lee
 * @author Scott Seligman
 * @author Vincent Ryan
 */

public class ldapURLContextFactory implements ObjectFactory {

    public Object getObjectInstance(Object urlInfo, Name name, Context nameCtx,
            Hashtable<?,?> env) throws Exception {

        if (urlInfo == null) {
            return new ldapURLContext(env);
        } else {
            return LdapCtxFactory.getLdapCtxInstance(urlInfo, env);
        }
    }

    static ResolveResult getUsingURLIgnoreRootDN(String url, Hashtable<?,?> env)
            throws NamingException {
        LdapURL ldapUrl = new LdapURL(url);
        DirContext ctx = new LdapCtx("", ldapUrl.getHost(), ldapUrl.getPort(),
            env, ldapUrl.useSsl());
        String dn = (ldapUrl.getDN() != null ? ldapUrl.getDN() : "");

        // Represent DN as empty or single-component composite name.
        CompositeName remaining = new CompositeName();
        if (!"".equals(dn)) {
            // if nonempty, add component
            remaining.add(dn);
        }

        return new ResolveResult(ctx, remaining);
    }
}
