/*
 * Copyright (c) 1996, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi.server;

/**
 * An {@code RMIFailureHandler} can be registered via the
 * {@code RMISocketFactory.setFailureHandler} call. The
 * {@code failure} method of the handler is invoked when the RMI
 * runtime is unable to create a {@code ServerSocket} to listen
 * for incoming calls. The {@code failure} method returns a boolean
 * indicating whether the runtime should attempt to re-create the
 * {@code ServerSocket}.
 *
 * @author      Ann Wollrath
 * @since       1.1
 */
public interface RMIFailureHandler {

    /**
     * The {@code failure} callback is invoked when the RMI
     * runtime is unable to create a {@code ServerSocket} via the
     * {@code RMISocketFactory}. An {@code RMIFailureHandler}
     * is registered via a call to
     * {@code RMISocketFactory.setFailureHandler}.  If no failure
     * handler is installed, the default behavior is to attempt to
     * re-create the ServerSocket.
     *
     * @param ex the exception that occurred during {@code ServerSocket}
     *           creation
     * @return if true, the RMI runtime attempts to retry
     * {@code ServerSocket} creation
     * @see java.rmi.server.RMISocketFactory#setFailureHandler(RMIFailureHandler)
     * @since 1.1
     */
    public boolean failure(Exception ex);

}
