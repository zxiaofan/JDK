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

package com.sun.xml.internal.bind.v2.runtime.unmarshaller;

import java.util.HashMap;
import java.util.concurrent.Callable;

import javax.xml.bind.ValidationEventHandler;

import com.sun.xml.internal.bind.IDResolver;

import org.xml.sax.SAXException;

/**
 * Default implementation of {@link IDResolver}.
 *
 * @author Kohsuke Kawaguchi
 */
final class DefaultIDResolver extends IDResolver {
    /** Records ID->Object map. */
    private HashMap<String,Object> idmap = null;

    @Override
    public void startDocument(ValidationEventHandler eventHandler) throws SAXException {
        if(idmap!=null)
            idmap.clear();
    }

    @Override
    public void bind(String id, Object obj) {
        if(idmap==null)     idmap = new HashMap<String,Object>();
        idmap.put(id,obj);
    }

    @Override
    public Callable resolve(final String id, Class targetType) {
        return new Callable() {
            public Object call() throws Exception {
                if(idmap==null)     return null;
                return idmap.get(id);
            }
        };
    }
}
