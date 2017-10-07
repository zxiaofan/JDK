/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.io;

/**
 * Used to set the Windows error mode at VM initialization time.
 * <p>
 * The error mode decides whether the system will handle specific types of serious errors
 * or whether the process will handle them.
 *
 * @since 1.6
 */
public class Win32ErrorMode {

    // The system does not display the critical-error-handler message box. Instead,
    // the system sends the error to the calling process.
    private static final long SEM_FAILCRITICALERRORS     = 0x0001;

    // The system does not display the general-protection-fault message box. This flag should
    // only be set by debugging applications that handle general protection (GP) faults themselves
    // with an exception handler.
    private static final long SEM_NOGPFAULTERRORBOX      = 0x0002;

    // The system automatically fixes memory alignment faults and makes them invisible
    // to the application. It does this for the calling process and any descendant processes.
    private static final long SEM_NOALIGNMENTFAULTEXCEPT = 0x0004;

    // The system does not display a message box when it fails to find a file. Instead,
    // the error is returned to the calling process.
    private static final long SEM_NOOPENFILEERRORBOX     = 0x8000;

    private Win32ErrorMode() {
    }

    /**
     * Invoke at VM initialization time to disable the critical error message box.
     * <p>
     * The critial error message box is disabled unless the system property
     * {@code sun.io.allowCriticalErrorMessageBox} is set to something other than
     * {@code false}. This includes the empty string.
     * <p>
     * This method does nothing if invoked after VM and class library initialization
     * has completed.
     */
    public static void initialize() {
        if (!jdk.internal.misc.VM.isBooted()) {
            String s = System.getProperty("sun.io.allowCriticalErrorMessageBox");
            if (s == null || s.equals(Boolean.FALSE.toString())) {
                long mode = setErrorMode(0);
                mode |= SEM_FAILCRITICALERRORS;
                setErrorMode(mode);
            }
        }
    }

    // Win32 SetErrorMode
    private static native long setErrorMode(long mode);
}
