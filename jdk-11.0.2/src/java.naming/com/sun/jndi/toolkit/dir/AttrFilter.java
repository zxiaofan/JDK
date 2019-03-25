/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

/**
  * Is implemented by classes that can perform filter checks on
  * an attribute set.
  */

public interface AttrFilter {

    /**
      * Determines whether an attribute passes the filter.
      */
    public boolean check(Attributes targetAttrs) throws NamingException;
}
