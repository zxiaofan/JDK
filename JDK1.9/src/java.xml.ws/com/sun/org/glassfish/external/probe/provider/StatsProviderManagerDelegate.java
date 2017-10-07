/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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



package com.sun.org.glassfish.external.probe.provider;

/**
 *
 * @author abbagani
 */
public interface StatsProviderManagerDelegate {

   public void register(StatsProviderInfo spInfo);
   public void unregister(Object statsProvider);
   public boolean hasListeners(String probeStr);

}
