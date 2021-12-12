/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.text.resources.ext;

import java.util.ResourceBundle;
import sun.util.resources.BreakIteratorResourceBundle;

public class BreakIteratorResources_th extends BreakIteratorResourceBundle {
    @Override
    protected ResourceBundle getBreakIteratorInfo() {
        return new BreakIteratorInfo_th();
    }
}
