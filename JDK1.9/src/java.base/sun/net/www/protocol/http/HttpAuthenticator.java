/*
 * Copyright (c) 1996, 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www.protocol.http;

import java.net.URL;

/**
 * An interface for all objects that implement HTTP authentication.
 * See the HTTP spec for details on how this works in general.
 * A single class or object can implement an arbitrary number of
 * authentication schemes.
 *
 * @author David Brown
 *
 * @deprecated -- use java.net.Authenticator instead
 * @see java.net.Authenticator
 */
//
// REMIND:  Unless compatibility with sun.* API's from 1.2 to 2.0 is
// a goal, there's no reason to carry this forward into JDK 2.0.
@Deprecated
public interface HttpAuthenticator {


    /**
     * Indicate whether the specified authentication scheme is
     * supported.  In accordance with HTTP specifications, the
     * scheme name should be checked in a case-insensitive fashion.
     */

    boolean schemeSupported (String scheme);

    /**
     * Returns the String that should be included in the HTTP
     * <B>Authorization</B> field.  Return null if no info was
     * supplied or could be found.
     * <P>
     * Example:
     * <pre>{@code
     * --> GET http://www.authorization-required.com/ HTTP/1.0
     * <-- HTTP/1.0 403 Unauthorized
     * <-- WWW-Authenticate: Basic realm="WallyWorld"
     * call schemeSupported("Basic"); (return true)
     * call authString(u, "Basic", "WallyWorld", null);
     *   return "QWadhgWERghghWERfdfQ=="
     * --> GET http://www.authorization-required.com/ HTTP/1.0
     * --> Authorization: Basic QWadhgWERghghWERfdfQ==
     * <-- HTTP/1.0 200 OK}
     * <B> YAY!!!</B>
     * </pre>
     */

    public String authString (URL u, String scheme, String realm);

}
