/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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
 */

/*
 * (C) Copyright Taligent, Inc. 1996, 1997 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - 1998 - All Rights Reserved
 *
 * The original version of this source code and documentation
 * is copyrighted and owned by Taligent, Inc., a wholly-owned
 * subsidiary of IBM. These materials are provided under terms
 * of a License Agreement between Taligent and Sun. This technology
 * is protected by multiple US and International patents.
 *
 * This notice and attribution to Taligent may not be removed.
 * Taligent is a registered trademark of Taligent, Inc.
 *
 */

package sun.text.resources.ext;

import java.util.ListResourceBundle;

public class CollationData_no extends ListResourceBundle {

    protected final Object[][] getContents() {
        return new Object[][] {
            { "Rule",
                "& D <\u00D0,\u00F0" +      // eth
                "& ss,\u00DF" +             // s-zet
                "& y , u\u0308" +   // u-umlaut is eq. to y.
                "& y ; U\u0308" +  // u-umlaut is eq. to y.
                "& Z < \u00e6, \u00c6 " +    // z < z-caron
                " < a\u0308, A\u0308" +      // nt : a-umlaut
                "< \u00f8, \u00d8 < o\u0308, O\u0308" + // nt : o-stroke < o-umlaut
                "< o\u030b, O\u030b " +      // nt : o-double-acute
                "< a\u030a, A\u030a" +       // nt : a-ring
                ", aa , aA , Aa , AA " +         // tal : aa ligature sorts after a-ring
                " & V < w, W "
            }
        };
    }
}
