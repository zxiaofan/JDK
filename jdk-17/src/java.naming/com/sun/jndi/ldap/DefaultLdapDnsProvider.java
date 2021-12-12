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

package com.sun.jndi.ldap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.naming.NamingException;
import javax.naming.ldap.spi.LdapDnsProviderResult;

public class DefaultLdapDnsProvider {

    public Optional<LdapDnsProviderResult> lookupEndpoints(String url,
                                                           Map<?,?> env)
            throws NamingException
    {
        if (url == null || env == null) {
            throw new NullPointerException();
        }

        String domainName;
        List<String> endpoints = new ArrayList<>();
        LdapURL ldapUrl = new LdapURL(url);
        String dn = ldapUrl.getDN();
        String host = ldapUrl.getHost();
        int port = ldapUrl.getPort();
        String[] hostports;

        // handle a URL with no hostport (ldap:/// or ldaps:///)
        // locate the LDAP service using the URL's distinguished name
        if (host == null
                && port == -1
                && dn != null
                && (domainName = ServiceLocator.mapDnToDomainName(dn)) != null
                && (hostports = ServiceLocator.getLdapService(domainName, env)) != null) {
            // Generate new URLs that include the discovered hostports.
            // Reuse the original URL scheme.
            String scheme = ldapUrl.getScheme() + "://";
            String query = ldapUrl.getQuery();
            String urlSuffix = ldapUrl.getPath() + (query != null ? query : "");
            for (String hostPort : hostports) {
                // the hostports come from the DNS SRV records
                // we assume the SRV record is scheme aware
                endpoints.add(scheme + hostPort + urlSuffix);
            }
        } else {
            // we don't have enough information to set the domain name
            // correctly
            domainName = "";
            endpoints.add(url);
        }

        LdapDnsProviderResult res = new LdapDnsProviderResult(domainName, endpoints);
        if (res.getEndpoints().isEmpty() && res.getDomainName().isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(res);
        }
    }
}
