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
 * Represents a public entry.
 *
 * @since 9
 */
final class PublicEntry extends BaseEntry {
    String publicId;
    URL uri;

    /**
     * Construct a public entry.
     * @param publicId The publicId attribute.
     * @param uri The uri attribute.
     */
    public PublicEntry(String base, String publicId, String uri) {
        super(CatalogEntryType.PUBLIC, base);
        setPublicId(publicId);
        setURI(uri);
    }

    /**
     * Set the publicId attribute.
     * @param publicId The publicId attribute value.
     */
    public void setPublicId(String publicId) {
        CatalogMessages.reportNPEOnNull("publicId", publicId);
        this.publicId = Normalizer.normalizePublicId(publicId);
    }

    /**
     * Set the uri attribute. If the value of the uri attribute is relative, it
     * must be made absolute with respect to the base URI currently in effect.
     * The URI reference should not include a fragment identifier.
     * @param uri The uri attribute value.
     */
    public void setURI(String uri) {
        this.uri = verifyURI("uri", baseURI, uri);
    }

    /**
     * Get the publicId attribute.
     * @return The publicId
     */
    public String getPublicId() {
        return publicId;
    }
    /**
     * Get the uri attribute.
     * @return The uri attribute value.
     */
    public URL getURI() {
        return uri;
    }

    @Override
    public String match(String publicId) {
        if (this.publicId.equals(publicId)) {
            return uri.toString();
        }
        return null;
    }

}
