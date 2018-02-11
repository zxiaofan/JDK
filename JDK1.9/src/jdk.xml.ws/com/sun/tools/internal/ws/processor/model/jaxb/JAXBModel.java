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

import com.sun.tools.internal.xjc.api.J2SJAXBModel;
import com.sun.tools.internal.xjc.api.Mapping;
import com.sun.tools.internal.xjc.api.S2JJAXBModel;

import javax.xml.namespace.QName;
import java.util.*;

/**
 * Root of the JAXB Model.
 *
 * <p>
 * This is just a wrapper around a list of {@link JAXBMapping}s.
 *
 * @author Kohsuke Kawaguchi, Vivek Pandey
 */
public class JAXBModel {

    /**
     * All the mappings known to this model.
     */
    private List<JAXBMapping> mappings;

    // index for faster access.
    private final Map<QName,JAXBMapping> byQName = new HashMap<QName,JAXBMapping>();
    private final Map<String,JAXBMapping> byClassName = new HashMap<String,JAXBMapping>();

    private com.sun.tools.internal.xjc.api.JAXBModel rawJAXBModel;

    public com.sun.tools.internal.xjc.api.JAXBModel getRawJAXBModel() {
        return rawJAXBModel;
    }

    /**
     * @return Schema to Java model
     */
    public S2JJAXBModel getS2JJAXBModel(){
        if(rawJAXBModel instanceof S2JJAXBModel)
            return (S2JJAXBModel)rawJAXBModel;
        return null;
    }

    /**
     * @return Java to Schema JAXBModel
     */
    public J2SJAXBModel getJ2SJAXBModel(){
        if(rawJAXBModel instanceof J2SJAXBModel)
            return (J2SJAXBModel)rawJAXBModel;
        return null;
    }


    /**
     * Default constructor for the persistence.
     */
    public JAXBModel() {}

    /**
     * Constructor that fills in the values from the given raw model
     */
    public JAXBModel( com.sun.tools.internal.xjc.api.JAXBModel rawModel ) {
        this.rawJAXBModel = rawModel;
        if(rawModel instanceof S2JJAXBModel){
            S2JJAXBModel model = (S2JJAXBModel)rawModel;
            List<JAXBMapping> ms = new ArrayList<JAXBMapping>(model.getMappings().size());
            for( Mapping m : model.getMappings())
                ms.add(new JAXBMapping(m));
            setMappings(ms);
        }
    }

    /**
     */
    public List<JAXBMapping> getMappings() {
        return mappings;
    }

    //public void setMappings(List<JAXBMapping> mappings) {
    public void setMappings(List<JAXBMapping> mappings) {
        this.mappings = mappings;
        byQName.clear();
        byClassName.clear();
        for( JAXBMapping m : mappings ) {
            byQName.put(m.getElementName(),m);
            byClassName.put(m.getType().getName(),m);
        }
    }

    /**
     */
    public JAXBMapping get( QName elementName ) {
        return byQName.get(elementName);
    }

    /**
     */
    public JAXBMapping get( String className ) {
        return byClassName.get(className);
    }


    /**
     *
     * @return set of full qualified class names that jaxb will generate
     */
    public Set<String> getGeneratedClassNames() {
        return generatedClassNames;
    }

    public void setGeneratedClassNames(Set<String> generatedClassNames) {
        this.generatedClassNames = generatedClassNames;
    }

    private Set<String> generatedClassNames;
}
