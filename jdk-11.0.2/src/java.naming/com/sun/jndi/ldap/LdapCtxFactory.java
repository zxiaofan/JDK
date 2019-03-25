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

package com.sun.jndi.ldap;

import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;

import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.ObjectFactory;
import javax.naming.spi.InitialContextFactory;
import javax.naming.ldap.Control;

import com.sun.jndi.url.ldap.ldapURLContextFactory;

final public class LdapCtxFactory implements ObjectFactory, InitialContextFactory {
    /**
     * The type of each address in an LDAP reference.
     */
    public final static String ADDRESS_TYPE = "URL";

    // ----------------- ObjectFactory interface --------------------

    public Object getObjectInstance(Object ref, Name name, Context nameCtx,
        Hashtable<?,?> env) throws Exception {

        if (!isLdapRef(ref)) {
            return null;
        }
        ObjectFactory factory = new ldapURLContextFactory();
        String[] urls = getURLs((Reference)ref);
        return factory.getObjectInstance(urls, name, nameCtx, env);
    }

    // ----------------- InitialContext interface  --------------------

    public Context getInitialContext(Hashtable<?,?> envprops)
        throws NamingException {

        try {
            String providerUrl = (envprops != null) ?
                (String)envprops.get(Context.PROVIDER_URL) : null;

            // If URL not in environment, use defaults
            if (providerUrl == null) {
                return new LdapCtx("", LdapCtx.DEFAULT_HOST,
                    LdapCtx.DEFAULT_PORT, envprops, false);
            }

            // Extract URL(s)
            String[] urls = LdapURL.fromList(providerUrl);

            if (urls.length == 0) {
                throw new ConfigurationException(Context.PROVIDER_URL +
                    " property does not contain a URL");
            }

            // Generate an LDAP context
            return getLdapCtxInstance(urls, envprops);

        } catch (LdapReferralException e) {

            if (envprops != null &&
                "throw".equals(envprops.get(Context.REFERRAL))) {
                throw e;
            }

            Control[] bindCtls = (envprops != null)?
                (Control[])envprops.get(LdapCtx.BIND_CONTROLS) : null;

            return (LdapCtx)e.getReferralContext(envprops, bindCtls);
        }
    }

    /**
     * Returns true if argument is an LDAP reference.
     */
    private static boolean isLdapRef(Object obj) {

        if (!(obj instanceof Reference)) {
            return false;
        }
        String thisClassName = LdapCtxFactory.class.getName();
        Reference ref = (Reference)obj;

        return thisClassName.equals(ref.getFactoryClassName());
    }

    /**
     * Returns the URLs contained within an LDAP reference.
     */
    private static String[] getURLs(Reference ref) throws NamingException {

        int size = 0;   // number of URLs
        String[] urls = new String[ref.size()];

        Enumeration<RefAddr> addrs = ref.getAll();
        while (addrs.hasMoreElements()) {
            RefAddr addr = addrs.nextElement();

            if ((addr instanceof StringRefAddr) &&
                addr.getType().equals(ADDRESS_TYPE)) {

                urls[size++] = (String)addr.getContent();
            }
        }
        if (size == 0) {
            throw (new ConfigurationException(
                    "Reference contains no valid addresses"));
        }

        // Trim URL array down to size.
        if (size == ref.size()) {
            return urls;
        }
        String[] urls2 = new String[size];
        System.arraycopy(urls, 0, urls2, 0, size);
        return urls2;
    }

    // ------------ Utilities used by other classes ----------------

    public static DirContext getLdapCtxInstance(Object urlInfo, Hashtable<?,?> env)
            throws NamingException {

        if (urlInfo instanceof String) {
            return getUsingURL((String)urlInfo, env);
        } else if (urlInfo instanceof String[]) {
            return getUsingURLs((String[])urlInfo, env);
        } else {
            throw new IllegalArgumentException(
                "argument must be an LDAP URL String or array of them");
        }
    }

    private static DirContext getUsingURL(String url, Hashtable<?,?> env)
            throws NamingException {
        DirContext ctx = null;
        LdapURL ldapUrl = new LdapURL(url);
        String dn = ldapUrl.getDN();
        String host = ldapUrl.getHost();
        int port = ldapUrl.getPort();
        String[] hostports;
        String domainName = null;

        // handle a URL with no hostport (ldap:/// or ldaps:///)
        // locate the LDAP service using the URL's distinguished name
        if (host == null &&
            port == -1 &&
            dn != null &&
            (domainName = ServiceLocator.mapDnToDomainName(dn)) != null &&
            (hostports = ServiceLocator.getLdapService(domainName, env))
                != null) {
            // Generate new URLs that include the discovered hostports.
            // Reuse the original URL scheme.
            String scheme = ldapUrl.getScheme() + "://";
            String[] newUrls = new String[hostports.length];
            String query = ldapUrl.getQuery();
            String urlSuffix = ldapUrl.getPath() + (query != null ? query : "");
            for (int i = 0; i < hostports.length; i++) {
                newUrls[i] = scheme + hostports[i] + urlSuffix;
            }
            ctx = getUsingURLs(newUrls, env);
            // Associate the derived domain name with the context
            ((LdapCtx)ctx).setDomainName(domainName);

        } else {
            ctx = new LdapCtx(dn, host, port, env, ldapUrl.useSsl());
            // Record the URL that created the context
            ((LdapCtx)ctx).setProviderUrl(url);
        }
        return ctx;
    }

    /*
     * Try each URL until one of them succeeds.
     * If all URLs fail, throw one of the exceptions arbitrarily.
     * Not pretty, but potentially more informative than returning null.
     */
    private static DirContext getUsingURLs(String[] urls, Hashtable<?,?> env)
            throws NamingException {
        NamingException ne = null;
        DirContext ctx = null;
        for (int i = 0; i < urls.length; i++) {
            try {
                return getUsingURL(urls[i], env);
            } catch (AuthenticationException e) {
                throw e;
            } catch (NamingException e) {
                ne = e;
            }
        }
        throw ne;
    }

    /**
     * Used by Obj and obj/RemoteToAttrs too so must be public
     */
    public static Attribute createTypeNameAttr(Class<?> cl) {
        Vector<String> v = new Vector<>(10);
        String[] types = getTypeNames(cl, v);
        if (types.length > 0) {
            BasicAttribute tAttr =
                new BasicAttribute(Obj.JAVA_ATTRIBUTES[Obj.TYPENAME]);
            for (int i = 0; i < types.length; i++) {
                tAttr.add(types[i]);
            }
            return tAttr;
        }
        return null;
    }

    private static String[] getTypeNames(Class<?> currentClass, Vector<String> v) {

        getClassesAux(currentClass, v);
        Class<?>[] members = currentClass.getInterfaces();
        for (int i = 0; i < members.length; i++) {
            getClassesAux(members[i], v);
        }
        String[] ret = new String[v.size()];
        int i = 0;

        for (String name : v) {
            ret[i++] = name;
        }
        return ret;
    }

    private static void getClassesAux(Class<?> currentClass, Vector<String> v) {
        if (!v.contains(currentClass.getName())) {
            v.addElement(currentClass.getName());
        }
        currentClass = currentClass.getSuperclass();

        while (currentClass != null) {
            getTypeNames(currentClass, v);
            currentClass = currentClass.getSuperclass();
        }
    }
}
