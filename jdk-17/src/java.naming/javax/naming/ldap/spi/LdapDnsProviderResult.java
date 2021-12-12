/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming.ldap.spi;

import java.util.List;

/**
 * The result of a DNS lookup for an LDAP URL.
 *
 * <p> This class is used by an {@link LdapDnsProvider} to return the result
 * of a DNS lookup for a given LDAP URL. The result consists of a domain name
 * and its associated LDAP server endpoints.
 *
 * <p> A {@code null} {@code domainName} is equivalent to and represented
 * by an empty string.
 *
 * @since 12
 */
public final class LdapDnsProviderResult {

    private final String domainName;
    private final List<String> endpoints;

    /**
     * Construct an LdapDnsProviderResult consisting of a resolved domain name
     * and the LDAP server endpoints that serve the domain.
     *
     * @param domainName    the resolved domain name; can be null.
     * @param endpoints     the possibly empty list of resolved LDAP server
     *                      endpoints
     *
     * @throws NullPointerException   if {@code endpoints} contains {@code null}
     *                                elements.
     * @throws ClassCastException     if {@code endpoints} contains non-
     *                                {@code String} elements.
     */
    public LdapDnsProviderResult(String domainName, List<String> endpoints) {
        this.domainName = (domainName == null) ? "" : domainName;
        this.endpoints = List.copyOf(endpoints);
    }

    /**
     * Returns the domain name resolved from the LDAP URL. This method returns
     * the empty string if the {@code LdapDnsProviderResult} is created with a
     * null domain name.
     *
     * @return  the resolved domain name
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Returns the possibly empty list of individual server endpoints resolved
     * from the LDAP URL.
     *
     * @return  a possibly empty unmodifiable {@link List} containing the
     *          resolved LDAP server endpoints
     */
    public List<String> getEndpoints() {
        return endpoints;
    }
}
