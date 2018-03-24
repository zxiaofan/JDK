/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api;import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.xml.ws.WebServiceFeature;

/**
 * Read-only list of {@link WebServiceFeature}s.
 *
 * @author Kohsuke Kawaguchi
 */
public interface WSFeatureList extends Iterable<WebServiceFeature> {
    /**
     * Checks if a particular {@link WebServiceFeature} is enabled.
     *
     * @return
     *      true if enabled.
     */
    boolean isEnabled(@NotNull Class<? extends WebServiceFeature> feature);

    /**
     * Gets a {@link WebServiceFeature} of the specific type.
     *
     * @param featureType
     *      The type of the feature to retrieve.
     * @return
     *      If the feature is present and enabled, return a non-null instance.
     *      Otherwise null.
     */
    @Nullable <F extends WebServiceFeature> F get(@NotNull Class<F> featureType);

    /**
     * Obtains all the features in the array.
      */
    @NotNull WebServiceFeature[] toArray();

    /**
     * Merges the extra features that are not already set on binding.
     * i.e, if a feature is set already on binding through some other API
     * the corresponding wsdlFeature is not set.
     *
     * @param features          Web Service features that need to be merged with already configured features.
     * @param reportConflicts   If true, checks if the feature setting in WSDL (wsdl extension or
     *                          policy configuration) conflicts with feature setting in Deployed Service and
     *                          logs warning if there are any conflicts.
     */
    void mergeFeatures(@NotNull WebServiceFeature[] features, boolean reportConflicts);

   /**
    * Merges the extra features that are not already set on binding.
    * i.e, if a feature is set already on binding through some other API
    * the corresponding wsdlFeature is not set.
    *
    * @param features          Web Service features that need to be merged with already configured features.
    * @param reportConflicts   If true, checks if the feature setting in WSDL (wsdl extension or
    *                          policy configuration) conflicts with feature setting in Deployed Service and
    *                          logs warning if there are any conflicts.
    */
   void mergeFeatures(@NotNull Iterable<WebServiceFeature> features, boolean reportConflicts);
}
