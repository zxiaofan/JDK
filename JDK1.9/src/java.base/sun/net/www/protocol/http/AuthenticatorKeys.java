/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.net.Authenticator;
import java.util.concurrent.atomic.AtomicLong;

/**
 *  A class used to tie a key to an authenticator instance.
 */
public final class AuthenticatorKeys {
    private AuthenticatorKeys() {
        throw new InternalError("Trying to instantiate static class");
    }

    public static final String DEFAULT = "default";
    private static final AtomicLong IDS = new AtomicLong();

    public static String computeKey(Authenticator a) {
        return System.identityHashCode(a) + "-" + IDS.incrementAndGet()
               + "@" + a.getClass().getName();
    }

    /**
     * Returns a key for the given authenticator.
     *
     * @param authenticator The authenticator; {@code null} should be
     *        passed when the {@linkplain
     *        Authenticator#setDefault(java.net.Authenticator) default}
     *        authenticator is meant.
     * @return A key for the given authenticator, {@link #DEFAULT} for
     *         {@code null}.
     */
    public static String getKey(Authenticator authenticator) {
        if (authenticator == null) {
            return DEFAULT;
        }
        return authenticatorKeyAccess.getKey(authenticator);
    }

    @FunctionalInterface
    public interface AuthenticatorKeyAccess {
        public String getKey(Authenticator a);
    }

    private static AuthenticatorKeyAccess authenticatorKeyAccess;
    public static void setAuthenticatorKeyAccess(AuthenticatorKeyAccess access) {
        if (authenticatorKeyAccess == null && access != null) {
            authenticatorKeyAccess = access;
        }
    }

}
