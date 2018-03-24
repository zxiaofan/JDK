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

package com.sun.xml.internal.bind.v2.runtime.property;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.bind.v2.model.core.PropertyKind;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimeAttributePropertyInfo;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimeElementPropertyInfo;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimeNonElement;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimePropertyInfo;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimeTypeInfo;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimeValuePropertyInfo;
import com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl;

/**
 * Create {@link Property} objects.
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public abstract class PropertyFactory {
    private PropertyFactory() {}


    /**
     * Constructors of the {@link Property} implementation.
     */
    private static final Constructor<? extends Property>[] propImpls;

    static {
        Class<? extends Property>[] implClasses = new Class[] {
            SingleElementLeafProperty.class,
            null, // single reference leaf --- but there's no such thing as "reference leaf"
            null, // no such thing as "map leaf"

            ArrayElementLeafProperty.class,
            null, // array reference leaf --- but there's no such thing as "reference leaf"
            null, // no such thing as "map leaf"

            SingleElementNodeProperty.class,
            SingleReferenceNodeProperty.class,
            SingleMapNodeProperty.class,

            ArrayElementNodeProperty.class,
            ArrayReferenceNodeProperty.class,
            null, // map is always a single property (Map doesn't implement Collection)
        };

        propImpls = new Constructor[implClasses.length];
        for( int i=0; i<propImpls.length; i++ ) {
            if(implClasses[i]!=null)
                // this pointless casting necessary for Mustang
                propImpls[i] = (Constructor)implClasses[i].getConstructors()[0];
        }
    }

    /**
     * Creates/obtains a properly configured {@link Property}
     * object from the given description.
     */
    public static Property create( JAXBContextImpl grammar, RuntimePropertyInfo info ) {

        PropertyKind kind = info.kind();

        switch(kind) {
        case ATTRIBUTE:
            return new AttributeProperty(grammar,(RuntimeAttributePropertyInfo)info);
        case VALUE:
            return new ValueProperty(grammar,(RuntimeValuePropertyInfo)info);
        case ELEMENT:
            if(((RuntimeElementPropertyInfo)info).isValueList())
                return new ListElementProperty(grammar,(RuntimeElementPropertyInfo) info);
            break;
        case REFERENCE:
        case MAP:
            break;
        default:
            assert false;
        }


        boolean isCollection = info.isCollection();
        boolean isLeaf = isLeaf(info);

        Constructor<? extends Property> c = propImpls[(isLeaf?0:6)+(isCollection?3:0)+kind.propertyIndex];
        try {
            return c.newInstance( grammar, info );
        } catch (InstantiationException e) {
            throw new InstantiationError(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new IllegalAccessError(e.getMessage());
        } catch (InvocationTargetException e) {
            Throwable t = e.getCause();
            if(t instanceof Error)
                throw (Error)t;
            if(t instanceof RuntimeException)
                throw (RuntimeException)t;

            throw new AssertionError(t);
        }
    }

    /**
     * Look for the case that can be optimized as a leaf,
     * which is a kind of type whose XML representation is just PCDATA.
     */
    static boolean isLeaf(RuntimePropertyInfo info) {
        Collection<? extends RuntimeTypeInfo> types = info.ref();
        if(types.size()!=1)     return false;

        RuntimeTypeInfo rti = types.iterator().next();
        if(!(rti instanceof RuntimeNonElement)) return false;

        if(info.id()==ID.IDREF)
            // IDREF is always handled as leaf -- Transducer maps IDREF String back to an object
            return true;

        if(((RuntimeNonElement)rti).getTransducer()==null)
            // Transducer!=null means definitely binds to PCDATA.
            // even if transducer==null, a referene might be IDREF,
            // in which case it will still produce PCDATA in this reference.
            return false;

        if(!info.getIndividualType().equals(rti.getType()))
            return false;

        return true;
    }
}
