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

import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.WebServiceException;

/**
 * Validates a list of {@link WebServiceFeature} instances when they are added to
 * the client or service binding.
 * <p>
 * {@link WebServiceFeature} classes may specify validator beans using {@link FeatureListValidatorAnnotation}.
 * <p>
 * Current behavior will allow runtime components to add features to the binding after initial validation; however,
 * this behavior is discouraged and will not be supported in later releases of the reference
 * implementation.
 *
 * @since 2.2.8
 * @see FeatureListValidatorAnnotation
 */
public interface FeatureListValidator {
    /**
     * Validates feature list.  Implementations should throw {@link WebServiceException} if the
     * list of features is invalid.  Implementations may add features to the list or make other
     * changes; however, only validators belonging to features on the original list will be
     * invoked.
     *
     * @param list feature list
     */
    public void validate(WSFeatureList list);
}
