/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.util.xml;

import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.server.ServerRtException;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import javax.xml.catalog.CatalogFeatures;
import javax.xml.catalog.CatalogFeatures.Feature;
import javax.xml.catalog.CatalogManager;
import javax.xml.ws.WebServiceException;
import org.xml.sax.EntityResolver;

/**
 *
 * @author lukas
 */
public class XmlCatalogUtil {

    // Cache CatalogFeatures instance for future usages.
    // Resolve feature is set to "continue" value for backward compatibility.
    private static final CatalogFeatures CATALOG_FEATURES
            = CatalogFeatures.builder().with(Feature.RESOLVE, "continue").build();

    /**
     * Gets an EntityResolver using XML catalog
     *
     * @param catalogUrl
     * @return
     */
    public static EntityResolver createEntityResolver(@Nullable URL catalogUrl) {
        ArrayList<URL> urlsArray = new ArrayList<>();
        EntityResolver er;
        if (catalogUrl != null) {
            urlsArray.add(catalogUrl);
        }
        try {
            er = createCatalogResolver(urlsArray);
        } catch (Exception e) {
            throw new ServerRtException("server.rt.err", e);
        }
        return er;
    }

    /**
     * Gets a default EntityResolver for catalog at META-INF/jaxws-catalog.xml
     *
     * @return
     */
    public static EntityResolver createDefaultCatalogResolver() {
        EntityResolver er;
        try {
            /**
             * Gets a URLs for catalog defined at META-INF/jaxws-catalog.xml
             */
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> catalogEnum;
            if (cl == null) {
                catalogEnum = ClassLoader.getSystemResources("META-INF/jax-ws-catalog.xml");
            } else {
                catalogEnum = cl.getResources("META-INF/jax-ws-catalog.xml");
            }
            er = createCatalogResolver(Collections.list(catalogEnum));
        } catch (Exception e) {
            throw new WebServiceException(e);
        }

        return er;
    }

    /**
     * Instantiate catalog resolver using new catalog API (javax.xml.catalog.*)
     * added in JDK9. Usage of new API removes dependency on internal API
     * (com.sun.org.apache.xml.internal) for modular runtime.
     */
    private static EntityResolver createCatalogResolver(ArrayList<URL> urls) throws Exception {
        // Prepare array of catalog URIs
        URI[] uris = urls.stream()
                             .map(u -> URI.create(u.toExternalForm()))
                             .toArray(URI[]::new);

        //Create CatalogResolver with new JDK9+ API
        return (EntityResolver) CatalogManager.catalogResolver(CATALOG_FEATURES, uris);
    }

}
