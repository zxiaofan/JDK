/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Provides the API to attach to a Java virtual machine.
 * <p>
 * A tool, written in the Java Language, uses this API to attach to a target
 * virtual machine (VM) and load its tool agent into the target VM. For
 * example, a management console might have a management agent which it uses
 * to  obtain management information from instrumented objects in a Java
 * virtual machine. If the management console is required to manage
 * an application that is running in a virtual machine that does not include
 * the management agent, then this API can be used to attach to the target
 * VM and load the agent.
 *
 * @since 1.6
 */

package com.sun.tools.attach;
