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
public enum PluginPoint {

    SERVER ("server", "server"),
    APPLICATIONS ("applications", "server/applications");

    String name;
    String path;

    PluginPoint(String lname, String lpath) {
        name = lname;
        path = lpath;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
