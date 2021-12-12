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

public class CollationData_lt extends ListResourceBundle {

    protected final Object[][] getContents() {
        return new Object[][] {
            { "Rule",
                /* for lt, accents sorted backwards plus the following: */
                "@" +                                     // tal : french secondary
                "& C < c\u030c , C\u030c " +              // nt : open-o < c-caron
                "& I ; y = \u0131 , Y = \u0130 " +        // nt : i is equivalent to y
                "& S < s\u030c , S\u030c " +              // nt : long-s < s-caron
                "& X < y\u0301, Y\u0301 "+                // nt : x < y-acute
                "< y\u0302 , Y\u0302 < y\u0308, Y\u0308 " + // nt : y-circumflex < y-umlaut
                "& Z < z\u030c , Z\u030c "                // nt : ezh-tail < z-caron
            }
        };
    }
}
