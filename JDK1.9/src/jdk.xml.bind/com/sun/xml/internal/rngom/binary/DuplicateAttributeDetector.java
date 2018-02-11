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
 * Copyright (C) 2004-2011
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sun.xml.internal.rngom.binary;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.rngom.nc.NameClass;

class DuplicateAttributeDetector {
    private List nameClasses = new ArrayList();
    private Alternative alternatives = null;

    private static class Alternative {
        private int startIndex;
        private int endIndex;
        private Alternative parent;

        private Alternative(int startIndex, Alternative parent) {
            this.startIndex = startIndex;
            this.endIndex = startIndex;
            this.parent = parent;
        }
    }

    boolean addAttribute(NameClass nc) {
        int lim = nameClasses.size();
        for (Alternative a = alternatives; a != null; a = a.parent) {
            for (int i = a.endIndex; i < lim; i++)
                if (nc.hasOverlapWith((NameClass) nameClasses.get(i)))
                    return false;
            lim = a.startIndex;
        }
        for (int i = 0; i < lim; i++)
            if (nc.hasOverlapWith((NameClass) nameClasses.get(i)))
                return false;
        nameClasses.add(nc);
        return true;
    }

    void startChoice() {
        alternatives = new Alternative(nameClasses.size(), alternatives);
    }

    void alternative() {
        alternatives.endIndex = nameClasses.size();
    }

    void endChoice() {
        alternatives = alternatives.parent;
    }

}
