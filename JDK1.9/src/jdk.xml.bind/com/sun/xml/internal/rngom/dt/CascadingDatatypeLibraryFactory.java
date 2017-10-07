/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.xml.internal.rngom.dt;

import com.sun.xml.internal.org.relaxng.datatype.DatatypeLibrary;
import com.sun.xml.internal.org.relaxng.datatype.DatatypeLibraryFactory;

/**
 *
 *
 * @author
 *      Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public class CascadingDatatypeLibraryFactory implements DatatypeLibraryFactory {
    private final DatatypeLibraryFactory factory1;
    private final DatatypeLibraryFactory factory2;

    public CascadingDatatypeLibraryFactory( DatatypeLibraryFactory factory1, DatatypeLibraryFactory factory2) {
        this.factory1 = factory1;
        this.factory2 = factory2;
    }

    public DatatypeLibrary createDatatypeLibrary(String namespaceURI) {
        DatatypeLibrary lib = factory1.createDatatypeLibrary(namespaceURI);
        if(lib==null)
            lib = factory2.createDatatypeLibrary(namespaceURI);
        return lib;
    }

}
