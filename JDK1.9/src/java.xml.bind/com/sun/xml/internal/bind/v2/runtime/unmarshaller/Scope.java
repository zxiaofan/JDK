/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.xml.internal.bind.api.AccessorException;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import org.xml.sax.SAXException;

/**
 * Holds the information about packing scope.
 *
 * <p>
 * When no packing is started yet, all the fields should be set to null.
 *
 * @author Kohsuke Kawaguchi
 */
public final class Scope<BeanT,PropT,ItemT,PackT> {

    public final UnmarshallingContext context;

    private BeanT bean;
    private Accessor<BeanT,PropT> acc;
    private PackT pack;
    private Lister<BeanT,PropT,ItemT,PackT> lister;

    Scope(UnmarshallingContext context) {
        this.context = context;
    }

    /**
     * Returns true if this scope object is filled by a packing in progress.
     */
    public boolean hasStarted() {
        return bean!=null;
    }

    /**
     * Initializes all the fields to null.
     */
    public void reset() {
        if(bean==null) {
            // already initialized
            assert clean();
            return;
        }

        bean = null;
        acc = null;
        pack = null;
        lister = null;
    }

    /**
     * Finishes up the current packing in progress (if any) and
     * resets this object.
     */
    public void finish() throws AccessorException {
        if(hasStarted()) {
            lister.endPacking(pack,bean,acc);
            reset();
        }
        assert clean();
    }

    private boolean clean() {
        return bean==null && acc==null && pack==null && lister==null;
    }

    /**
     * Adds a new item to this packing scope.
     */
    public void add( Accessor<BeanT,PropT> acc, Lister<BeanT,PropT,ItemT,PackT> lister, ItemT value) throws SAXException{
        try {
            if(!hasStarted()) {
                this.bean = (BeanT)context.getCurrentState().getTarget();
                this.acc = acc;
                this.lister = lister;
                this.pack = lister.startPacking(bean,acc);
            }

            lister.addToPack(pack,value);
        } catch (AccessorException e) {
            Loader.handleGenericException(e,true);
            // recover from this error by ignoring future items.
            this.lister = Lister.getErrorInstance();
            this.acc = Accessor.getErrorInstance();
        }
    }

    /**
     * Starts the packing scope, without adding any item.
     *
     * This allows us to return an empty pack, thereby allowing the user
     * to distinguish empty array vs null array.
     */
    public void start( Accessor<BeanT,PropT> acc, Lister<BeanT,PropT,ItemT,PackT> lister) throws SAXException{
        try {
            if(!hasStarted()) {
                this.bean = (BeanT)context.getCurrentState().getTarget();
                this.acc = acc;
                this.lister = lister;
                this.pack = lister.startPacking(bean,acc);
            }
        } catch (AccessorException e) {
            Loader.handleGenericException(e,true);
            // recover from this error by ignoring future items.
            this.lister = Lister.getErrorInstance();
            this.acc = Accessor.getErrorInstance();
        }
    }
}
