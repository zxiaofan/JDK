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

/**
  * Given an enumeration of candidates, check whether each
  * item in enumeration satifies the given filter.
  * Each item is a Binding and the following is used to get its
  * attributes for used by the filter:
  *
  *   ((DirContext)item.getObject()).getAttributes("").
  * If item.getObject() is not an DirContext, the item is skipped
  *
  * The items in the enumeration are obtained one at a time as
  * items from the search enumeration are requested.
  *
  * @author Rosanna Lee
  */

package com.sun.jndi.toolkit.dir;

import javax.naming.*;
import javax.naming.directory.*;
import javax.naming.spi.DirectoryManager;

import java.util.NoSuchElementException;
import java.util.Hashtable;

public final class LazySearchEnumerationImpl
        implements NamingEnumeration<SearchResult> {
    private NamingEnumeration<Binding> candidates;
    private SearchResult nextMatch = null;
    private SearchControls cons;
    private AttrFilter filter;
    private Context context;
    private Hashtable<String, Object> env;
    private boolean useFactory = true;

    public LazySearchEnumerationImpl(NamingEnumeration<Binding> candidates,
        AttrFilter filter, SearchControls cons) throws NamingException {
            this.candidates = candidates;
            this.filter = filter;

            if(cons == null) {
                this.cons = new SearchControls();
            } else {
                this.cons = cons;
            }
    }

    @SuppressWarnings("unchecked")      // For Hashtable clone: env.clone()
    public LazySearchEnumerationImpl(NamingEnumeration<Binding> candidates,
        AttrFilter filter, SearchControls cons,
        Context ctx, Hashtable<String, Object> env, boolean useFactory)
        throws NamingException {

            this.candidates = candidates;
            this.filter = filter;
            this.env = (Hashtable<String, Object>)
                    ((env == null) ? null : env.clone());
            this.context = ctx;
            this.useFactory = useFactory;

            if(cons == null) {
                this.cons = new SearchControls();
            } else {
                this.cons = cons;
            }
    }


    public LazySearchEnumerationImpl(NamingEnumeration<Binding> candidates,
        AttrFilter filter, SearchControls cons,
        Context ctx, Hashtable<String, Object> env) throws NamingException {
            this(candidates, filter, cons, ctx, env, true);
    }

    public boolean hasMore() throws NamingException {
        // find and do not remove from list
        return findNextMatch(false) != null;
    }

    public boolean hasMoreElements() {
        try {
            return hasMore();
        } catch (NamingException e) {
            return false;
        }
    }

    public SearchResult nextElement() {
        try {
            return findNextMatch(true);
        } catch (NamingException e) {
            throw new NoSuchElementException(e.toString());
        }
    }

    public SearchResult next() throws NamingException {
        // find and remove from list
        return (findNextMatch(true));
    }

    public void close() throws NamingException {
        if (candidates != null) {
            candidates.close();
        }
    }

    private SearchResult findNextMatch(boolean remove) throws NamingException {
        SearchResult answer;
        if (nextMatch != null) {
            answer = nextMatch;
            if (remove) {
                nextMatch = null;
            }
            return answer;
        } else {
            // need to find next match
            Binding next;
            Object obj;
            Attributes targetAttrs;
            while (candidates.hasMore()) {
                next = candidates.next();
                obj = next.getObject();
                if (obj instanceof DirContext) {
                    targetAttrs = ((DirContext)(obj)).getAttributes("");
                    if (filter.check(targetAttrs)) {
                        if (!cons.getReturningObjFlag()) {
                            obj = null;
                        } else if (useFactory) {
                            try {
                                // Give name only if context non-null,
                                // otherwise, name will be interpreted relative
                                // to initial context (not what we want)
                                Name nm = (context != null ?
                                    new CompositeName(next.getName()) : null);
                                obj = DirectoryManager.getObjectInstance(obj,
                                    nm, context, env, targetAttrs);
                            } catch (NamingException e) {
                                throw e;
                            } catch (Exception e) {
                                NamingException e2 = new NamingException(
                                    "problem generating object using object factory");
                                e2.setRootCause(e);
                                throw e2;
                            }
                        }
                        answer = new SearchResult(next.getName(),
                            next.getClassName(), obj,
                            SearchFilter.selectAttributes(targetAttrs,
                                cons.getReturningAttributes()),
                            true);
                        if (!remove)
                            nextMatch = answer;
                        return answer;
                    }
                }
            }
            return null;
        }
    }
}
