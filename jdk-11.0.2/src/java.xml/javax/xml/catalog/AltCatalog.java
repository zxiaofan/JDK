/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Represents an alternative catalog entry.
 *
 * @since 9
 */
class AltCatalog extends BaseEntry {
    URI catalogURI;

    AltCatalog(CatalogEntryType type, String base) {
        super(type, base);
    }

    /**
     * Set the catalog attribute. If the value of the catalog attribute is relative, it
     * must be made absolute with respect to the base URI currently in effect.
     *
     * @param catalog The catalog attribute value.
     * @throws CatalogException if converting to catalog URI failed
     */
    void setCatalog(String catalog) {
        URL url = verifyURI("catalog", baseURI, catalog);
        try {
            catalogURI = url.toURI();
        } catch (URISyntaxException ex) {
            CatalogMessages.reportRunTimeError(CatalogMessages.ERR_OTHER, ex);
        }

    }

    /**
     * Returns the catalog attribute as a URI String.
     * @return The value of the catalog attribute
     */
    String getCatalogId() {
        return catalogURI.toASCIIString();
    }

    /**
     * Returns the catalog attribute as a URI.
     * @return The value of the catalog attribute
     */
    URI getCatalogURI() {
        return catalogURI;
    }

    /**
     * Matches the specified id with the entry. Returns the match if it
     * is successful and the length of the start String is longer than the
     * longest of any previous match.
     *
     * @param id The id to be matched.
     * @param currentMatch The length of start String of previous match if any.
     * @return The replacement URI if the match is successful, null if not.
     */
    public URI matchURI(String id, int currentMatch) {
        return null;
    }
}
