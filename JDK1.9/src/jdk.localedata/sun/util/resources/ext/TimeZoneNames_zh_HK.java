/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

/*
 * (C) Copyright Taligent, Inc. 1996 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - All Rights Reserved
 *
 *   The original version of this source code and documentation is copyrighted
 * and owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These
 * materials are provided under terms of a License Agreement between Taligent
 * and Sun. This technology is protected by multiple US and International
 * patents. This notice and attribution to Taligent may not be removed.
 *   Taligent is a registered trademark of Taligent, Inc.
 *
 */

package sun.util.resources.ext;

import java.util.Locale;
import java.util.ResourceBundle;
import sun.util.locale.provider.LocaleProviderAdapter;
import sun.util.locale.provider.ResourceBundleBasedAdapter;
import sun.util.resources.TimeZoneNamesBundle;

public final class TimeZoneNames_zh_HK extends TimeZoneNamesBundle {

    // reparent to zh_TW for traditional Chinese names
    public TimeZoneNames_zh_HK() {
        ResourceBundle bundle = ((ResourceBundleBasedAdapter)LocaleProviderAdapter.forJRE()).getLocaleData().getTimeZoneNames(Locale.TAIWAN);
        setParent(bundle);
    }

    @Override
    protected Object[][] getContents() {
        return new Object[][] {};
    }
}
