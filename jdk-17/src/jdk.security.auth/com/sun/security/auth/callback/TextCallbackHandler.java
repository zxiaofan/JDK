/*
 * Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.auth.callback;

/* JAAS imports */
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;        // javadoc
import javax.security.auth.callback.PasswordCallback;    // javadoc
import javax.security.auth.callback.UnsupportedCallbackException;

/* Java imports */
import java.io.IOException;

import sun.security.util.ConsoleCallbackHandler;

/**
 * Prompts and reads from the command line for answers to authentication
 * questions.
 * This can be used by a JAAS application to instantiate a
 * CallbackHandler
 * @see javax.security.auth.callback
 */

public class TextCallbackHandler implements CallbackHandler {
    private final CallbackHandler consoleHandler;

    /**
     * Creates a callback handler that prompts and reads from the
     * command line for answers to authentication questions.
     * This can be used by JAAS applications to instantiate a
     * CallbackHandler.
     */
    public TextCallbackHandler() {
        this.consoleHandler = new ConsoleCallbackHandler();
    }

    /**
     * Handles the specified set of callbacks.
     *
     * @param callbacks the callbacks to handle
     * @throws IOException if an input or output error occurs.
     * @throws UnsupportedCallbackException if the callback is not an
     * instance of NameCallback or PasswordCallback
     */
    public void handle(Callback[] callbacks)
        throws IOException, UnsupportedCallbackException
    {
        // delegate to console handler
        consoleHandler.handle(callbacks);
    }
}
