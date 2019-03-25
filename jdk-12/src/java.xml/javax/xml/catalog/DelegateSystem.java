/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package javax.xml.catalog;

import java.net.URI;

/**
 * Represents a delegateSystem entry.
 *
 * @since 9
 */
final class DelegateSystem extends AltCatalog {
    String systemIdStartString;

    /**
     * Construct a delegateSystem entry.
     * @param systemIdStartString The systemIdStartString attribute.
     * @param catalog The catalog attribute.
     */
    public DelegateSystem(String base, String systemIdStartString, String catalog) {
        super(CatalogEntryType.DELEGATESYSTEM, base);
        setSystemIdStartString(systemIdStartString);
        setCatalog(catalog);
    }

    /**
     * Set the systemIdStartString attribute.
     * @param systemIdStartString The systemIdStartString attribute value.
     */
    public void setSystemIdStartString (String systemIdStartString) {
        CatalogMessages.reportNPEOnNull("systemIdStartString", systemIdStartString);
        this.systemIdStartString = Normalizer.normalizeURI(systemIdStartString);
        setMatchId(this.systemIdStartString);
    }

    /**
     * Get the systemIdStartString attribute.
     * @return The systemIdStartString
     */
    public String getSystemIdStartString () {
        return systemIdStartString;
    }

    /**
     * Try to match the specified systemId with the entry.
     *
     * @param systemId The systemId to be matched.
     * @return The URI of the catalog.
     */
    @Override
    public String match(String systemId) {
        return match(systemId, 0);
    }

    /**
     * Matches the specified publicId with the entry. Return the match if it
     * is successful and the length of the systemIdStartString is longer than the
     * longest of any previous match.
     *
     * @param systemId The systemId to be matched.
     * @param currentMatch The length of systemIdStartString of previous match if any.
     * @return The replacement URI if the match is successful, null if not.
     */
    @Override
    public URI matchURI(String systemId, int currentMatch) {
        if (systemIdStartString.length() <= systemId.length() &&
                systemIdStartString.equals(systemId.substring(0, systemIdStartString.length()))) {
            if (currentMatch < systemIdStartString.length()) {
                return catalogURI;
            }
        }
        return null;
    }

}
