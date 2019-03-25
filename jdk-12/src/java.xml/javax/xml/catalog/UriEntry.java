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

import java.net.URL;

/**
 * Represents a uri entry.
 *
 * @since 9
 */
final class UriEntry extends BaseEntry {
    String name;
    URL uri;

    /**
     * Construct a uri entry.
     * @param name The name attribute.
     * @param uri The uri attribute.
     */
    public UriEntry(String base, String name, String uri) {
        super(CatalogEntryType.URI, base);
        setName(name);
        setURI(uri);
    }

    /**
     * Set the name attribute.
     * @param name The name attribute value.
     */
    public void setName(String name) {
        CatalogMessages.reportNPEOnNull("name", name);
        if (name.startsWith(Util.PUBLICID_PREFIX) || name.startsWith(Util.PUBLICID_PREFIX_ALT)) {
            this.name = Normalizer.normalizePublicId(name);
        } else {
            this.name = Normalizer.normalizeURI(name);
        }
    }

    /**
     * Set the uri attribute. If the value of the uri attribute is relative, it
     * must be made absolute with respect to the base URI currently in effect.
     *
     * @param uri The uri attribute value.
     */
    public void setURI(String uri) {
        this.uri = verifyURI("setURI", baseURI, uri);
    }

    /**
     * Get the name attribute.
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the uri attribute.
     * @return The uri attribute value.
     */
    public URL getURI() {
        return uri;
    }

    @Override
    public String match(String name) {
        if (this.name.equals(name)) {
            return uri.toString();
        }
        return null;
    }
}
