/*
 * Copyright (c) 2002, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.annotation.Native;

// Constants for reporting I/O status

public final class IOStatus {

    private IOStatus() { }

    @Native public static final int EOF = -1;              // End of file
    @Native public static final int UNAVAILABLE = -2;      // Nothing available (non-blocking)
    @Native public static final int INTERRUPTED = -3;      // System call interrupted
    @Native public static final int UNSUPPORTED = -4;      // Operation not supported
    @Native public static final int THROWN = -5;           // Exception thrown in JNI code
    @Native public static final int UNSUPPORTED_CASE = -6; // This case not supported

    // The following two methods are for use in try/finally blocks where a
    // status value needs to be normalized before being returned to the invoker
    // but also checked for illegal negative values before the return
    // completes, like so:
    //
    //     int n = 0;
    //     try {
    //         begin();
    //         n = op(fd, buf, ...);
    //         return IOStatus.normalize(n);    // Converts UNAVAILABLE to zero
    //     } finally {
    //         end(n > 0);
    //         assert IOStatus.check(n);        // Checks other negative values
    //     }
    //

    public static int normalize(int n) {
        if (n == UNAVAILABLE)
            return 0;
        return n;
    }

    public static boolean check(int n) {
        return (n >= UNAVAILABLE);
    }

    public static long normalize(long n) {
        if (n == UNAVAILABLE)
            return 0;
        return n;
    }

    public static boolean check(long n) {
        return (n >= UNAVAILABLE);
    }

    // Return true iff n is not one of the IOStatus values
    public static boolean checkAll(long n) {
        return ((n > EOF) || (n < UNSUPPORTED_CASE));
    }

    /**
     * Returns true if the error code is UNAVAILABLE or INTERRUPTED, the
     * error codes to indicate that an I/O operation can be retried.
     */
    static boolean okayToRetry(long n) {
        return (n == IOStatus.UNAVAILABLE) || (n == IOStatus.INTERRUPTED);
    }

}
