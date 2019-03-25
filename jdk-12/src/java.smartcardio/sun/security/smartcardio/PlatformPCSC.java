/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.smartcardio;

import java.io.File;
import java.io.IOException;

import java.security.AccessController;
import java.security.PrivilegedAction;

import sun.security.util.Debug;

/**
 * Platform specific code and functions for Unix / MUSCLE based PC/SC
 * implementations.
 *
 * @since   1.6
 * @author  Andreas Sterbenz
 */
class PlatformPCSC {

    static final Debug debug = Debug.getInstance("pcsc");

    static final Throwable initException;

    private final static String PROP_NAME = "sun.security.smartcardio.library";

    private final static String LIB1 = "/usr/$LIBISA/libpcsclite.so";
    private final static String LIB2 = "/usr/local/$LIBISA/libpcsclite.so";
    private final static String PCSC_FRAMEWORK = "/System/Library/Frameworks/PCSC.framework/Versions/Current/PCSC";

    PlatformPCSC() {
        // empty
    }

    static {
        initException = AccessController.doPrivileged(new PrivilegedAction<Throwable>() {
            public Throwable run() {
                try {
                    System.loadLibrary("j2pcsc");
                    String library = getLibraryName();
                    if (debug != null) {
                        debug.println("Using PC/SC library: " + library);
                    }
                    initialize(library);
                    return null;
                } catch (Throwable e) {
                    return e;
                }
            }
        });
    }

    // expand $LIBISA to the system specific directory name for libraries
    private static String expand(String lib) {
        int k = lib.indexOf("$LIBISA");
        if (k == -1) {
            return lib;
        }
        String s1 = lib.substring(0, k);
        String s2 = lib.substring(k + 7);
        String libDir;
        if ("64".equals(System.getProperty("sun.arch.data.model"))) {
            if ("SunOS".equals(System.getProperty("os.name"))) {
                libDir = "lib/64";
            } else {
                // assume Linux convention
                libDir = "lib64";
            }
        } else {
            // must be 32-bit
            libDir = "lib";
        }
        String s = s1 + libDir + s2;
        return s;
    }

    private static String getLibraryName() throws IOException {
        // if system property is set, use that library
        String lib = expand(System.getProperty(PROP_NAME, "").trim());
        if (lib.length() != 0) {
            return lib;
        }
        lib = expand(LIB1);
        if (new File(lib).isFile()) {
            // if LIB1 exists, use that
            return lib;
        }
        lib = expand(LIB2);
        if (new File(lib).isFile()) {
            // if LIB2 exists, use that
            return lib;
        }
        lib = PCSC_FRAMEWORK;
        if (new File(lib).isFile()) {
            // if PCSC.framework exists, use that
            return lib;
        }
        throw new IOException("No PC/SC library found on this system");
    }

    private static native void initialize(String libraryName);

    // PCSC constants defined differently under Windows and MUSCLE
    // MUSCLE version
    final static int SCARD_PROTOCOL_T0     =  0x0001;
    final static int SCARD_PROTOCOL_T1     =  0x0002;
    final static int SCARD_PROTOCOL_RAW    =  0x0004;

    final static int SCARD_UNKNOWN         =  0x0001;
    final static int SCARD_ABSENT          =  0x0002;
    final static int SCARD_PRESENT         =  0x0004;
    final static int SCARD_SWALLOWED       =  0x0008;
    final static int SCARD_POWERED         =  0x0010;
    final static int SCARD_NEGOTIABLE      =  0x0020;
    final static int SCARD_SPECIFIC        =  0x0040;

}
