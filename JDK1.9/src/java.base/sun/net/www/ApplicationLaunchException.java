/*
 * Copyright (c) 1996, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www;

/**
 * An exception thrown by the MimeLauncher when it is unable to launch
 * an external content viewer.
 *
 * @author      Sunita Mani
 */

public class ApplicationLaunchException extends Exception {
    private static final long serialVersionUID = -4782286141289536883L;

    public ApplicationLaunchException(String reason) {
        super(reason);
    }
}
