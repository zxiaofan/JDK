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

package jdk.incubator.http;

import java.util.concurrent.Flow;
import jdk.incubator.http.internal.common.Demand;

/**
 * A {@link Flow.Subscription} wrapping a {@link Demand} instance.
 *
 */
abstract class AbstractSubscription implements Flow.Subscription {

    private final Demand demand = new Demand();

    /**
     * Returns the subscription's demand.
     * @return the subscription's demand.
     */
    protected Demand demand() { return demand; }

}
