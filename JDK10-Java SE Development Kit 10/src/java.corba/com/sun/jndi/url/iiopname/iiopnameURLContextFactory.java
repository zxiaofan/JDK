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

package com.sun.jndi.url.iiopname;

import com.sun.jndi.url.iiop.iiopURLContextFactory;

/**
 * An iiopname URL context factory.
 * It just uses the iiop URL context factory but is needed here
 * so that NamingManager.getURLContext() will find it.
 *
 * @author Rosanna Lee
 */
final public class iiopnameURLContextFactory extends iiopURLContextFactory {
}
