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
package com.sun.xml.internal.rngom.dt.builtin;

import com.sun.xml.internal.org.relaxng.datatype.DatatypeLibrary;
import com.sun.xml.internal.org.relaxng.datatype.DatatypeLibraryFactory;

import com.sun.xml.internal.rngom.xml.util.WellKnownNamespaces;

/**
 * {@link DatatypeLibraryFactory} for
 * RELAX NG Built-in datatype library and compatibility datatype library.
 */
public class BuiltinDatatypeLibraryFactory implements DatatypeLibraryFactory {
    private final DatatypeLibrary builtinDatatypeLibrary;
    private final DatatypeLibrary compatibilityDatatypeLibrary;
    /**
     * Target of delegation.
     */
    private final DatatypeLibraryFactory core;

    public BuiltinDatatypeLibraryFactory( DatatypeLibraryFactory coreFactory ) {
        builtinDatatypeLibrary = new BuiltinDatatypeLibrary(coreFactory);
        compatibilityDatatypeLibrary = new CompatibilityDatatypeLibrary(coreFactory);
        this.core = coreFactory;
    }

    public DatatypeLibrary createDatatypeLibrary(String uri) {
        if (uri.equals(""))
            return builtinDatatypeLibrary;
        if (uri.equals(WellKnownNamespaces.RELAX_NG_COMPATIBILITY_DATATYPES))
            return compatibilityDatatypeLibrary;
        return core.createDatatypeLibrary(uri);
    }
}
