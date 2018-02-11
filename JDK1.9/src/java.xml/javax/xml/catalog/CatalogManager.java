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

/**
 * The Catalog Manager manages the creation of XML Catalogs and Catalog Resolvers.
 *
 * @since 9
 */
public final class CatalogManager {
    /**
     * Creating CatalogManager instance is not allowed.
     */
    private CatalogManager() {
    }

    /**
     * Creates a {@code Catalog} object using the specified feature settings and
     * uri(s) to one or more catalog files.
     * <p>
     * If {@code uris} is empty, system property {@code javax.xml.catalog.files},
     * as defined in {@link CatalogFeatures}, will be read to locate the initial
     * list of catalog files.
     * <p>
     * If multiple catalog files are specified through the {@code uris} argument or
     * {@code javax.xml.catalog.files} property, the first entry is considered
     * the main catalog, while others are treated as alternative catalogs after
     * those referenced by the {@code nextCatalog} elements in the main catalog.
     * <p>
     * As specified in
     * <a href="https://www.oasis-open.org/committees/download.php/14809/xml-catalogs.html#s.res.fail">
     * XML Catalogs, OASIS Standard V1.1</a>, if a catalog entry is invalid, it
     * is ignored. In case all entries are invalid, the resulting Catalog object
     * will contain no Catalog elements. Any matching operation using the Catalog
     * will return null.
     *
     * @param features the catalog features
     * @param uris uri(s) to one or more catalogs.
     *
     * @return an instance of a {@code Catalog}
     * @throws IllegalArgumentException if either the URIs are not absolute
     * or do not have a URL protocol handler for the URI scheme
     * @throws CatalogException If an error occurs while parsing the catalog
     * @throws SecurityException if access to the resource is denied by the security manager
     */
    public static Catalog catalog(CatalogFeatures features, URI... uris) {
        Util.validateUrisSyntax(uris);
        CatalogImpl catalog = new CatalogImpl(features, uris);
        catalog.load();
        return catalog;
    }

    /**
     * Creates an instance of a {@code CatalogResolver} using the specified catalog.
     *
     * @param catalog the catalog instance
     * @return an instance of a {@code CatalogResolver}
     */
    public static CatalogResolver catalogResolver(Catalog catalog) {
        if (catalog == null) CatalogMessages.reportNPEOnNull("catalog", null);
        return new CatalogResolverImpl(catalog);
    }

    /**
     * Creates an instance of a {@code CatalogResolver} using the specified feature
     * settings and uri(s) to one or more catalog files.
     * <p>
     * If {@code uris} is empty, system property {@code javax.xml.catalog.files},
     * as defined in {@link CatalogFeatures}, will be read to locate the initial
     * list of catalog files.
     * <p>
     * If multiple catalog files are specified through the {@code uris} argument or
     * {@code javax.xml.catalog.files} property, the first entry is considered
     * the main catalog, while others are treated as alternative catalogs after
     * those referenced by the {@code nextCatalog} elements in the main catalog.
     * <p>
     * As specified in
     * <a href="https://www.oasis-open.org/committees/download.php/14809/xml-catalogs.html#s.res.fail">
     * XML Catalogs, OASIS Standard V1.1</a>, if a catalog entry is invalid, it
     * is ignored. In case all entries are invalid, the resulting CatalogResolver
     * object will contain no valid catalog. Any resolution operation using the
     * resolver therefore will return as no mapping is found. See {@link CatalogResolver}
     * for the behavior when no mapping is found.
     *
     * @param features the catalog features
     * @param uris the uri(s) to one or more catalogs
     *
     * @return an instance of a {@code CatalogResolver}
     * @throws IllegalArgumentException if either the URIs are not absolute
     * or do not have a URL protocol handler for the URI scheme
     * @throws CatalogException If an error occurs while parsing the catalog
     * @throws SecurityException if access to the resource is denied by the security manager
     */
    public static CatalogResolver catalogResolver(CatalogFeatures features, URI... uris) {
        Catalog catalog = catalog(features, uris);
        return new CatalogResolverImpl(catalog);
    }
}
