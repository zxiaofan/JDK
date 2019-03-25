/*
 * Copyright (c) 2000, 2011, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.url.dns;


import java.util.Hashtable;

import javax.naming.*;
import javax.naming.spi.ObjectFactory;


/**
 * A DNS URL context factory creates contexts that can resolve names
 * that are DNS pseudo-URLs.
 * In addition, if given a specific DNS URL (or an array of them), the
 * factory will resolve all the way to the named context.
 * See com.sun.jndi.dns.DnsUrl for a description of the URL format.
 *
 * @author Scott Seligman
 */


public class dnsURLContextFactory implements ObjectFactory {

    public Object getObjectInstance(Object urlInfo, Name name,
                                    Context nameCtx, Hashtable<?,?> env)
            throws NamingException {

        if (urlInfo == null) {
            return (new dnsURLContext(env));
        } else if (urlInfo instanceof String) {
            return getUsingURL((String) urlInfo, env);
        } else if (urlInfo instanceof String[]) {
            return getUsingURLs((String[]) urlInfo, env);
        } else {
            throw (new ConfigurationException(
                    "dnsURLContextFactory.getObjectInstance: " +
                    "argument must be a DNS URL String or an array of them"));
        }
    }

    private static Object getUsingURL(String url, Hashtable<?,?> env)
            throws NamingException {

        dnsURLContext urlCtx = new dnsURLContext(env);
        try {
            return urlCtx.lookup(url);
        } finally {
            urlCtx.close();
        }
    }

    /*
     * Try each URL until lookup() succeeds for one of them.
     * If all URLs fail, throw one of the exceptions arbitrarily.
     * Not pretty, but potentially more informative than returning null.
     */
    private static Object getUsingURLs(String[] urls, Hashtable<?,?> env)
            throws NamingException {

        if (urls.length == 0) {
            throw (new ConfigurationException(
                    "dnsURLContextFactory: empty URL array"));
        }
        dnsURLContext urlCtx = new dnsURLContext(env);
        try {
            NamingException ne = null;
            for (int i = 0; i < urls.length; i++) {
                try {
                    return urlCtx.lookup(urls[i]);
                } catch (NamingException e) {
                    ne = e;
                }
            }
            throw ne;   // failure:  throw one of the exceptions caught
        } finally {
            urlCtx.close();
        }
    }
}
