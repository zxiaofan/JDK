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

package com.sun.tools.internal.xjc;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import javax.xml.catalog.CatalogFeatures;
import javax.xml.catalog.CatalogFeatures.Feature;
import javax.xml.catalog.CatalogManager;
import org.xml.sax.EntityResolver;

/**
 *
 * @author lukas
 */
final class CatalogUtil {

    // Cache CatalogFeatures instance for future usages.
    // Resolve feature is set to "continue" value for backward compatibility.
    private static final CatalogFeatures CATALOG_FEATURES = CatalogFeatures.builder()
                                                    .with(Feature.RESOLVE, "continue")
                                                    .build();

    static EntityResolver getCatalog(EntityResolver entityResolver, File catalogFile, ArrayList<URI> catalogUrls) throws IOException {
        return CatalogManager.catalogResolver(
                CATALOG_FEATURES, catalogUrls.stream().toArray(URI[]::new));
    }
}
