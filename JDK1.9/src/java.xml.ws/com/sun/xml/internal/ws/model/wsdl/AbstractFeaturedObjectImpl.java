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

package com.sun.xml.internal.ws.model.wsdl;import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLFeaturedObject;
import com.sun.xml.internal.ws.binding.WebServiceFeatureList;

import javax.xml.stream.XMLStreamReader;
import javax.xml.ws.WebServiceFeature;

/**
 * @author Kohsuke Kawaguchi
 */
abstract class AbstractFeaturedObjectImpl extends AbstractExtensibleImpl implements WSDLFeaturedObject {
    protected WebServiceFeatureList features;

    protected AbstractFeaturedObjectImpl(XMLStreamReader xsr) {
        super(xsr);
    }
    protected AbstractFeaturedObjectImpl(String systemId, int lineNumber) {
        super(systemId, lineNumber);
    }

    public final void addFeature(WebServiceFeature feature) {
        if (features == null)
            features = new WebServiceFeatureList();

        features.add(feature);
    }

    public @NotNull WebServiceFeatureList getFeatures() {
        if(features == null)
            return new WebServiceFeatureList();
        return features;
    }

    public final WebServiceFeature getFeature(String id) {
        if (features != null) {
            for (WebServiceFeature f : features) {
                if (f.getID().equals(id))
                    return f;
            }
        }

        return null;
    }

    @Nullable
    public <F extends WebServiceFeature> F getFeature(@NotNull Class<F> featureType) {
        if(features==null)
            return null;
        else
            return features.get(featureType);
    }
}
