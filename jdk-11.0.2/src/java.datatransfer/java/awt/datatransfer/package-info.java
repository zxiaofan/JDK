/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Provides interfaces and classes for transferring data between and within
 * applications. It defines the notion of a "transferable" object, which is an
 * object capable of being transferred between or within applications. An object
 * identifies itself as being transferable by implementing the Transferable
 * interface.
 * <p>
 * It also provides a clipboard mechanism, which is an object that temporarily
 * holds a transferable object that can be transferred between or within an
 * application. The clipboard is typically used for copy and paste operations.
 * Although it is possible to create a clipboard to use within an application,
 * most applications will use the system clipboard to ensure the data can be
 * transferred across applications running on the platform.
 *
 * @since 1.1
 */
package java.awt.datatransfer;
