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

/**
  * Supports checking an attribute set satisfies a filter
  * that is specified as a set of "matching" attributes.
  * Checking is done by determining whether the given attribute set
  * is a superset of the matching ones.
  *
  * @author Rosanna Lee
  */

package com.sun.jndi.toolkit.dir;

import javax.naming.*;
import javax.naming.directory.*;

public class ContainmentFilter implements AttrFilter {
    private Attributes matchingAttrs;

    public ContainmentFilter(Attributes match) {
        matchingAttrs = match;
    }

    public boolean check(Attributes attrs) throws NamingException {
        return matchingAttrs == null ||
            matchingAttrs.size() == 0 ||
            contains(attrs, matchingAttrs);
    }

    // returns true if superset contains subset
    public static boolean contains(Attributes superset, Attributes subset)
        throws NamingException {
          if (subset == null)
            return true;  // an empty set is always a subset

            NamingEnumeration<? extends Attribute> m = subset.getAll();
            while (m.hasMore()) {
                if (superset == null) {
                    return false;  // contains nothing
                }
                Attribute target = m.next();
                Attribute fromSuper = superset.get(target.getID());
                if (fromSuper == null) {
                    return false;
                } else {
                    // check whether attribute values match
                    if (target.size() > 0) {
                        NamingEnumeration<?> vals = target.getAll();
                        while (vals.hasMore()) {
                            if (!fromSuper.contains(vals.next())) {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }

}
