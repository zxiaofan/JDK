/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.policy.sourcemodel;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Marek Potociar, Jakub Podlesak
 */
public final class PolicySourceModelContext {

    Map<URI,PolicySourceModel> policyModels;

    /**
     * Private constructor prevents instantiation of the instance from outside of the class
     */
    private PolicySourceModelContext() {
        // nothing to initialize
    }

    private Map<URI,PolicySourceModel> getModels() {
        if (null==policyModels) {
            policyModels = new HashMap<URI,PolicySourceModel>();
        }
        return policyModels;
    }

    public void addModel(final URI modelUri, final PolicySourceModel model) {
        getModels().put(modelUri,model);
    }

    public static PolicySourceModelContext createContext() {
        return new PolicySourceModelContext();
    }

    public boolean containsModel(final URI modelUri) {
        return getModels().containsKey(modelUri);
    }

    PolicySourceModel retrieveModel(final URI modelUri) {
        return getModels().get(modelUri);
    }

    PolicySourceModel retrieveModel(final URI modelUri, final URI digestAlgorithm, final String digest) {
        // TODO: implement
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "PolicySourceModelContext: policyModels = " + this.policyModels;
    }
}
