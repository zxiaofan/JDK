/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.url.corbaname;

import com.sun.jndi.url.iiop.iiopURLContextFactory;

/**
 * A corbaname URL context factory.
 * It just uses the iiop URL context factory but is needed here
 * so that NamingManager.getURLContext() will find it.
 *
 * @author Rosanna Lee
 */
final public class corbanameURLContextFactory extends iiopURLContextFactory {
}
