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

package com.sun.tools.internal.ws.processor.model.jaxb;

import com.sun.tools.internal.xjc.api.Mapping;
import com.sun.tools.internal.xjc.api.Property;
import com.sun.tools.internal.xjc.api.TypeAndAnnotation;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kohsuke Kawaguchi, Vivek Pandey
 */
public class JAXBMapping {

    /**
     * @see Mapping#getElement()
     */
    private QName elementName;

    /**
     *
     */
    private JAXBTypeAndAnnotation type;

    /**
     * @see Mapping#getWrapperStyleDrilldown()
     */
    private List<JAXBProperty> wrapperStyleDrilldown;

    /**
     * Default constructor for the persistence.
     */
    public JAXBMapping() {}

    /**
     * Constructor that fills in the values from the given raw model
     */
    JAXBMapping( com.sun.tools.internal.xjc.api.Mapping rawModel ) {
        elementName = rawModel.getElement();
        TypeAndAnnotation typeAndAnno = rawModel.getType();
        type = new JAXBTypeAndAnnotation(typeAndAnno);
        List<? extends Property> list = rawModel.getWrapperStyleDrilldown();
        if(list==null)
            wrapperStyleDrilldown = null;
        else {
            wrapperStyleDrilldown = new ArrayList<JAXBProperty>(list.size());
            for( Property p : list )
                wrapperStyleDrilldown.add(new JAXBProperty(p));
        }

    }

    /**
     * @see Mapping#getElement()
     */
    public QName getElementName() {
        return elementName;
    }

    public void setElementName(QName elementName) {
        this.elementName = elementName;
    }


    public JAXBTypeAndAnnotation getType() {
        return type;
    }

    /**
     * @see Mapping#getWrapperStyleDrilldown()
     */
    public List<JAXBProperty> getWrapperStyleDrilldown() {
        return wrapperStyleDrilldown;
    }
}
