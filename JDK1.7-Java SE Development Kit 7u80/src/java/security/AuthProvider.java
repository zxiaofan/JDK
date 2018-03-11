/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package java.security;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.CallbackHandler;

/**
 * This class defines login and logout methods for a provider.
 *
 * <p> While callers may invoke <code>login</code> directly,
 * the provider may also invoke <code>login</code> on behalf of callers
 * if it determines that a login must be performed
 * prior to certain operations.
 *
 * @since 1.5
 */
public abstract class AuthProvider extends Provider {

    /**
     * Constructs a provider with the specified name, version number,
     * and information.
     *
     * @param name the provider name.
     * @param version the provider version number.
     * @param info a description of the provider and its services.
     */
    protected AuthProvider(String name, double version, String info) {
        super(name, version, info);
    }

    /**
     * Log in to this provider.
     *
     * <p> The provider relies on a <code>CallbackHandler</code>
     * to obtain authentication information from the caller
     * (a PIN, for example).  If the caller passes a <code>null</code>
     * handler to this method, the provider uses the handler set in the
     * <code>setCallbackHandler</code> method.
     * If no handler was set in that method, the provider queries the
     * <i>auth.login.defaultCallbackHandler</i> security property
     * for the fully qualified class name of a default handler implementation.
     * If the security property is not set,
     * the provider is assumed to have alternative means
     * for obtaining authentication information.
     *
     * @param subject the <code>Subject</code> which may contain
     *          principals/credentials used for authentication,
     *          or may be populated with additional principals/credentials
     *          after successful authentication has completed.
     *          This parameter may be <code>null</code>.
     * @param handler the <code>CallbackHandler</code> used by
     *          this provider to obtain authentication information
     *          from the caller, which may be <code>null</code>
     *
     * @exception LoginException if the login operation fails
     * @exception SecurityException if the caller does not pass a
     *  security check for
     *  <code>SecurityPermission("authProvider.<i>name</i>")</code>,
     *  where <i>name</i> is the value returned by
     *  this provider's <code>getName</code> method
     */
    public abstract void login(Subject subject, CallbackHandler handler)
        throws LoginException;

    /**
     * Log out from this provider.
     *
     * @exception LoginException if the logout operation fails
     * @exception SecurityException if the caller does not pass a
     *  security check for
     *  <code>SecurityPermission("authProvider.<i>name</i>")</code>,
     *  where <i>name</i> is the value returned by
     *  this provider's <code>getName</code> method
     */
    public abstract void logout() throws LoginException;

    /**
     * Set a <code>CallbackHandler</code>.
     *
     * <p> The provider uses this handler if one is not passed to the
     * <code>login</code> method.  The provider also uses this handler
     * if it invokes <code>login</code> on behalf of callers.
     * In either case if a handler is not set via this method,
     * the provider queries the
     * <i>auth.login.defaultCallbackHandler</i> security property
     * for the fully qualified class name of a default handler implementation.
     * If the security property is not set,
     * the provider is assumed to have alternative means
     * for obtaining authentication information.
     *
     * @param handler a <code>CallbackHandler</code> for obtaining
     *          authentication information, which may be <code>null</code>
     *
     * @exception SecurityException if the caller does not pass a
     *  security check for
     *  <code>SecurityPermission("authProvider.<i>name</i>")</code>,
     *  where <i>name</i> is the value returned by
     *  this provider's <code>getName</code> method
     */
    public abstract void setCallbackHandler(CallbackHandler handler);
}
