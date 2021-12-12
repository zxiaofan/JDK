/*
 * Copyright (c) 2002, 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.dns;

import java.util.List;

/**
 * The configuration of the client resolver.
 *
 * <p>A ResolverConfiguration is a singleton that represents the
 * configuration of the client resolver. The ResolverConfiguration
 * is opened by invoking the {@link #open() open} method.
 *
 * @since 1.4
 */

public abstract class ResolverConfiguration {

    private static final Object lock = new Object();

    private static ResolverConfiguration provider;

    protected ResolverConfiguration() { }

    /**
     * Opens the resolver configuration.
     *
     * @return the resolver configuration
     */
    public static ResolverConfiguration open() {
        synchronized (lock) {
            if (provider == null) {
                provider = new sun.net.dns.ResolverConfigurationImpl();
            }
            return provider;
        }
    }

    /**
     * Returns a list corresponding to the domain search path. The
     * list is ordered by the search order used for host name lookup.
     * Each element in the list returns a {@link java.lang.String}
     * containing a domain name or suffix.
     *
     * @return list of domain names
     */
    public abstract List<String> searchlist();

    /**
     * Returns a list of name servers used for host name lookup.
     * Each element in the list returns a {@link java.lang.String}
     * containing the textual representation of the IP address of
     * the name server.
     *
     * @return list of the name servers
     */
    public abstract List<String> nameservers();


    /**
     * Options representing certain resolver variables of
     * a {@link ResolverConfiguration}.
     */
    public abstract static class Options {

        /**
         * Returns the maximum number of attempts the resolver
         * will connect to each name server before giving up
         * and returning an error.
         *
         * @return the resolver attempts value or -1 is unknown
         */
        public int attempts() {
            return -1;
        }

        /**
         * Returns the basic retransmit timeout, in milliseconds,
         * used by the resolver. The resolver will typically use
         * an exponential backoff algorithm where the timeout is
         * doubled for every retransmit attempt. The basic
         * retransmit timeout, returned here, is the initial
         * timeout for the exponential backoff algorithm.
         *
         * @return the basic retransmit timeout value or -1
         *         if unknown
         */
        public int retrans() {
            return -1;
        }
    }

    /**
     * Returns the {@link #Options} for the resolver.
     *
     * @return options for the resolver
     */
    public abstract Options options();
}
