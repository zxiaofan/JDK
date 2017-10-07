/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.org.jvnet.mimepull;

import java.util.concurrent.ScheduledExecutorService;

public abstract class CleanUpExecutorFactory {
    private static final String DEFAULT_PROPERTY_NAME = CleanUpExecutorFactory.class
            .getName();

    protected CleanUpExecutorFactory() {
    }

    public static CleanUpExecutorFactory newInstance() {
        try {
            return (CleanUpExecutorFactory) FactoryFinder.find(DEFAULT_PROPERTY_NAME);
        } catch (RuntimeException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public abstract ScheduledExecutorService getScheduledExecutorService();
}
