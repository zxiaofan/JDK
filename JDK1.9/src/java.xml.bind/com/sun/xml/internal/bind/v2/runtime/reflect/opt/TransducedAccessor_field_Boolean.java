/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime.reflect.opt;

import com.sun.xml.internal.bind.DatatypeConverterImpl;
import com.sun.xml.internal.bind.v2.runtime.reflect.DefaultTransducedAccessor;
import com.sun.xml.internal.bind.v2.runtime.reflect.TransducedAccessor;

/**
 * Template {@link TransducedAccessor} for a boolean field.
 *
 * <p>
 * All the TransducedAccessor_field are generated from <code>TransducedAccessor_field_B y t e</code>
 *
 * @author Kohsuke Kawaguchi
 *
 * @see TransducedAccessor#get
 */
public final class TransducedAccessor_field_Boolean extends DefaultTransducedAccessor {
    public String print(Object o) {
        return DatatypeConverterImpl._printBoolean( ((Bean)o).f_boolean );
    }

    public void parse(Object o, CharSequence lexical) {
        Boolean b = DatatypeConverterImpl._parseBoolean(lexical);

        if(b != null)
            ((Bean)o).f_boolean=b;
    }

    public boolean hasValue(Object o) {
        return true;
    }
}
