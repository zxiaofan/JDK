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
 * Represents a delegatePublic entry.
 *
 * @since 9
 */
final class DelegatePublic extends AltCatalog {
    String publicIdStartString;

    /**
     * Construct a delegatePublic entry.
     * @param startString The publicIdStartString attribute.
     * @param catalog The catalog attribute.
     */
    public DelegatePublic(String base, String startString, String catalog) {
        super(CatalogEntryType.DELEGATEPUBLIC, base);
        setPublicIdStartString(startString);
        setCatalog(catalog);
    }

    /**
     * Set the publicIdStartString attribute.
     * @param startString The publicIdStartString attribute value.
     */
    public void setPublicIdStartString (String startString) {
        CatalogMessages.reportNPEOnNull("publicIdStartString", startString);
        this.publicIdStartString = Normalizer.normalizePublicId(startString);
        setMatchId(publicIdStartString);
    }

    /**
     * Get the publicIdStartString attribute.
     * @return The publicIdStartString
     */
    public String getPublicIdStartString () {
        return publicIdStartString;
    }

    /**
     * Try to match the specified publicId with the entry.
     *
     * @param publicId The publicId to be matched.
     * @return The URI of the catalog.
     */
    @Override
    public String match(String publicId) {
        return match(publicId, 0);
    }

    /**
     * Try to match the specified publicId with the entry. Return the match if it
     * is successful and the length of the publicIdStartString is longer than the
     * longest of any previous match.
     *
     * @param publicId The publicId to be matched.
     * @param currentMatch The length of publicIdStartString of previous match if any.
     * @return The replacement URI if the match is successful, null if not.
     */
    @Override
    public URI matchURI(String publicId, int currentMatch) {
        if (publicIdStartString.length() <= publicId.length() &&
                publicIdStartString.equals(publicId.substring(0, publicIdStartString.length()))) {
            if (currentMatch < publicIdStartString.length()) {
                return catalogURI;
            }
        }
        return null;
    }

}
