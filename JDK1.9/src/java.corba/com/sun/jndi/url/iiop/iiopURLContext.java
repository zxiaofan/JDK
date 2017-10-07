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

package com.sun.jndi.url.iiop;

import javax.naming.spi.ResolveResult;
import javax.naming.*;
import java.util.Hashtable;
import java.net.MalformedURLException;

import com.sun.jndi.cosnaming.IiopUrl;
import com.sun.jndi.cosnaming.CorbanameUrl;

/**
 * An IIOP URL context.
 *
 * @author Rosanna Lee
 */

public class iiopURLContext
        extends GenericURLContext {

    iiopURLContext(Hashtable<?,?> env) {
        super(env);
    }

    /**
      * Resolves 'name' into a target context with remaining name.
      * It only resolves the hostname/port number. The remaining name
      * contains the rest of the name found in the URL.
      *
      * For example, with a iiop URL "iiop://localhost:900/rest/of/name",
      * this method resolves "iiop://localhost:900/" to the "NameService"
      * context on for the ORB at 'localhost' on port 900,
      * and returns as the remaining name "rest/of/name".
      */
    protected ResolveResult getRootURLContext(String name, Hashtable<?,?> env)
    throws NamingException {
        return iiopURLContextFactory.getUsingURLIgnoreRest(name, env);
    }

    /**
     * Return the suffix of an "iiop", "iiopname", or "corbaname" url.
     * prefix parameter is ignored.
     */
    protected Name getURLSuffix(String prefix, String url)
        throws NamingException {
        try {
            if (url.startsWith("iiop://") || url.startsWith("iiopname://")) {
                IiopUrl parsedUrl = new IiopUrl(url);
                return parsedUrl.getCosName();
            } else if (url.startsWith("corbaname:")) {
                CorbanameUrl parsedUrl = new CorbanameUrl(url);
                return parsedUrl.getCosName();
            } else {
                throw new MalformedURLException("Not a valid URL: " + url);
            }
        } catch (MalformedURLException e) {
            throw new InvalidNameException(e.getMessage());
        }
    }
}
