/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt.event;

class NativeLibLoader {

    /**
     * This is copied from java.awt.Toolkit since we need the library
     * loaded in sun.awt.image also:
     *
     * WARNING: This is a temporary workaround for a problem in the
     * way the AWT loads native libraries. A number of classes in this
     * package (sun.awt.image) have a native method, initIDs(),
     * which initializes
     * the JNI field and method ids used in the native portion of
     * their implementation.
     *
     * Since the use and storage of these ids is done by the
     * implementation libraries, the implementation of these method is
     * provided by the particular AWT implementations (for example,
     *  "Toolkit"s/Peer), such as Motif, Microsoft Windows, or Tiny. The
     * problem is that this means that the native libraries must be
     * loaded by the java.* classes, which do not necessarily know the
     * names of the libraries to load. A better way of doing this
     * would be to provide a separate library which defines java.awt.*
     * initIDs, and exports the relevant symbols out to the
     * implementation libraries.
     * 
     * For now, we know it's done by the implementation, and we assume
     * that the name of the library is "awt".  -br.
     */
    static void loadLibraries() {
	java.security.AccessController.doPrivileged(
		new sun.security.action.LoadLibraryAction("awt"));
    }
}
