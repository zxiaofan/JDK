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

package com.sun.xml.internal.ws.binding;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

/**
 * Experimental: Utility methods that operate on WebServiceFeatureLists.
 *
 * @author WS Development Team
 */
public class FeatureListUtil {

    /**
     * Merge all features into one list. Returns an empty list if no lists were
     * passed as parameter.
     *
     * @param lists The WebServiceFeatureLists.
     * @return A new WebServiceFeatureList that contains all features.
     */
    public static @NotNull WebServiceFeatureList mergeList(WebServiceFeatureList... lists) {
        final WebServiceFeatureList result = new WebServiceFeatureList();
        for (WebServiceFeatureList list : lists) {
            result.addAll(list);
        }
        return result;
    }

    public static @Nullable <F extends WebServiceFeature> F mergeFeature(final @NotNull Class<F> featureType,
            @Nullable WebServiceFeatureList list1, @Nullable WebServiceFeatureList list2)
            throws WebServiceException {
        final F feature1 = list1 != null ? list1.get(featureType) : null;
        final F feature2 = list2 != null ? list2.get(featureType) : null;
        if (feature1 == null) {
            return feature2;
        }
        else if (feature2 == null) {
            return feature1;
        }
        else {
            if (feature1.equals(feature2)) {
                return feature1;
            }
            else {
                // TODO exception text
                throw new WebServiceException(feature1 + ", " + feature2);
            }
        }
    }

    public static boolean isFeatureEnabled(@NotNull Class<? extends WebServiceFeature> featureType,
            @Nullable WebServiceFeatureList list1, @Nullable WebServiceFeatureList list2)
            throws WebServiceException {
        final WebServiceFeature mergedFeature = mergeFeature(featureType, list1, list2);
        return (mergedFeature != null) && mergedFeature.isEnabled();
    }

}
