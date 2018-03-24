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

package com.sun.xml.internal.ws.api;

/**
 * Features, Providers, and JWS implementations can implement this interface to
 * receive a callback allowing them to modify the features enabled for a client
 * or endpoint binding.
 *
 * Implementations of this interface can make any changes they like to the set of
 * features; however, general best practice is that implementations should not
 * override features specified by the developer.  For instance, a Feature object
 * for WS-ReliableMessaging might use this interface to automatically enable
 * WS-Addressing (by adding the AddressingFeature), but not modify addressing if the
 * user had already specified a different addressing version.
 *
 * @since 2.2.6
 * @deprecated use {@link FeatureListValidatorAnnotation}
 */
public interface ImpliesWebServiceFeature {
        /**
         * Callback that may inspect the current feature list and add additional features
         * @param list Feature list
         */
        public void implyFeatures(WSFeatureList list);
}
