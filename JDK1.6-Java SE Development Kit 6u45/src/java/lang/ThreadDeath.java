/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.lang;

/**
 * An instance of <code>ThreadDeath</code> is thrown in the victim 
 * thread when the <code>stop</code> method with zero arguments in 
 * class <code>Thread</code> is called. 
 * <p>
 * An application should catch instances of this class only if it 
 * must clean up after being terminated asynchronously. If 
 * <code>ThreadDeath</code> is caught by a method, it is important 
 * that it be rethrown so that the thread actually dies. 
 * <p>
 * The top-level error handler does not print out a message if 
 * <code>ThreadDeath</code> is never caught. 
 * <p>
 * The class <code>ThreadDeath</code> is specifically a subclass of 
 * <code>Error</code> rather than <code>Exception</code>, even though 
 * it is a "normal occurrence", because many applications 
 * catch all occurrences of <code>Exception</code> and then discard 
 * the exception. 
 *
 * @author unascribed
 * @version %I%, %G%
 * @see     java.lang.Thread#stop()
 * @since   JDK1.0
 */

public class ThreadDeath extends Error {}
