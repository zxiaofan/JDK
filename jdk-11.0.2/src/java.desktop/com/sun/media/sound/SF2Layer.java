/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.media.sound;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SoundbankResource;

/**
 * Soundfont layer.
 *
 * @author Karl Helgason
 */
public final class SF2Layer extends SoundbankResource {

    String name = "";
    SF2GlobalRegion globalregion = null;
    List<SF2LayerRegion> regions = new ArrayList<>();

    public SF2Layer(SF2Soundbank soundBank) {
        super(soundBank, null, null);
    }

    public SF2Layer() {
        super(null, null, null);
    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SF2LayerRegion> getRegions() {
        return regions;
    }

    public SF2GlobalRegion getGlobalRegion() {
        return globalregion;
    }

    public void setGlobalZone(SF2GlobalRegion zone) {
        globalregion = zone;
    }

    @Override
    public String toString() {
        return "Layer: " + name;
    }
}
