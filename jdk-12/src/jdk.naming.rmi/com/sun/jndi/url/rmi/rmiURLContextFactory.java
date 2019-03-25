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

package com.sun.jndi.url.rmi;


import java.util.Hashtable;

import javax.naming.*;
import javax.naming.spi.ObjectFactory;


/**
 * An RMI URL context factory creates contexts that can resolve names
 * that are RMI URLs as defined by rmiURLContext.
 * In addition, if given a specific RMI URL (or an array of them), the
 * factory will resolve all the way to the named registry or object.
 *
 * @author Scott Seligman
 *
 * @see rmiURLContext
 */


public class rmiURLContextFactory implements ObjectFactory {

    public Object getObjectInstance(Object urlInfo, Name name,
                                    Context nameCtx, Hashtable<?,?> env)
            throws NamingException
    {
        if (urlInfo == null) {
            return (new rmiURLContext(env));
        } else if (urlInfo instanceof String) {
            return getUsingURL((String)urlInfo, env);
        } else if (urlInfo instanceof String[]) {
            return getUsingURLs((String[])urlInfo, env);
        } else {
            throw (new ConfigurationException(
                    "rmiURLContextFactory.getObjectInstance: " +
                    "argument must be an RMI URL String or an array of them"));
        }
    }

    private static Object getUsingURL(String url, Hashtable<?,?> env)
            throws NamingException
    {
        rmiURLContext urlCtx = new rmiURLContext(env);
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
            throws NamingException
    {
        if (urls.length == 0) {
            throw (new ConfigurationException(
                    "rmiURLContextFactory: empty URL array"));
        }
        rmiURLContext urlCtx = new rmiURLContext(env);
        try {
            NamingException ne = null;
            for (int i = 0; i < urls.length; i++) {
                try {
                    return urlCtx.lookup(urls[i]);
                } catch (NamingException e) {
                    ne = e;
                }
            }
            throw ne;
        } finally {
            urlCtx.close();
        }
    }
}
