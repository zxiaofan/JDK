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

public class CollationData_sr_Latn extends ListResourceBundle {

    protected final Object[][] getContents() {
        return new Object[][] {
            { "Rule",
                /* for sr-Latin, default sorting except for the following: */

                /* add dz "ligature" between d and d<stroke>. */
                /* add d<stroke> between d and e. */
                /* add lj "ligature" between l and l<stroke>. */
                /* add l<stroke> between l and m. */
                /* add nj "ligature" between n and o. */
                /* add z<abovedot> after z.       */
                "& \u200f = \u030c "
                + "& \u0306 = \u030d "
                + "& C < c\u030c , C\u030c "  // C < c-caron
                + "< c\u0301 , C\u0301 "      // c-acute
                + "& D < \u01f3 , \u01f2 , \u01f1 "  // dz
                + "< dz , dZ , Dz , DZ "      // dz ligature
                + "< \u01c6 , \u01c5 , \u01c4 "  // dz-caron
                + "< \u0111 , \u0110 "           // d-stroke
                + "& L < lj , lJ , Lj , LJ " // l < lj ligature
                + "& N < nj , nJ , Nj , NJ " // n < nj ligature
                + "& S < s\u030c , S\u030c "  // s < s-caron
                + "& Z < z\u030c , Z\u030c "  // z < z-caron
            }
        };
    }
}
