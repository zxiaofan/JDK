/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime.property;


import com.sun.xml.internal.bind.api.AccessorException;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimePropertyInfo;
import com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;


/**
 * {@link Property} implementation for multi-value properties
 * (including arrays and collections.)
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
abstract class ArrayProperty<BeanT,ListT,ItemT> extends PropertyImpl<BeanT> {
    protected final Accessor<BeanT,ListT> acc;
    protected final Lister<BeanT,ListT,ItemT,Object> lister;

    protected ArrayProperty(JAXBContextImpl context, RuntimePropertyInfo prop) {
        super(context,prop);

        assert prop.isCollection();
        lister = Lister.create(
            Utils.REFLECTION_NAVIGATOR.erasure(prop.getRawType()),prop.id(),prop.getAdapter());
        assert lister!=null;
        acc = prop.getAccessor().optimize(context);
        assert acc!=null;
    }

    public void reset(BeanT o) throws AccessorException {
        lister.reset(o,acc);
    }

    public final String getIdValue(BeanT bean) {
        // mutli-value property can't be ID
        return null;
    }
}
