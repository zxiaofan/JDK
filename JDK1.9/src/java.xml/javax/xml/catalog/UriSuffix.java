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

import java.net.URL;

/**
 * Represents a uriSuffix entry.
 *
 * @since 9
 */
final class UriSuffix extends BaseEntry {
    String uriSuffix;
    URL uri;

    /**
     * Construct a group entry.
     * @param uriSuffix The uriSuffix attribute.
     * @param uri The uri attribute.
     */
    public UriSuffix(String base, String uriSuffix, String uri) {
        super(CatalogEntryType.URISUFFIX, base);
        setURISuffix  (uriSuffix);
        setURI(uri);
    }

    /**
     * Set the uriSuffix attribute.
     * @param uriSuffix The uriSuffix attribute value.
     */
    public void setURISuffix(String uriSuffix) {
        CatalogMessages.reportNPEOnNull("uriSuffix", uriSuffix);
        this.uriSuffix = Normalizer.normalizeURI(uriSuffix);
    }

    /**
     * Set the uri attribute. If the value of the uri attribute is relative, it
     * must be made absolute with respect to the base URI currently in effect.
     * The URI reference should not include a fragment identifier.
     * @param uri The uri attribute value.
     */
    public void setURI(String uri) {
        this.uri = verifyURI("setURI", baseURI, uri);
    }

    /**
     * Get the uriSuffix attribute.
     * @return The uriSuffix
     */
    public String getURISuffix  () {
        return uriSuffix;
    }
    /**
     * Get the uri attribute.
     * @return The uri attribute value.
     */
    public String getURI() {
        return uri.toString();
    }

    /**
     * Try to match the specified systemId with the entry. Return the match if it
     * is successful and the length of the uriSuffix is longer than the longest
     * of any previous match.
     *
     * @param systemId The systemId to be matched.
     * @param currentMatch The length of uriSuffix of previous match if any.
     * @return The replacement URI if the match is successful, null if not.
     */
    @Override
    public String match(String systemId, int currentMatch) {
        if (systemId.endsWith(uriSuffix)) {
            if (currentMatch < uriSuffix.length()) {
                return uri.toString();
            }
        }
        return null;
    }

    @Override
    public String match(String systemId) {
        return match(systemId, 0);
    }

}
