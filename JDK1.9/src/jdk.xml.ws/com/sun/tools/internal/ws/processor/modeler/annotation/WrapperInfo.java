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

package com.sun.tools.internal.ws.processor.modeler.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  dkohlert
 */
public class WrapperInfo {
    public String wrapperName;

    /** Creates a new instance of FaultInfo */
    public WrapperInfo() {
    }
    public WrapperInfo(String wrapperName) {
        this.wrapperName = wrapperName;
    }

    public void setWrapperName(String wrapperName) {
        this.wrapperName = wrapperName;
    }

    public String getWrapperName() {
        return wrapperName;
    }

}
