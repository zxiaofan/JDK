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

public class CollationData_tr extends ListResourceBundle {

    protected final Object[][] getContents() {
        return new Object[][] {
            { "Rule",
                "& A < a\u0308 , A\u0308 "   // a-umlaut sorts between a and b
                + "& C < c\u0327 , C\u0327 " // c-cedilla sorts between c and d
                + "& G < g\u0306 , G\u0306 " // g-breve sorts between g and h
                + "& H < \u0131 , I "  // dotless i, I
                + "& I < i , \u0130 "  // dotted i, I
                + "< \u0132 , \u0133 "       // ij ligature sorts between i and j
                + "& O < o\u0308 , O\u0308 " // o-umlaut sorts between o and p
                + "& S < s\u0327 , S\u0327 " // s-cedilla sorts between s and t
                + "& U < u\u0308 , U\u0308 " // u-umlaut sorts between u and v
            }
        };
    }
}
