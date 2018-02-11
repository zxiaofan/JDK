/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.util;

import java.util.Optional;

/**
 * A domain that is registered under a "public suffix". The public suffix is
 * a top-level domain under which names can be registered. For example,
 * "com" and "co.uk" are public suffixes, and "example.com" and "example.co.uk"
 * are registered domains.
 * <p>
 * The primary purpose of this class is to determine if domains are safe to
 * use in various use-cases.
 */
public interface RegisteredDomain {

    public enum Type {
        /**
         * An ICANN registered domain.
         */
        ICANN,
        /**
         * A private registered domain.
         */
        PRIVATE
    }

    /**
     * Returns the name of the registered domain.
     *
     * @return the name of the registered domain
     */
    String name();

    /**
     * Returns the type of the registered domain.
     *
     * @return the type of the registered domain
     */
    Type type();

    /**
     * Returns the public suffix of the registered domain.
     *
     * @return the public suffix of the registered domain
     */
    String publicSuffix();

    /**
     * Returns an {@code Optional<RegisteredDomain>} representing the
     * registered part of the specified domain.
     *
     * {@implNote}
     * The default implementation is based on the legacy
     * {@code sun.net.RegisteredDomain} class which is no longer maintained.
     * It should be updated or replaced with an appropriate implementation.
     *
     * @param domain the domain name
     * @return an {@code Optional<RegisteredDomain>}; the {@code Optional} is
     *    empty if the domain is unknown or not registerable
     * @throws NullPointerException if domain is null
     */
    public static Optional<RegisteredDomain> from(String domain) {
        if (domain == null) {
            throw new NullPointerException();
        }
        return Optional.ofNullable(sun.net.RegisteredDomain.registeredDomain(domain));
    }
}
