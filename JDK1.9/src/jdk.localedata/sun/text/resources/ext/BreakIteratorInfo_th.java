/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Licensed Materials - Property of IBM
 *
 * (C) Copyright IBM Corp. 1999 All Rights Reserved.
 * (C) IBM Corp. 1997-1998.  All Rights Reserved.
 *
 * The program is provided "as is" without any warranty express or
 * implied, including the warranty of non-infringement and the implied
 * warranties of merchantibility and fitness for a particular purpose.
 * IBM will not be liable for any damages suffered by you as a result
 * of using the Program. In no event will IBM be liable for any
 * special, indirect or consequential damages or lost profits even if
 * IBM has been advised of the possibility of their occurrence. IBM
 * will not be liable for any third party claims against you.
 */

package sun.text.resources.ext;

import java.util.ListResourceBundle;

public class BreakIteratorInfo_th extends ListResourceBundle {
    protected final Object[][] getContents() {
        return new Object[][] {
            // BreakIteratorClasses lists the class names to instantiate for each
            // built-in type of BreakIterator
            {"BreakIteratorClasses",
                new String[] {
                    "RuleBasedBreakIterator",  // character-break iterator class
                    "DictionaryBasedBreakIterator",  // word-break iterator class
                    "DictionaryBasedBreakIterator",  // line-break iterator class
                    "RuleBasedBreakIterator"   // sentence-break iterator class
                }
            },

            // Data filename for each break-iterator
            {"WordData", "WordBreakIteratorData_th"},
            {"LineData", "LineBreakIteratorData_th"},

            // Dictionary filename for each dictionary-based break-iterator
            {"WordDictionary", "thai_dict"},
            {"LineDictionary", "thai_dict"},
        };
    }
}
