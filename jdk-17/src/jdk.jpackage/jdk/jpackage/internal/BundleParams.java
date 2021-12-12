/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jpackage.internal;

import java.util.HashMap;
import java.util.Map;
import static jdk.jpackage.internal.StandardBundlerParam.APP_NAME;

public class BundleParams {

    protected final Map<String, ? super Object> params;

    /**
     * create a new bundle with all default values
     */
    public BundleParams() {
        params = new HashMap<>();
    }

    /**
     * Create a bundle params with a copy of the params
     * @param params map of initial parameters to be copied in.
     */
    public BundleParams(Map<String, ?> params) {
        this.params = new HashMap<>(params);
    }

    public void addAllBundleParams(Map<String, ? super Object> params) {
        this.params.putAll(params);
    }

    // NOTE: we do not care about application parameters here
    // as they will be embeded into jar file manifest and
    // java launcher will take care of them!

    public Map<String, ? super Object> getBundleParamsAsMap() {
        return new HashMap<>(params);
    }

    public String getName() {
        return APP_NAME.fetchFrom(params);
    }

    private void putUnlessNull(String param, Object value) {
        if (value != null) {
            params.put(param, value);
        }
    }
}
