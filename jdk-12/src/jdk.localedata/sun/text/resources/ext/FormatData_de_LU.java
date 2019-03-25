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
 */

/*
 * (C) Copyright IBM Corp. 1998 - All Rights Reserved
 *
 * The original version of this source code and documentation
 * is copyrighted and owned by IBM. These materials are provided under
 * terms of a License Agreement between IBM and Sun. This technology
 * is protected by multiple US and International patents.
 *
 * This notice and attribution to IBM may not be removed.
 *
 */

package sun.text.resources.ext;

import sun.util.resources.ParallelListResourceBundle;

public class FormatData_de_LU extends ParallelListResourceBundle {
    /**
     * Overrides ParallelListResourceBundle
     */
    protected final Object[][] getContents() {
        return new Object[][] {
            { "NumberPatterns",
                new String[] {
                    "#,##0.###;-#,##0.###", // decimal pattern
                    "#,##0.00 \u00A4;-#,##0.00 \u00A4", // currency pattern
                    "#,##0%" // percent pattern
                }
            },
        };
    }
}
