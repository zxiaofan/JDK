/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

class MX6PlatformFactory extends NativePlatformFactory {

    @Override
    protected boolean matches() {
        boolean retval =
            new File("/sys/devices/platform/mxc_sdc_fb.0").exists() ||
            new File("/sys/bus/platform/drivers/mxc_sdc_fb").exists();
        return retval;
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
        return new MX6Platform();
    }

}
