/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect;

public interface Filterable extends LockableResource {
    public Object getData();
    public int getContentWidth();
    public int getContentHeight();
    public void setContentWidth(int contentW);
    public void setContentHeight(int contentH);
    public int getMaxContentWidth();
    public int getMaxContentHeight();
    public int getPhysicalWidth();
    public int getPhysicalHeight();
    public float getPixelScale();
    public void flush();
}
