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
public class StatsProviderInfo {

    public StatsProviderInfo(String configElement, PluginPoint pp,
                                    String subTreeRoot, Object statsProvider){
        this(configElement, pp, subTreeRoot, statsProvider, null);
    }

    public StatsProviderInfo(String configElement, PluginPoint pp,
                                    String subTreeRoot, Object statsProvider,
                                    String invokerId){
        this.configElement = configElement;
        this.pp = pp;
        this.subTreeRoot = subTreeRoot;
        this.statsProvider = statsProvider;
        this.invokerId = invokerId;
    }

    private String configElement;
    private PluginPoint pp;
    private String subTreeRoot;
    private Object statsProvider;
    private String configLevelStr = null;
    private final String invokerId;

    public String getConfigElement() {
        return configElement;
    }

    public PluginPoint getPluginPoint() {
        return pp;
    }

    public String getSubTreeRoot() {
        return subTreeRoot;
    }

    public Object getStatsProvider() {
        return statsProvider;
    }

    public String getConfigLevel() {
        return configLevelStr;
    }

    public void setConfigLevel(String configLevelStr) {
        this.configLevelStr = configLevelStr;
    }

    public String getInvokerId() {
        return invokerId;
    }

}
