/*
 * Copyright (c) 2002, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.ch;


// Signalling operations on native threads


class NativeThread {

    static long current() {
        // return 0 to ensure that async close of blocking sockets will close
        // the underlying socket.
        return 0;
    }

    static void signal(long nt) { }

}
