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

/**
 *
 * Provides the classes for implementing
 * <a href="https://www.oasis-open.org/committees/download.php/14809/xml-catalogs.html">
 *     XML Catalogs OASIS Standard V1.1, 7 October 2005</a>.
 *
 * <p>
 * The Catalog API defines a standard solution for resolving external resources
 * referenced by XML documents. It is fully supported by the XML Processors
 * allowing application developers to configure a catalog through an XML processor
 * or system property or the jaxp.properties file to take advantage of the feature.
 * <p>
 * The XML Catalog API defines the following interfaces:
 * <ul>
 *     <li>{@link Catalog} -- The {@link Catalog} interface represents an entity
 *         catalog as defined by the Catalog standard. A {@link Catalog} object
 *         is immutable. Once created, it can be used to find matches in a
 *         {@code system}, {@code public} or {@code uri} entry.
 *         A custom resolver implementation may find it useful for locating local
 *         resources through a catalog.
 *     </li>
 *     <li>{@link CatalogFeatures} -- The {@link CatalogFeatures} class holds all
 *         of the features and properties the Catalog API supports, including
 *         {@code javax.xml.catalog.files}, {@code javax.xml.catalog.defer},
 *         {@code javax.xml.catalog.prefer}, and {@code javax.xml.catalog.resolve}.
 *     </li>
 *     <li>{@link CatalogManager} -- The {@link CatalogManager} class manages the
 *         creation of XML catalogs and catalog resolvers.
 *     </li>
 *     <li>{@link CatalogResolver} -- The {@link CatalogResolver} class is a
 *         {@code Catalog} resolver that implements {@link org.xml.sax.EntityResolver},
 *         {@link javax.xml.stream.XMLResolver}, {@link org.w3c.dom.ls.LSResourceResolver},
 *         and {@link javax.xml.transform.URIResolver}, and resolves external
 *         references using catalogs.
 *     </li>
 * </ul>
 * <p>
 * Unless otherwise noted, passing a null argument to
 * a constructor or method in any class or interface in this package will
 * cause a {@code NullPointerException} to be thrown.
 *
 * @since 9
 *
 */

package javax.xml.catalog;
