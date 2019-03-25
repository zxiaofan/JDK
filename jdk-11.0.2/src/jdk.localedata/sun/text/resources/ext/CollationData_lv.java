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

public class CollationData_lv extends ListResourceBundle {

    protected final Object[][] getContents() {
        return new Object[][] {
            { "Rule",
                /* for lv, accents sorted backwards plus the following: */

                "@" /* sort accents bkwd */
                + "& C < c\u030c , C\u030c "  // C < c-caron
                + "& G < g\u0327 , G\u0327 "  // G < g-cedilla
                + "& I < y, Y"                // tal : i < y
                + "& K < k\u0327 , K\u0327 "  // K < k-cedilla
                + "& L < l\u0327 , L\u0327 "  // L < l-cedilla
                + "& N < n\u0327 , N\u0327 "  // N < n-cedilla
                + "& S < s\u030c , S\u030c "  // S < s-caron
                + "& Z < z\u030c , Z\u030c "  // Z < z-caron
            }
        };
    }
}
