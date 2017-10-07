/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import java.io.File;

class DispmanPlatformFactory extends NativePlatformFactory {

    @Override
    protected boolean matches() {
        return new File("/opt/vc/lib/libbcm_host.so").exists();
    }

    @Override
    protected int getMajorVersion() {
        return 1;
    }

    @Override
    protected int getMinorVersion() {
        return 0;
    }

    @Override
    protected NativePlatform createNativePlatform() {
        return new DispmanPlatform();
    }

}
