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

package com.sun.jndi.toolkit.dir;

import javax.naming.*;
import javax.naming.directory.*;

/**
  * A class for searching DirContexts
  *
  * @author Jon Ruiz
  */
public class DirSearch {
   public static NamingEnumeration<SearchResult> search(DirContext ctx,
       Attributes matchingAttributes,
       String[] attributesToReturn) throws NamingException {
        SearchControls cons = new SearchControls(
            SearchControls.ONELEVEL_SCOPE,
            0, 0, attributesToReturn,
            false, false);

        return new LazySearchEnumerationImpl(
            new ContextEnumerator(ctx, SearchControls.ONELEVEL_SCOPE),
            new ContainmentFilter(matchingAttributes),
            cons);
    }

    public static NamingEnumeration<SearchResult> search(DirContext ctx,
        String filter, SearchControls cons) throws NamingException {

        if (cons == null)
            cons = new SearchControls();

        return new LazySearchEnumerationImpl(
            new ContextEnumerator(ctx, cons.getSearchScope()),
            new SearchFilter(filter),
            cons);
    }

    public static NamingEnumeration<SearchResult> search(DirContext ctx,
        String filterExpr, Object[] filterArgs, SearchControls cons)
        throws NamingException {

        String strfilter = SearchFilter.format(filterExpr, filterArgs);
        return search(ctx, strfilter, cons);
    }
}
