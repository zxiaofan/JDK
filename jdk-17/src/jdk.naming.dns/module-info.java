/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Provides the implementation of the DNS Java Naming provider.
 *
 * <h2>Environment Properties</h2>
 *
 * <p> The following JNDI environment properties may be used when creating
 * the initial context.
 *
 * <ul>
 *    <li>com.sun.jndi.dns.timeout.initial</li>
 *    <li>com.sun.jndi.dns.timeout.retries</li>
 *  </ul>
 *
 * <p> These properties are used to alter the timeout-related defaults that the
 * DNS provider uses when submitting queries. The DNS provider submits queries
 * using the following exponential backoff algorithm. The provider submits a
 * query to a DNS server and waits for a response to arrive within a timeout
 * period (1 second by default). If it receives no response within the timeout
 * period, it queries the next server, and so on. If the provider receives no
 * response from any server, it doubles the timeout period and repeats the
 * process of submitting the query to each server, up to a maximum number of
 * retries (4 by default).
 *
 * <p> The {@code com.sun.jndi.dns.timeout.initial} property, if set, specifies
 * the number of milliseconds to use as the initial timeout period (i.e., before
 * any doubling). If this property has not been set, the default initial timeout
 * is 1000 milliseconds.
 *
 * <p> The {@code com.sun.jndi.dns.timeout.retries} property, if set, specifies
 * the number of times to retry each server using the exponential backoff
 * algorithm described previously. If this property has not been set, the
 * default number of retries is 4.
 *
 * @provides javax.naming.spi.InitialContextFactory
 *
 * @moduleGraph
 * @since 9
 */
module jdk.naming.dns {
    requires java.naming;

    // temporary export until NamingManager.getURLContext uses services
    exports com.sun.jndi.url.dns to java.naming;

    provides javax.naming.spi.InitialContextFactory with
        com.sun.jndi.dns.DnsContextFactory;
}
